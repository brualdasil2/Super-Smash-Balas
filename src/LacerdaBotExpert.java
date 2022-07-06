
public class LacerdaBotExpert extends Player{
	
	private int state, rand, frameCounter = 0, shieldDelayFrames = 0, opHealthBeforeJuggle;
	private boolean[] last3jugglesEscaped = {false, false, false};
	private boolean opponentNear, opponentOnAir, opponentOnTop, opponentOnLeft, opponentOnRight, opponentAttacking, opponentShielding, opponentProjectileComing,
					onCenter, opponentRising, opponentFalling, juggling = false, juggled = false, onTopOfOpponent, falling, triedToJuggle = false, fakedJuggle = false, nearRose = false, roseOnLeft = false, roseOnRight = false;
	private double centerX,  distToFrontWall, distToBackWall, distXToProjectile, distYToProjectile;
	private LacerdaCombos combos = new LacerdaCombos(this);

	
	public LacerdaBotExpert(Game game, int playerNumb, Character character, double x, double y) {
		
		super(game, playerNumb, character, x, y, "BOT (X)");
	}
	
	
	private int framesToPunish(boolean oos) {
		AttackFrame attackFrames[] = opponent.getCurrentAttack().getFrames().clone();
		int uF = opponent.character.attackUF;
		int framesPunish = 0;
		
		for (int i = uF; i < opponent.getCurrentAttack().getUniqueFrames(); i++) {
			if (!oos) {
				if (attackFrames[i].getHitboxes() != null || attackFrames[i].getCounterboxes() != null) {
					return 0;
				}
			}

			//System.out.println("Added " + attackFrames[i].getDuration() + " frames.");
			framesPunish += attackFrames[i].getDuration();
		}
		
		//System.out.println("Subtracted " + opponent.character.attackIF + " frames.");
		return (framesPunish - opponent.character.attackIF + 1); //+1 because of one extra frame to shield after
	}
	
	private int framesTillFirstHit() {
		AttackFrame attackFrames[] = opponent.getCurrentAttack().getFrames().clone();
		int uF = opponent.character.attackUF;
		int framesToHit = 0;
		
		for (int i = uF; i < opponent.getCurrentAttack().getUniqueFrames(); i++) {
		
			if (attackFrames[i].getHitboxes() != null) {
				return (framesToHit - opponent.character.attackIF + 1);
			}

			framesToHit += attackFrames[i].getDuration();
		}
		
		return 0;
	}
	
	private int getChanceOfEscaping() {
		int chance = 0;
		for (boolean item: last3jugglesEscaped) {
			if (item)
				chance++;
		}
		return chance;
	}
	
	private void addOpponentEscapeOption(boolean escaped) {
		last3jugglesEscaped[0] = last3jugglesEscaped[1];
		last3jugglesEscaped[1] = last3jugglesEscaped[2];
		last3jugglesEscaped[2] = escaped;
		//System.out.println("Added " + escaped + " as new escape option. New chance: " + getChanceOfEscaping());
	}
	

	
	private void checkState() {
		
		centerX = x + 100;
		distToFrontWall = getLookDirection() == 0 ? Math.abs(centerX - GameState.leftWall) : Math.abs(centerX - GameState.rightWall);
		distToBackWall = getLookDirection() == 1 ? Math.abs(centerX - GameState.leftWall) : Math.abs(centerX - GameState.rightWall);
		
		if (opponent.character instanceof Carol || opponent.character instanceof Obino)
			opponentNear = (Math.abs(opponent.x - x) < 350);
		else
			opponentNear = (Math.abs(opponent.x - x) < 250);
		opponentOnAir = opponent.onAir;
		opponentOnTop = (Math.abs(opponent.x - x) < 200 && opponent.y < (juggling ? 250 : 100) && opponent.y < y);
		onTopOfOpponent = (Math.abs(opponent.x - x) < 200 && y < (juggled ? 250 : 100) && y < opponent.y);
		opponentOnLeft = (opponent.x - x < 0);
		opponentOnRight = (opponent.x - x > 0);
		opponentAttacking = opponent.attacking;
		opponentShielding = (opponent.shielding && !opponent.onAir && opponent.shield > 0);
		
		opponentRising = (opponent.ySpeed < 0 && opponent.freezeFrames == 0);
		opponentFalling = (opponent.ySpeed > 0);
		falling = ySpeed > 0;
		
	/*	if (opponent.jumps > 0 && opponent.pressingJump && !jumpClicked) {
			opponentJumped = true;
		}
		else {
			opponentJumped = false;
		}*/
		
		onCenter = (x + currentFrame.getWidth()/2 > 590 && x + currentFrame.getWidth()/2 < 690);
		
		distXToProjectile = 10000;
		distYToProjectile = 10000;
		opponentProjectileComing = false;
		nearRose = false;
		roseOnLeft = false;
		roseOnRight = false;
		
		for (int i = 0; i < GameState.projectiles.size(); i++) {
			
			if (GameState.projectiles.get(i) instanceof Bala || GameState.projectiles.get(i) instanceof Nota || GameState.projectiles.get(i) instanceof SnowBall || GameState.projectiles.get(i) instanceof Halls) {
				
				if (!GameState.projectiles.get(i).getOwner().equals(this)) {
					
					if ((x - GameState.projectiles.get(i).getX() < 0) == (GameState.projectiles.get(i).getXSpeed() < 0)) {
						
						
						opponentProjectileComing = true;
						double distX = Math.abs(centerX - (GameState.projectiles.get(i).getX() + GameState.projectiles.get(i).getWidth()/2));
						double distY = (y - (GameState.projectiles.get(i).getY() + GameState.projectiles.get(i).getHeight()/2));
						if (distX < distXToProjectile) {
							distXToProjectile = distX;
							distYToProjectile = distY;
						}
					}
				}
			}
			else if (GameState.projectiles.get(i) instanceof Rosa) {
				if (Math.abs(centerX - (GameState.projectiles.get(i).getX() + GameState.projectiles.get(i).getWidth()/2)) < 200) {
					nearRose = true;
					if (centerX - (GameState.projectiles.get(i).getX() + GameState.projectiles.get(i).getWidth()/2) > 0) {
						roseOnLeft = true;
					}
					else {
						roseOnRight = true;
					}
				}
			}
		}
		
		
		
	}
		
	
	
	private void pressNothing() {
		
		pressingJump = false;
		pressingAttack = false;
		pressingSpecial = false;
		pressingUp = false;
		pressingShield = false;
		pressingLeft = false;
		pressingRight = false;
	}
	
	private void setState(int state) {
		
		if (this.state != state) {
				if (this.state == 11) {
					
					if (triedToJuggle) {
						if (opponent.getHealth() < opHealthBeforeJuggle) {
							addOpponentEscapeOption(false);
						}
						else {
							addOpponentEscapeOption(true);
						}
					}
					else {
						fakedJuggle = true;
						if (state == 9 || state == 10) {
							addOpponentEscapeOption(true);
						}
						else {
							addOpponentEscapeOption(false);
						}
					}
				}

			this.state = state;
			frameCounter = 0;
			//System.out.println("New state: " + this.state);
		}
	}
	
	private void setFrames(int frames) {
		
		if (frameCounter == 0)
			frameCounter = frames;
		
		frameCounter--;
	}
	
	private void randomize(int max) {
		
		if (frameCounter == 0)
			rand = (int)(1 + Math.random()*max);
	}
	
	private void shield() {
		
		if (frameCounter == 0)
			frameCounter = 1;
		
		pressingShield = true;
	}
	
	private void timeParry() {
		if (framesTillFirstHit() > 3) {
			turnToOpponent();
		}
		else {
			shield();
		}
	}
	
	private void timeReflect() {
		
		//System.out.println(distXToProjectile + " " + distYToProjectile);
		
		if (shieldDelayFrames > 0) {
			shieldDelayFrames--;
			pressingShield = true;
		}
		else {
			if (distXToProjectile > 100) {
				turnToOpponent();
			}
			else {
				if (distYToProjectile > 40) {
					turnToOpponent();
				}
				else {
					shieldDelayFrames = 2;
					pressingShield = true;
				}
			}
		}
	}
	
	private void stand() {
		
		setFrames(30);
	}
	
	private void diLeft() {
		if (frameCounter == 0)
			frameCounter = 1;
		
		pressingLeft = true;
	}
	
	private void diRight() {
		if (frameCounter == 0)
			frameCounter = 1;
		
		pressingRight = true;
	}
	
	private void dashAwayFromRose() {
		
		setFrames(20);
		
		if (roseOnLeft)
			pressingRight = true;
		if (roseOnRight)
			pressingLeft = true;
	}
	
	private void dashAway() {
		
		setFrames(20);
		
		if (opponentOnLeft)
			pressingRight = true;
		if (opponentOnRight)
			pressingLeft = true;
	}
	
	private void dashRight() {
		
		setFrames(20);
		pressingRight = true;	
	}
	
	private void dashLeft() {
		
		setFrames(20);
		pressingLeft = true;
	}
	
	private void goToCenter() {
		
		setFrames(30);
		
		if (x + currentFrame.getWidth()/2 > 640) {
			
			pressingLeft = true;
		}
		
		if (x + currentFrame.getWidth()/2 < 640) {
			
			pressingRight = true;
		}
	}
	
	private void goToOpponent() {
		
		setFrames(60);
		
		if (opponentOnLeft) {
			
			pressingLeft = true;
		}
		
		if (opponentOnRight) {
			
			pressingRight = true;
		}
	}
	
	private void turnToOpponent() {
		
		if (opponentOnLeft)
			pressingLeft = true;	
		if (opponentOnRight)
			pressingRight = true;
	}
	
	private void turnAway() {
		
		if (opponentOnLeft)
			pressingRight = true;	
		if (opponentOnRight)
			pressingLeft = true;
	}
	
	
	private void jump() {
		
		pressingJump = true;
	}
	
	private void jab() {
		
		setFrames(4);
		
		if (frameCounter == 3 || frameCounter == 2) {
			
			turnToOpponent();
		}
		
		if (frameCounter == 1) {
			
			pressingAttack = true;
		}
		
		if (frameCounter == 0) {
			if (defended)
				defended = false;
			if (parried)
				parried = false;
		}
	}
	
	private void dashAttack() {
		
		setFrames(3);
		
		if (frameCounter == 2 || frameCounter == 1) {
			turnToOpponent();
			pressingAttack = true;
		}
		
		if (frameCounter == 0) {
			if (defended)
				defended = false;
			if (parried)
				parried = false;
		}
	}
	
	private void upTilt() {
		
		setFrames(4);
		
		if (frameCounter == 3) {
			
			turnToOpponent();
		}
		
		if (frameCounter == 2) {
			pressingUp = true;
			pressingAttack = true;
		}
		
		if (frameCounter == 0) {
			if (defended)
				defended = false;
			if (parried)
				parried = false;
		}
		
	}
	
	
	private void jumpBair() {
		
		setFrames(20);
		
		if (frameCounter == 19) {
			
			turnAway();
		}
		
		if (frameCounter == 18) {
			
			pressingJump = true;
		}
		
		if (frameCounter == 17) {
			
			pressingAttack = true;
			turnToOpponent();
		}
		
		if (frameCounter <= 16) {
			
			turnToOpponent();
		}
	}
	
	private void jumpUpAir(boolean hit) {
		
		setFrames(30);
		
		if (frameCounter >= 29) {
			
			pressingJump = true;
			turnToOpponent();
			opHealthBeforeJuggle = opponent.getHealth();
			//System.out.println(getChanceOfEscaping());
			triedToJuggle = hit;
			
		}
		
		else if (frameCounter >= 28) {
			
			if (hit) {
				pressingUp = true;
				pressingAttack = true;
			}
			turnToOpponent();
		}
		else if (frameCounter >= 0) {

			turnToOpponent();
			pressingShield = true;
		}
	}
	
	private void sideSpecial() {
		
		turnToOpponent();
		pressingSpecial = true;
		
		if (parried)
			parried = false;
	}
	
	private void jumpSideSpecial() {
		
		setFrames(10);
		
		if (frameCounter == 9) {
			
			pressingJump = true;
		}
		
		if (frameCounter == 0) {
			
			turnToOpponent();
			pressingSpecial = true;
		}
	}
	
	private void upSpecial() {
		
		setFrames(30);
		
		if (frameCounter == 29) {
			
			pressingUp = true;
			pressingSpecial = true;
		}
	}
	

	private void neutralSpecial() {
		
		pressingSpecial = true;
	}
	
	
	

	protected void getInput() {
		
		checkState();
		pressNothing();
		
		if (state != 9 && state != 10 && state != 11) {
			juggling = false;
			fakedJuggle = false;
		}
		if (state != 24 && state != 25 && state != 26 && state != 27) {
			juggled = false;
		}
		
		//System.out.println(state);
		if (combos.isComboing()) {
			combos.tick();
		}
		
		
		else {
			
			if (opponentNear) {
				
				//Juggled
				if (onTopOfOpponent) {
					juggled = true;
					
					if (y < -100) {
						if (!falling) {
							setState(24);
							
							randomize(5);
							if (rand <= 2)
								diLeft();
							if (rand > 2 && rand <= 4)
								diRight();
							if (rand > 4 && rand <= 5) {
								if (jumps == 0) {
									if (magic > 4)
										upSpecial();
								}
								else {
									jump();
								}
							}
						}
						else {
							setState(25);
							
							randomize(5);
							if (rand <= 1)
								diLeft();
							if (rand > 1 && rand <= 2)
								diRight();
							if (rand > 2 && rand <= 5)
								pressingShield = true;
						}
					}
					else {
						if (opponentAttacking) {
							setState(26);
							
							if (jumps > 0) {
								jump();
							}
							else {
								turnAway();
							}
						}
						else {
							setState(27);
							turnAway();
						}
					}
				}
				//Juggling
				else if (opponentOnTop) {
					
					juggling = true;
					
					if (shieldDelayFrames > 0) {
						shieldDelayFrames--;
						pressingShield = true;
					}
					else if (distXToProjectile <= 100 && distYToProjectile <= 40) {
						shieldDelayFrames = 2;
						pressingShield = true;
					}
				
					
					if (opponentRising) {
						setState(9);
						turnToOpponent();
						if (onAir) {
							pressingShield = true;
						}
						
					}
					else {
						if (opponent.y < -100) {
							setState(10);
							turnToOpponent();
						}
						else {
							setState(11);
							randomize(3);
							//System.out.println("Rand: " + rand);
							//System.out.println("Chance: " + getChanceOfEscaping());
							
							if (freezeFrames == 0) {
								if (fakedJuggle) {
									jumpUpAir(true);
									//System.out.println("Already faked juggle, attacking.");
								}
								else if (rand > getChanceOfEscaping()) {
									jumpUpAir(true);
									//System.out.println("Rand chose to attack.");
								}
								else {
									jumpUpAir(false);
									//System.out.println("Rando chose not to attack.");
								}
							}
						}
					}
				}
				else if (opponentAttacking) {
					
					//Out of shield
					if (!shieldStun && freezeFrames <= 1 && (defended || parried) && !opponentProjectileComing) {
						setState(0);
						
	
						if (parried) {
							if (opponentRising) {
								if (distToFrontWall < 470 && distToFrontWall > 170) {
									combos.startCombo(6); //risingBair
								}
								else {
									if (framesToPunish(true) >= 20)
										combos.startCombo(7); //fallingFair
									else {
										combos.startCombo(1);
										System.out.println("Cant do falling fair, only " + framesToPunish(true) + " frames to punish.");
									}
								}
							}
							else {
								combos.startCombo(1); //risingFair
							}
						}
						else {
							if (framesToPunish(true) >= 6) {
								combos.startCombo(1); //risingFair
							}
							else {
								//System.out.println("Cant punish oos, only " + framesToPunish(true) + " frames to punish.");
								defended = false;
								parried = false;
							}
						}	
					}
				
					else {
						
						if (opponentProjectileComing && !juggling) {
							
							setState(12);
							
							timeReflect();
							if (!(opponent.character instanceof Bruno && opponent.upSpecialing))
								timeParry();
						}
						else if (nearRose) {
							setState(27);
							
							dashAwayFromRose();
						}
						
						else if (onAir && !juggling) {
							//Specific combo escapes
							setState(1);
							
							if (opponent.character instanceof Lacerda) {
								
								if (opponent.dashing) {
									
									pressingJump = true;
									dashAway();
								}
								else if (opponent.upTilting) {
									
									if (jumps > 0)
										pressingJump = true;
									else {
										if (onCenter)
											dashAway();
										else {
											goToCenter();
										}
									}
								}
							}
							else if (opponent.character instanceof Bruno) {
								
								if (opponent.fairing) {
									
									if ((lookDirection == 0 && opponent.getX() < x) || (lookDirection == 1 && opponent.getX() > x)) {
										
										pressingAttack = true;
									}
									else {
										
										pressingJump = true;
										dashAway();
									}
								}
								else if (opponent.upTilting) {
									
									if (jumps > 0)
										pressingJump = true;
									else {
										if (onCenter)
											dashAway();
										else {
											goToCenter();
										}
									}
								}
							}
						}
						//Counter, tube and super wings punish
						else if ( !juggling && ((opponent.character instanceof Lacerda && ((opponent.neutralSpecialing && opponent.character.attackUF == 2) || (opponent.upSpecialing && opponent.character.attackUF == 10))) || (opponent.character instanceof Bruno && opponent.neutralSpecialing) || (opponent.character instanceof Carol && opponent.upSpecialing))) {
							
							setState(2);
							
							combos.startCombo(1);
						}
						
						else {
							//Block or whiff punish
							if (framesToPunish(false) > 13) {
								combos.startCombo(1);
							}
							else {
								if (shield > 0 && !(opponent.character instanceof Obino && opponent.sideSpecialing)) {
								
								
									setState(3);
									timeParry();
									
								}
								else {
									//No shield, run
									setState(4);
									
									pressingShield = false;
									dashAway();
								}
							}
						}
					}
				}
				//Neutral: opponent near and not attacking
				else if (!opponentAttacking) {
					
					if (opponentProjectileComing) {
						
						setState(12);
						
						timeReflect();
					}
					else if (nearRose) {
						setState(27);
						
						dashAwayFromRose();
					}
					//counter attack oos (for bruno up B)
					else if (!shieldStun && freezeFrames <= 1 && (defended || parried) && !opponentProjectileComing) {
						setState(0);
						
	
						if (parried) {
							if (opponentRising && distToFrontWall < 470 && distToFrontWall > 170) {
								combos.startCombo(6); //risingBair
							}
							else {
								combos.startCombo(1); //risingFair
							}
						}
						else {
							if (framesToPunish(true) >= 6) {
								combos.startCombo(1); //risingFair
							}
							else {
								//System.out.println("Cant punish oos, only " + framesToPunish(true) + " frames to punish.");
								defended = false;
								parried = false;
							}
						}	
					}
					
					else if (!opponentOnTop) {
						
						if (!opponentShielding) {
							
							if (magic >= 6) {
								
								setState(6);
								randomize(23);
								
								if (rand <= 1)
									jab();
								if (rand > 1 && rand <= 2)
									dashAttack();
								if (rand > 2 && rand <= 3)
									upTilt();
								if (rand > 3 && rand <= 6)
									combos.startCombo(1);
								if (rand > 6 && rand <= 7)
									jumpBair();
								if (rand > 7 && rand <= 9)
									dashAway();
								if (rand > 9 && rand <= 10)
									jump();
								if (rand > 10 && rand <= 11)
									sideSpecial();
								if (rand > 11 && rand <= 16)
									goToOpponent();
								if (rand > 16 && rand <= 23)
									stand();
							}
							
							else {
								
								setState(7);
								randomize(23);
								
								if (rand <= 1)
									jab();
								if (rand > 1 && rand <= 2)
									dashAttack();
								if (rand > 2 && rand <= 3)
									upTilt();
								if (rand > 3 && rand <= 6)
									combos.startCombo(1);
								if (rand > 6 && rand <= 7)
									jumpBair();
								if (rand > 7 && rand <= 9)
									dashAway();
								if (rand > 9 && rand <= 11)
									jump();
								if (rand > 11 && rand <= 16)
									goToOpponent();
								if (rand > 16 && rand <= 23)
									stand();
							}
						}
						
						else if (opponentShielding) {
							
							setState(8);
							randomize(10);
							
							if (rand <= 2)
								combos.startCombo(6);
							if (rand > 2 && rand <= 8)
								stand();
							if (rand > 8 && rand <= 9)
								dashAway();
							if (rand > 9 && rand <= 10)
								jump();
						}
					}
				}
			}
			//opponent far
			else if (!opponentNear) {
				
				if (opponentProjectileComing) {
				
					setState(12);
					
					timeReflect();
				}
				else if (nearRose) {
					setState(27);
					
					dashAwayFromRose();
				}
				else {
					
					if (!onCenter) {
						
						if (shield >= 20) {
							if (magic >= 4) {
								
								if (parried) {
									
									setState(13);
									sideSpecial();
								}
								else {
								
									setState(14);
									randomize(12);
									
									if (rand <= 2)
										goToCenter();
									if (rand > 2 && rand <= 3)
										dashLeft();
									if (rand > 3 && rand <= 4)
										dashRight();
									if (rand > 4 && rand <= 5)
										jump();
									if (rand > 5 && rand <= 10)
										goToOpponent();
									if (rand > 10 && rand <= 11)
										sideSpecial();
									if (rand > 11 && rand <= 12)
										jumpSideSpecial();
								}
							}
							
							else {
								
								setState(15);
								randomize(10);
								
								if (rand <= 2)
									goToCenter();
								if (rand > 2 && rand <= 3)
									dashLeft();
								if (rand > 3 && rand <= 4)
									dashRight();
								if (rand > 4 && rand <= 5)
									jump();
								if (rand > 5 && rand <= 10)
									goToOpponent();
							}
						}
						
						if (shield < 20) {
							
							if (magic >= 4) {
								
								if (parried) {
									
									setState(16);
									sideSpecial();
								}
								else {
								
									setState(17);
									randomize(20);
									
									if (rand <= 2)
										goToCenter();
									if (rand > 2 && rand <= 3)
										dashLeft();
									if (rand > 3 && rand <= 4)
										dashRight();
									if (rand > 4 && rand <= 5)
										jump();
									if (rand > 5 && rand <= 10)
										goToOpponent();
									if (rand > 10 && rand <= 11)
										sideSpecial();
									if (rand > 11 && rand <= 12)
										jumpSideSpecial();
									if (rand > 12 && rand <= 20)
										neutralSpecial();
								
								}
							}
							
							else if (magic > 0) {
								
								setState(18);
								randomize(15);
								
								if (rand <= 2)
									goToCenter();
								if (rand > 2 && rand <= 3)
									dashLeft();
								if (rand > 3 && rand <= 4)
									dashRight();
								if (rand > 4 && rand <= 5)
									jump();
								if (rand > 5 && rand <= 10)
									goToOpponent();
								if (rand > 10 && rand <= 15)
									neutralSpecial();
							}
							
							else {
								
								setState(19);
								randomize(10);
								
								if (rand <= 2)
									goToCenter();
								if (rand > 2 && rand <= 3)
									dashLeft();
								if (rand > 3 && rand <= 4)
									dashRight();
								if (rand > 4 && rand <= 5)
									jump();
								if (rand > 5 && rand <= 10)
									goToOpponent();
							}
						}
					}
					
					else if (onCenter) {
						
						if (GameState.magicBall.getGrabbable()) {
							
							setState(20);
							randomize(10);
							
							if (rand <= 8)
								jump();
							if (rand > 8 && rand <= 9)
								dashLeft();
							if (rand > 9 && rand <= 10)
								dashRight();
						}
						
						else if (!GameState.magicBall.getGrabbable()) {
							
							if (magic >= 4) {
								
								if (parried) {
									
									setState(21);
									sideSpecial();
								}
								else {
								
									setState(22);
									randomize(12);
									
									if (rand <= 2)
										stand();
									if (rand > 2 && rand <= 3)
										dashLeft();
									if (rand > 3 && rand <= 4)
										dashRight();
									if (rand > 4 && rand <= 5)
										jump();
									if (rand > 5 && rand <= 10)
										goToOpponent();
									if (rand > 10 && rand <= 11)
										sideSpecial();
									if (rand > 11 && rand <= 12)
										jumpSideSpecial();
								
								}
							}
							
							else {
								
								setState(23);
								randomize(10);
								
								if (rand <= 2)
									stand();
								if (rand > 2 && rand <= 3)
									dashLeft();
								if (rand > 3 && rand <= 4)
									dashRight();
								if (rand > 4 && rand <= 5)
									jump();
								if (rand > 5 && rand <= 10)
									goToOpponent();
							}
						}
					}
				}
			}
		}
	}
}



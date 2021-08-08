
public class BrunoBotExpert extends Player{
	
	private int state, rand, frameCounter = 0;
	private boolean opponentNear, opponentOnAir, opponentOnTop, opponentOnLeft, opponentOnRight, opponentAttacking, opponentShielding, opponentCandyComing,
					onCenter, opponentRising, opponentFalling;
	private double centerX,  distToFrontWall, distToBackWall;
	private BrunoCombos combos = new BrunoCombos(this);

	
	public BrunoBotExpert(Game game, int playerNumb, Character character, double x, double y) {
		
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
	
	
	private void checkState() {
		
		centerX = x + 100;
		distToFrontWall = getLookDirection() == 0 ? Math.abs(centerX - GameState.leftWall) : Math.abs(centerX - GameState.rightWall);
		distToBackWall = getLookDirection() == 1 ? Math.abs(centerX - GameState.leftWall) : Math.abs(centerX - GameState.rightWall);
		
		if (opponent.character instanceof Carol || opponent.character instanceof Obino)
			opponentNear = (Math.abs(opponent.x - x) < 350);
		else
			opponentNear = (Math.abs(opponent.x - x) < 250);
		opponentOnAir = opponent.onAir;
		opponentOnTop = (Math.abs(opponent.x - x) < 200 && opponent.y < 100 && opponent.y < y);
		opponentOnLeft = (opponent.x - x < 0);
		opponentOnRight = (opponent.x - x > 0);
		opponentAttacking = opponent.attacking;
		opponentShielding = (opponent.shielding && !opponent.onAir && opponent.shield > 0);
		
		opponentRising = (opponent.ySpeed < 0);
		opponentFalling = (opponent.ySpeed > 0);
		
		onCenter = (x + currentFrame.getWidth()/2 > 590 && x + currentFrame.getWidth()/2 < 690);
		
		for (int i = 0; i < GameState.projectiles.size(); i++) {
			
			if (GameState.projectiles.get(i) instanceof Bala || GameState.projectiles.get(i) instanceof Nota) {
				
				if (!GameState.projectiles.get(i).getOwner().equals(this)) {
					
					opponentCandyComing = true;
					break;
				}
				else {
					
					opponentCandyComing = false;
				}
			}
			else {
				
				opponentCandyComing = false;
			}
		}
		
		if (GameState.projectiles.isEmpty()) {
			
			opponentCandyComing = false;
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
			this.state = state;
			frameCounter = 0;
			System.out.println(state);
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
	
	private void stand() {
		
		setFrames(30);
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
	
	private void jumpFair() {
		
		
		setFrames(10);
		
		if (frameCounter == 9) {
			
			turnToOpponent();
		}
		
		if (frameCounter == 8) {
			
			pressingJump = true;
			turnToOpponent();
		}
		
		if (frameCounter == 7) {
			
			pressingAttack = true;
			turnToOpponent();
		}
		
		if (frameCounter <= 6) {
			
			turnToOpponent();
		}
		
		if (frameCounter == 2) {
		
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
	
	private void jumpUpAir() {
		
		setFrames(30);
		
		if (frameCounter >= 29) {
			
			pressingJump = true;
			turnToOpponent();
		}
		
		else if (frameCounter >= 28) {
			
			pressingUp = true;
			pressingAttack = true;
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
	
	private void jumpUpSpecial() {
		
		setFrames(30);
		
		if (frameCounter == 29) {
			
			pressingJump = true;
		}
		
		if (frameCounter == 20) {
			
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
		
		if (combos.isComboing()) {
			combos.tick();
		}
		
		else {
			
			if (opponentNear) {
				
				if (opponentAttacking) {
					
					//Out of shield
					if (!shieldStun && freezeFrames <= 1 && (defended || parried)) {
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
				
					else if (!(defended || parried)) {
						
						if (onAir) {
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
										dashAway();
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
										dashAway();
									}
								}
							}
						}
						//Lacerda Counter whiff punish
						else if ((opponent.character instanceof Lacerda && ((opponent.neutralSpecialing && opponent.character.attackUF == 2) || (opponent.upSpecialing && opponent.character.attackUF == 10))) || (opponent.character instanceof Bruno && opponent.neutralSpecialing) || (opponent.character instanceof Carol && opponent.upSpecialing)) {
							
							setState(2);
							
							dashAttack();
						}
						
						else {
							//Juggling
							if (opponentOnTop) {
								
								if (opponentRising) {
									setState(9);
									turnToOpponent();
								}
								else {
									if (opponent.y < -100) {
										setState(10);
										turnToOpponent();
									}
									else {
										setState(11);
										jumpUpAir();
									}
								}
							}
							else {
								//Block or punish
								if (framesToPunish(false) > 13) {
									combos.startCombo(1);
								}
								else {
									if (shield > 0) {
									
									
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
				}
				//Neutral: opponent near and not attacking
				else if (!opponentAttacking) {
					
					
					if (!opponentOnTop) {
						
						if (!opponentShielding) {
							
							if (magic >= 4) {
								
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
								if (rand > 9 && rand <= 12)
									jump();
								if (rand > 12 && rand <= 13)
									sideSpecial();
								if (rand > 13 && rand <= 17)
									goToOpponent();
								if (rand > 17 && rand <= 23)
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
								if (rand > 9 && rand <= 13)
									jump();
								if (rand > 13 && rand <= 17)
									goToOpponent();
								if (rand > 17 && rand <= 23)
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
					//Juggling
					else if (opponentOnTop) {
						
						if (opponentRising) {
							setState(9);
							turnToOpponent();
						}
						else {
							if (opponent.y < -100) {
								setState(10);
								turnToOpponent();
							}
							else {
								setState(11);
								jumpUpAir();
							}
						}
					}
				}
			}
			//opponent far
			else if (!opponentNear) {
				
				if (opponentCandyComing) {
				
					setState(12);
					
					shield();
				}
				else if (!opponentCandyComing) {
					
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



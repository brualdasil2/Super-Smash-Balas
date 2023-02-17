
public class SmashLacerdaBotHard extends SmashPlayer{
	
	private int state, rand, frameCounter = 0;
	private boolean opponentNear, opponentOnAir, opponentOnTop, opponentOnLeft, opponentOnRight, opponentAttacking, opponentShielding, opponentCandyComing,
					onCenter, offStageOnRight, offStageOnLeft, offStage;

	
	public SmashLacerdaBotHard(Game game, int playerNumb, Character character, double x, double y) {
		
		super(game, playerNumb, character, x, y, "BOT (D)");
	}
	
	private void checkState() {
		
		if (opponent.character instanceof Carol || opponent.character instanceof Obino)
			opponentNear = (Math.abs(opponent.x - x) < 350);
		else
			opponentNear = (Math.abs(opponent.x - x) < 250);
		opponentOnAir = opponent.onAir;
		opponentOnTop = (Math.abs(opponent.x - x) < 50 && opponentOnAir);
		opponentOnLeft = (opponent.x - x < 0);
		opponentOnRight = (opponent.x - x > 0);
		opponentAttacking = opponent.attacking;
		opponentShielding = (opponent.shielding && !opponent.onAir && opponent.shield > 0);
		
		onCenter = (x + currentFrame.getWidth()/2 > 590 && x + currentFrame.getWidth()/2 < 690);
		
		offStageOnRight = (x + currentFrame.getWidth()/2 > GameState.smashStageRight);
		offStageOnLeft = (x + currentFrame.getWidth()/2 < GameState.smashStageLeft);
		offStage = (offStageOnRight || offStageOnLeft);
		
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
		pressingAirdash = false;
	}
	
	private void setState(int state) {
		
		if (this.state != state) {			
			this.state = state;
			frameCounter = 0;
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
	private void slowShield() {
		
		setFrames(40);
		
		if (frameCounter < 26) {
			
			pressingShield = true;
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
		
		
		setFrames(20);
		
		if (frameCounter == 19) {
			
			turnToOpponent();
		}
		
		if (frameCounter == 18) {
			
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
		
		if (frameCounter == 7) {
			
			pressingAttack = true;
			turnToOpponent();
		}
		
		if (frameCounter <= 6) {
			
			turnToOpponent();
		}
	}
	
	private void jumpUpAir() {
		
		setFrames(2);
		
		if (frameCounter == 1) {
			
			pressingJump = true;
		}
		
		if (frameCounter == 0) {
			
			pressingUp = true;
			pressingAttack = true;
		}
	}
	
	private void sideSpecial() {
		
		turnToOpponent();
		pressingSpecial = true;
		
		if (parried)
			parried = false;
		if (defended)
			defended = false;
	}
	
	private void chargeSideSpecial(int charge) {
		
		setFrames(5 + charge);
		
		if (frameCounter == 5 + charge - 1) {
			
			turnToOpponent();
		}
		
		if (frameCounter == 5 + charge - 2) {
			
			turnToOpponent();
			pressingSpecial = true;
		}
		
		if (frameCounter < 5 + charge - 2 && frameCounter > 0) {
			
			pressingSpecial = true;
		}
		
		if (frameCounter == 0) {
			
			pressingSpecial = false;
		}
		
		
	}
	
	private void upSpecialUp() {
		
		setFrames(10);
		
		if (frameCounter == 9) {
			
			pressingUp = true;
			pressingSpecial = true;
		}
	}
	
	private void upSpecialToCenter() {
		
		setFrames(15);
		
		if (frameCounter == 14) {
			
			pressingUp = true;
			pressingSpecial = true;
		}
		
		if (frameCounter < 14) {
			
			goToCenter();
		}
	}
	
	private void upSpecialRight() {
		
		setFrames(15);
		
		if (frameCounter == 14) {
			
			pressingUp = true;
			pressingSpecial = true;
		}
		
		if (frameCounter < 14) {
			
			pressingRight = true;
		}
	}
	
	private void upSpecialLeft() {
		
		setFrames(15);
		
		if (frameCounter == 14) {
			
			pressingUp = true;
			pressingSpecial = true;
		}
		
		if (frameCounter < 14) {
			
			pressingLeft = true;
		}
	}
	
	private void neutralSpecial() {
		
		pressingSpecial = true;
	}
	private void doNothing() {
		
	}
	private void jumpToCenter() {
		
		
		setFrames(10);
		
		if (frameCounter == 9) {
			
			turnToOpponent();
			pressingJump = true;
		}
		
		if (frameCounter <= 8) {
			
			turnToOpponent();
		}
	}
	
	private void airdashToCenter() {
		
		setFrames(15);
		
		if (frameCounter == 14) {
			pressingAirdash = true;
			goToCenter();
		}
		
	}
	private void airdashRight() {
		
		setFrames(15);
		
		if (frameCounter == 14) {
			pressingAirdash = true;
			pressingRight = true;
		}
	}
	private void airdashLeft() {
		
		setFrames(15);
		
		if (frameCounter == 14) {
			pressingAirdash = true;
			pressingLeft = true;
		}
	}
	private void airdashUp() {
		setFrames(15);
		
		if (frameCounter == 14) {
			pressingAirdash = true;
			pressingUp = true;
		}
	}
	
	private void ijadFair() {
		setFrames(20);
		
		if (frameCounter == 19) {
			turnToOpponent();
			pressingJump = true;
		}
		else if (frameCounter == 18) {
			turnToOpponent();
			pressingAirdash = true;
			pressingAttack = true;
		}
		else {
			pressingShield = true;
		}
	}
	
	private void ijadUpAir() {
		setFrames(20);
		
		if (frameCounter == 19) {
			turnToOpponent();
			pressingJump = true;
		}
		else if (frameCounter == 18) {
			turnToOpponent();
			pressingAirdash = true;
			pressingAttack = true;
			pressingUp = true;
		}
		else {
			pressingShield = true;
		}
	}
	
	private void ijadBair() {
		setFrames(20);
		
		if (frameCounter == 19) {
			turnAway();
			pressingJump = true;
		}
		else if (frameCounter == 18) {
			turnToOpponent();
			pressingAirdash = true;
			pressingAttack = true;
		}
		else {
			pressingShield = true;
		}
	}
	
	private void adcUpAir() {
		setFrames(3);
		
		if (frameCounter == 2) {
			pressingJump = true;
		}
		else if (frameCounter == 1) {
			pressingUp = true;
			pressingAttack = true;
			pressingAirdash = true;
		}
	}

	
	

	protected void getInput() {
		
		checkState();
		pressNothing();
		
		if (offStage) {
			setState(-1);
			randomize(10);
			
			if (rand <= 1)
				doNothing();
			if (rand > 1 && rand <= 4)
				goToCenter();
			if (rand > 4 && rand <= 6)
				jumpToCenter();
			if (rand > 6 && rand <= 8)
				airdashToCenter();
			if (rand > 8 && rand <= 10)
				airdashUp();
			
		}
		else if (opponentNear) {
			
			if (opponentAttacking) {
				
				if (!shieldStun && freezeFrames == 0 && (defended || parried)) {
					
					if (magic >= 3) {
						
						setState(0);
						randomize(17);
						
						if (rand <= 5)
							jab();
						if (rand > 5 && rand <= 8)
							dashAttack();
						if (rand > 8 && rand <= 10)
							upTilt();
						if (rand > 10 && rand <= 12)
							sideSpecial();
						if (rand > 12 && rand <= 15)
							ijadUpAir();
						if (rand > 15 && rand <= 17)
							ijadFair();
					}
					else {
						
						setState(1);
						randomize(15);
						
						if (rand <= 5)
							jab();
						if (rand > 5 && rand <= 8)
							dashAttack();
						if (rand > 8 && rand <= 10)
							upTilt();
						if (rand > 10 && rand <= 13)
							ijadUpAir();
						if (rand > 13 && rand <= 15)
							ijadFair();
						
					}
				}
				
				else if (!(defended || parried)) {
					
					if (onAir) {
						
						setState(2);
						randomize(3);
						
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
								
								if (magic >= 1) {
									if (rand == 1) {										
										pressingSpecial = true;
									}
									else {
										pressingJump = true;
										dashAway();
									}
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
					else if ((opponent.character instanceof Lacerda && ((opponent.neutralSpecialing && opponent.character.attackUF == 2) || (opponent.upSpecialing && opponent.character.attackUF >= 10))) || (opponent.character instanceof Bruno && opponent.neutralSpecialing) || (opponent.character instanceof Carol && opponent.upSpecialing)) {
						
						setState(3);
						
						if (opponent.character instanceof Lacerda && opponent.upSpecialing && opponent.character.attackUF >= 10) {
							
							jab();
						}
						else {
						
							dashAttack();
						}
					}
					
					else if (magic >= 1) {
						
						if (shield > 0) {
							
							setState(4);
							randomize(10);
		
							if (rand <= 4) 
								shield();
							if (rand > 4 && rand <= 8)
								slowShield();
							if (rand > 8 && rand <= 9)
								neutralSpecial();
							else
								dashAway();
							
						}
						else {
							
							setState(5);
							randomize(5);
							
							pressingShield = false;
							
							if (rand <= 3)
								neutralSpecial();
							if (rand > 3 && rand <= 5)
								dashAway();
						}
					}
					else {
						
						if (shield > 0) {
						
							setState(6);
							randomize(10);
		
							if (rand <= 5) 
								shield();
							else if (rand > 5 && rand <= 9)
								slowShield();
							else {
								
								dashAway();
							}
						}
						else {
							
							setState(7);
							
							pressingShield = false;
							dashAway();
						}
					}
				}
			}
			
			else if (!opponentAttacking) {
				
				
				if (!opponentOnTop) {
					
					if (!opponentShielding) {
						
						if (magic >= 3) {
							
							setState(8);
							randomize(40);
							
							if (rand <= 4)
								jab();
							if (rand > 4 && rand <= 8)
								dashAttack();
							if (rand > 8 && rand <= 11)
								upTilt();
							if (rand > 11 && rand <= 15)
								jumpFair();
							if (rand > 15 && rand <= 17)
								jumpBair();
							if (rand > 17 && rand <= 19)
								dashAway();
							if (rand > 19 && rand <= 20)
								jump();
							if (rand > 20 && rand <= 21)
								upSpecialToCenter();
							if (rand > 21 && rand <= 22)
								upSpecialUp();
							if (rand > 22 && rand <= 23)
								upSpecialRight();
							if (rand > 23 && rand <= 24)
								upSpecialLeft();
							if (rand > 24 && rand <= 26)
								sideSpecial();
							if (rand > 26 && rand <= 28)
								chargeSideSpecial(20);
							if (rand > 28 && rand <= 29)
								chargeSideSpecial(40);
							if (rand > 29 && rand <= 30)
								chargeSideSpecial(60);
							if (rand > 30 && rand <= 33)
								ijadFair();
							if (rand > 33 && rand <= 36)
								ijadBair();
							if (rand > 36 && rand <= 40)
								ijadUpAir();

						}
						
						if (magic >= 2 && magic < 3) {
							
							setState(9);
							randomize(32);
							
							if (rand <= 4)
								jab();
							if (rand > 4 && rand <= 8)
								dashAttack();
							if (rand > 8 && rand <= 11)
								upTilt();
							if (rand > 11 && rand <= 15)
								jumpFair();
							if (rand > 15 && rand <= 17)
								jumpBair();
							if (rand > 17 && rand <= 19)
								dashAway();
							if (rand > 19 && rand <= 20)
								jump();
							if (rand > 20 && rand <= 21)
								upSpecialToCenter();
							if (rand > 21 && rand <= 22)
								upSpecialUp();
							if (rand > 22 && rand <= 23)
								upSpecialRight();
							if (rand > 23 && rand <= 24)
								upSpecialLeft();
							if (rand > 24 && rand <= 26)
								ijadFair();
							if (rand > 26 && rand <= 28)
								ijadBair();
							if (rand > 28 && rand <= 32)
								ijadUpAir();
						}
						
						if (magic < 2) {
							
							setState(10);
							randomize(26);
							
							if (rand <= 4)
								jab();
							if (rand > 4 && rand <= 8)
								dashAttack();
							if (rand > 8 && rand <= 11)
								upTilt();
							if (rand > 11 && rand <= 15)
								jumpFair();
							if (rand > 15 && rand <= 17)
								jumpBair();
							if (rand > 17 && rand <= 19)
								dashAway();
							if (rand > 19 && rand <= 20)
								jump();
							if (rand > 20 && rand <= 22)
								ijadFair();
							if (rand > 22 && rand <= 23)
								ijadBair();
							if (rand > 23 && rand <= 26)
								ijadUpAir();
						}
					}
					
					else if (opponentShielding) {
						
						if (magic >= 3) {
							
							if (opponent.getShield() >= 50) {
								
							
								setState(11);
								randomize(10);
								
								if (rand <= 1)
									jumpBair();
								if (rand > 1 && rand <= 4)
									dashAway();
								if (rand > 4 && rand <= 5)
									jump();
								if (rand > 5 && rand <= 6)
									chargeSideSpecial(20);
								if (rand > 6 && rand <= 8)
									chargeSideSpecial(40);
								if (rand > 8 && rand <= 10)
									chargeSideSpecial(60);
							}
							
							else {
								
								setState(12);
								randomize(10);
								
								if (rand <= 1)
									jumpBair();
								if (rand > 1 && rand <= 2)
									dashAway();
								if (rand > 2 && rand <= 3)
									jump();
								if (rand > 3 && rand <= 4)
									chargeSideSpecial(20);
								if (rand > 4 && rand <= 7)
									chargeSideSpecial(40);
								if (rand > 7 && rand <= 10)
									chargeSideSpecial(60);
							}
						}
						
						else {
						
							setState(13);
							randomize(10);
							
							if (rand <= 2)
								jumpBair();
							if (rand > 2 && rand <= 7)
								dashAway();
							if (rand > 7 && rand <= 10)
								jump();
						}
					}
				}
				
				else if (opponentOnTop) {
					
					if (opponent.getY() <= y) {
							
							setState(14);
							randomize(3);
							
							if (rand == 1)
								upTilt();
							if (rand == 2)
								jumpUpAir();
							if (rand == 3)
								adcUpAir();
							if (rand == 4)
								upSpecialUp();
					}
					else {
						
						if (magic >= 2) {
							
							setState(15);
							randomize(12);
							
							if (rand <= 2)
								jump();
							if (rand > 2 && rand <= 3)
								dashRight();
							if (rand > 3 && rand <= 4)
								dashLeft();
							if (rand > 4 && rand <= 6)
								upSpecialRight();
							if (rand > 6 && rand <= 8)
								upSpecialLeft();
							if (rand > 8 && rand <= 10)
								airdashRight();
							if (rand > 10 && rand <= 12)
								airdashLeft();
						}
						else {
							
							setState(16);
							randomize(6);
							
							if (rand <= 2)
								jump();
							if (rand > 2 && rand <= 3)
								dashRight();
							if (rand > 3 && rand <= 4)
								dashLeft();
							if (rand > 4 && rand <= 5)
								airdashRight();
							if (rand > 5 && rand <= 6)
								airdashLeft();
						}
					}
				}
			}
		}
		else if (!opponentNear) {
			
			if (opponentCandyComing) {
			
				setState(17);
				
				randomize(10);
				
				if (rand <= 5) 
					shield();
				else if (rand > 5 && rand <= 10)
					slowShield();
			}
			else if (!opponentCandyComing) {
				
				if (!onCenter) {
				
						
					if (magic >= 2) {
						
					
						setState(18);
						randomize(17);
						
						if (rand <= 4)
							goToCenter();
						if (rand > 4 && rand <= 5)
							dashLeft();
						if (rand > 5 && rand <= 6)
							dashRight();
						if (rand > 6 && rand <= 7)
							jump();
						if (rand > 7 && rand <= 10)
							goToOpponent();
						if (rand > 10 && rand <= 12)
							upSpecialToCenter();
						if (rand > 12 && rand <= 13)
							upSpecialUp();
						if (rand > 13 && rand <= 15)
							ijadFair();
						if (rand > 15 && rand <= 17)
							ijadBair();
						
					}
					
					else {
						
						setState(19);
						randomize(12);
						
						if (rand <= 4)
							goToCenter();
						if (rand > 4 && rand <= 5)
							dashLeft();
						if (rand > 5 && rand <= 6)
							dashRight();
						if (rand > 6 && rand <= 7)
							jump();
						if (rand > 7 && rand <= 10)
							goToOpponent();
						else
							ijadFair();
					}
				}
				
				else if (onCenter) {
					
					if (GameState.magicBall.getGrabbable()) {
						
						if (magic >= 2) {
							
							setState(20);
							randomize(13);
							
							if (rand <= 8)
								jump();
							if (rand > 8 && rand <= 9)
								dashLeft();
							if (rand > 9 && rand <= 10)
								dashRight();
							if (rand > 10 && rand <= 13)
								upSpecialUp();
							
						}
						else {
							
							setState(21);
							randomize(10);
							
							if (rand <= 8)
								jump();
							if (rand > 8 && rand <= 9)
								dashLeft();
							if (rand > 9 && rand <= 10)
								dashRight();
						}
					}
					
					else if (!GameState.magicBall.getGrabbable()) {
						
						if (magic >= 2) {
							
							
						    setState(22);
							randomize(15);
							
							if (rand <= 3)
								stand();
							if (rand > 3 && rand <= 5)
								dashLeft();
							if (rand > 5 && rand <= 7)
								dashRight();
							if (rand > 7 && rand <= 8)
								jump();
							if (rand > 8 && rand <= 10)
								goToOpponent();
							if (rand > 10 && rand <= 11)
								upSpecialRight();
							if (rand > 11 && rand <= 12)
								upSpecialLeft();
							if (rand > 12 && rand <= 13)
								ijadFair();
							if (rand > 13 && rand <= 14)
								ijadBair();
							if (rand > 14 && rand <= 15)
								ijadUpAir();
						
							
						}
						
						else {
							
							setState(23);
							randomize(13);
							
							if (rand <= 3)
								stand();
							if (rand > 3 && rand <= 5)
								dashLeft();
							if (rand > 5 && rand <= 7)
								dashRight();
							if (rand > 7 && rand <= 8)
								jump();
							if (rand > 8 && rand <= 10)
								goToOpponent();
							if (rand > 10 && rand <= 11)
								ijadFair();
							if (rand > 11 && rand <= 12)
								ijadBair();
							if (rand > 12 && rand <= 13)
								ijadUpAir();
						}
					}
				}
			}
		}
	}
}



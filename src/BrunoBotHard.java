
public class BrunoBotHard extends Player{
	
	private int state, rand, frameCounter = 0;
	private boolean opponentNear, opponentOnAir, opponentOnTop, opponentOnLeft, opponentOnRight, opponentAttacking, opponentShielding, opponentCandyComing,
					onCenter;

	
	public BrunoBotHard(Game game, int playerNumb, Character character, double x, double y) {
		
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
		
		
		if (opponentNear) {
			
			if (opponentAttacking) {
				
				if (!shieldStun && freezeFrames == 0 && (defended || parried)) {
					
					setState(0);
					randomize(10);

					
					if (rand <= 3)
						jab();
					if (rand > 3 && rand <= 6)
						dashAttack();
					if (rand > 6 && rand <= 8)
						jumpFair();
					if (rand > 8 && rand <= 10)
						upTilt();
					

				}
				
				else if (!(defended || parried)) {
					
					if (onAir) {
						
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
					
					else if ((opponent.character instanceof Lacerda && ((opponent.neutralSpecialing && opponent.character.attackUF == 2) || (opponent.upSpecialing && opponent.character.attackUF == 10))) || (opponent.character instanceof Bruno && opponent.neutralSpecialing) || (opponent.character instanceof Carol && opponent.upSpecialing)) {
						
						setState(2);
						
						dashAttack();
					}
					else if (shield > 0) {
					
						setState(3);
						randomize(10);
	
						if (rand <= 7) 
							shield();
						else {
							
							dashAway();
						}
					}
					else {
						
						setState(4);
						
						pressingShield = false;
						dashAway();
					}
				}
			}
			
			else if (!opponentAttacking) {
				
				
				if (!opponentOnTop) {
					
					if (!opponentShielding) {
						
						if (magic >= 4) {
							
							setState(5);
							randomize(30);
							
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
							if (rand > 20 && rand <= 25)
								sideSpecial();
							if (rand > 25 && rand <= 30)
								upSpecial();
						}
						
						if (magic >= 2 && magic < 4) {
							
							setState(6);
							randomize(25);
							
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
							if (rand > 20 && rand <= 25)
								sideSpecial();
						}
						
						if (magic < 2) {
							
							setState(7);
							randomize(20);
							
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
						}
					}
					
					else if (opponentShielding) {
						
						setState(8);
						randomize(10);
						
						if (rand <= 2)
							jumpBair();
						if (rand > 2 && rand <= 7)
							dashAway();
						if (rand > 7 && rand <= 10)
							jump();
					}
				}
				
				else if (opponentOnTop) {
					
					if (opponent.getY() <= y) {
						
						if (magic >= 4) {
							
							setState(9);
							randomize(6);
							
							if (rand <= 1)
								upTilt();
							if (rand > 1 && rand <= 2);
								jumpUpAir();
							if (rand > 2 && rand <= 4)
								upSpecial();
							if (rand > 4 && rand <= 6)
								jumpUpSpecial();
						}
						
						if (magic < 4) {
							
							setState(10);
							randomize(2);
							
							if (rand == 1)
								upTilt();
							if (rand == 2)
								jumpUpAir();
						}
					}
					else {
						
						setState(11);
						randomize(4);
						
						if (rand <= 2)
							jump();
						if (rand > 2 && rand <= 3)
							dashRight();
						if (rand > 3 && rand <= 4)
							dashLeft();
					}
				}
			}
		}
		else if (!opponentNear) {
			
			if (opponentCandyComing) {
			
				setState(12);
				
				shield();
			}
			else if (!opponentCandyComing) {
				
				if (!onCenter) {
					
					if (shield >= 20) {
						if (magic >= 2) {
							
							if (parried) {
								
								setState(13);
								sideSpecial();
							}
							else {
							
								setState(14);
								randomize(15);
								
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
									sideSpecial();
								if (rand > 12 && rand <= 15)
									jumpSideSpecial();
							}
						}
						
						if (magic < 2) {
							
							setState(15);
							randomize(10);
							
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
						}
					}
					
					if (shield < 20) {
						
						if (magic >= 2) {
							
							if (parried) {
								
								setState(16);
								sideSpecial();
							}
							else {
							
								setState(17);
								randomize(20);
								
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
									sideSpecial();
								if (rand > 12 && rand <= 15)
									jumpSideSpecial();
								if (rand > 15 && rand <= 20)
									neutralSpecial();
							
							}
						}
						
						if (magic == 1) {
							
							setState(18);
							randomize(15);
							
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
							if (rand > 10 && rand <= 15)
								neutralSpecial();
						}
						
						if (magic == 0) {
							
							setState(19);
							randomize(10);
							
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
						
						if (magic >= 2) {
							
							if (parried) {
								
								setState(21);
								sideSpecial();
							}
							else {
							
								setState(22);
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
								if (rand > 10 && rand <= 12)
									sideSpecial();
								if (rand > 12 && rand <= 13)
									jumpSideSpecial();
							
							}
						}
						
						if (magic < 2) {
							
							setState(23);
							randomize(10);
							
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
						}
					}
				}
			}
		}
	}
}



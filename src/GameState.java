import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameState extends State {

	private Player player1, player2;
	public static int floorY = 570;
	public static int leftWall = 0;
	public static int rightWall = 1280;
	public static int shieldDropFrames = 5;
	public static int shieldStunFrames = 12;
	public static int landingLag = 5;
	public static int aerialLandingLag = 10;
	public static int floorHeight = 50;
	public static HitEffect hitEffect = new HitEffect(Assets.hitEffect);
	public static boolean hitEffectActive = false;
	private boolean fighting;
	private boolean training;
	private int winner;
	private int KOscreenTimer = 0;
	private int countdownTimer = 0;
	private static int parryFreezeCounter = 0;
	public static ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	public static MagicBall magicBall;
	private Button hitboxButton, resetButton, speedButton, frameButton, trainingBotButton, botBehaviorButton, botEscapeButton, botPlayerButton, menuButton, characterButton, resumeButton;
	private boolean showBoxes = false;
	private boolean paused;
	private int mode;
	public static ScreenRefreshManager screenRefreshManager = new ScreenRefreshManager();
	private int map;
	private boolean mapRendered;
	private boolean slow = false;
	private boolean playFrame = false;
	private int gameSpeed = 1;
	private boolean pausePressed;
	private boolean suddenDeath;
	private int maxScore;
	private int numGames = 10000;
	
	private int p1wins = 0;
	private int p2wins = 0;
	
	private boolean trainingBotOn = false;
	private int botBehavior = 0;
	private int botEscape = 0, botPlayer = 2;
	
	private ComboCounter comboCounter = new ComboCounter();
	
	private PercentEditor percentEditor;
	
	private boolean isSmash = true;
	public static int smashStageLeft = 150;
	public static int smashStageRight = 1130;
	
	public static final double GRAVITY = 1;
	
	public GameState(Game game) {
		
		super(game);
		
		
	}
	
	
	public void init(int mode, int map, boolean suddenDeath) {
		
		//mode 1 = regular pvp fight
		//mode 2 = training pvp
		//mode 3 = bot
		
		if (!isSmash) {
			smashStageLeft = 0;
			smashStageRight = 1280;
		}
		else {
			rightWall = 2000;
			leftWall = -1000;
		}
		
		mapRendered = false;
		
		this.mode = mode;
		//this.map = map;
		this.map = 0;
		this.suddenDeath = suddenDeath;
		

		projectiles.clear();
		
		if (mode == 2) {
			
			training = true;
		}
		else
			training = false;
		
		

		
		if (mode <= 2) {
			
			
			player1 = new SmashPlayer(game, 1, ((CharacterSelectState)(game.getCharacterSelectState())).getPlayer1Char(), 240, floorY - 200, "JOGADOR 1");
			player2 = new SmashPlayer(game, 2, ((CharacterSelectState)(game.getCharacterSelectState())).getPlayer2Char(), 840, floorY - 200, "JOGADOR 2");
			//player2 = new SmashBrunoBotHard(game, 2, new Bruno(1), 840, floorY - 200);
			//player2 = new SmashCarolBotHard(game, 2, new Carol(1), 840, floorY - 200);
			//player2 = new SmashLacerdaBotHard(game, 2, new Lacerda(1), 840, floorY - 200);
			//player2 = new SmashObinoBotHard(game, 2, new Obino(1), 840, floorY - 200);


			
		}
		else if (mode >= 3 && mode <= 4) {
			
			if (mode == 3) {
				
				player1 = ((ChooseBotState)(game.getChooseBotState())).getPlayer();
				player2 = ((ChooseBotState)(game.getChooseBotState())).getBot();
			}
			else if (mode == 4) {
				
				player1 = ((ChooseBotState)(game.getChooseBotState())).getBot();
				player2 = ((ChooseBotState)(game.getChooseBotState())).getPlayer();
			}
		}

		player1.setOpponent(player2);
		player2.setOpponent(player1);
		magicBall = new MagicBall();
	
		
		
		
		paused = false;
		showBoxes = false;
		
		
		
		winner = 0;
		
		if (suddenDeath) {
			maxScore = 1;
			suddenDeath();
		}
		else if (isSmash) {
			
			maxScore = 4;
		}
		else {
			maxScore = 2;
		}
		
		
		if (mode <= 2) {
			
			resumeButton = new Button(game, 540, 265, 200, 50, Color.darkGray, "SEGUIR JOGANDO", Assets.font20, null, true);
			characterButton = new Button(game, 500, 335, 280, 50, Color.darkGray, "ESCOLHER PERSONAGENS", Assets.font20, null, true);
			menuButton = new Button(game, 540, 405, 200, 50, Color.darkGray, "VOLTAR AO MENU", Assets.font20, null, true);
		}
		else if (mode >= 3) {
			
			resumeButton = new Button(game, 540, 300, 200, 50, Color.darkGray, "SEGUIR JOGANDO", Assets.font20, null, true);
			menuButton = new Button(game, 540, 370, 200, 50, Color.darkGray, "VOLTAR AO MENU", Assets.font20, null, true);
		}
		
		if (!training)
			fighting = false;
		else {
			
			fighting = true;
			resetButton = new Button(game, 10, 10, 120, 40, Color.darkGray, "ENCHER VIDAS", Assets.font10, null, true);
			hitboxButton = new Button(game, 10, 60, 120, 40, Color.darkGray, "MOSTRAR HITBOXES", Assets.font10, null, true);
			speedButton = new Button(game, 10, 110, 120, 40, Color.darkGray, "MUDAR VELOCIDADE", Assets.font10, null, true);
			frameButton = new Button(game, 10, 160, 120, 40, Color.darkGray, "PASSAR FRAME", Assets.font10, null, true);
			trainingBotButton = new Button(game, 10, 210, 120, 40, Color.darkGray, "LIGAR/DESLIGAR", Assets.font10, null, true);
			botBehaviorButton = new Button(game, 10, 260, 120, 40, Color.darkGray, "COMPORTAMENTO", Assets.font10, null, true);
			botEscapeButton = new Button(game, 10, 310, 120, 40, Color.darkGray, "ESCAPAR COMBO", Assets.font10, null, true);
			percentEditor = new PercentEditor(game);
					
			//botPlayerButton = new Button(game, 10, 360, 120, 40, Color.darkGray, "JOGADOR DO BOT", Assets.font10, null, true);
		}
		
	}
	
	@Override
	public void tick() {

		//System.out.println(player2.getX() + 100);
		
		if (fighting) {

			if (game.getKeyManager(1).pause) {
				
				if (!pausePressed) {
					
					pausePressed = true;
					
					if (!paused) {
						
						paused = true;
						screenRefreshManager.reset();
					}
					else {
						
						paused = false;
						screenRefreshManager.reset();
					}
				}
			}
			else {
				
				pausePressed = false;
			}
			
			if (paused) {
				
				screenRefreshManager.reset();
				
				if (resumeButton.buttonPressed()) {
					
					paused = false;
					
				}
				
				if (mode <= 2) {
					
					if (characterButton.buttonPressed()) {
						
						slow = false;
						gameSpeed = 1;
						game.setSlow(false);
						hitEffectActive = false;
						hitEffect.resetFrameCounter();
						KOscreenTimer = 0;
						countdownTimer = 0;
						parryFreezeCounter = 0;
						botBehavior = 0;
						botEscape = 0;
						trainingBotOn = false;
						State.setState(game.getCharacterSelectState());
						((CharacterSelectState)(game.getCharacterSelectState())).init();
					}
				}
				
				if (menuButton.buttonPressed()) {
					
					slow = false;
					gameSpeed = 1;
					game.setSlow(false);
					hitEffectActive = false;
					hitEffect.resetFrameCounter();
					KOscreenTimer = 0;
					countdownTimer = 0;
					parryFreezeCounter = 0;
					botBehavior = 0;
					botEscape = 0;
					trainingBotOn = false;
					State.setState(game.getMenuState());
					((MenuState)(game.getMenuState())).init();
				}
			}
			
			else {
			
				if (parryFreezeCounter == 0) {
					
					
					screenRefreshManager.setChange(290, 20, 700, 70);
					
					if (training) {
						
						if (frameButton.buttonPressed()) {
							
							playFrame = true;
						}
					}
					
					
					if (gameSpeed != 3 || playFrame) {
						
						
						
						player1.measureCollision();
						player2.measureCollision();
						player1.getInput();
						player2.getInput();
						player1.tick();
						player2.tick();

					}
					else {
						player1.updateImage();
						player2.updateImage();
						for (int i = projectiles.size() - 1; i >= 0; i--) {
							
							projectiles.get(i).updateImage();
						}
					}
					
					
					
					if (!training)
						magicBall.tick();
					else {
						
						player1.maxMagic();
						player2.maxMagic();
						
						percentEditor.tick();
						
						if (resetButton.buttonPressed()) {
							
							player1.maxHP();
							player2.maxHP();
							if (isSmash) {
								player1.restoreRound();
								player2.restoreRound();
							}
							player1.restoreShield();
							player2.restoreShield();
							percentEditor.resetBotPercent();
						}
						
						if (hitboxButton.buttonPressed()) {
							
							if (!showBoxes)
								showBoxes = true;
							else
								showBoxes = false;
						}
						
						if (speedButton.buttonPressed()) {
							
							screenRefreshManager.setChange(130, 120, 100, 60);
							screenRefreshManager.setChange(10, 160, 120, 40);
							gameSpeed++;
							if (gameSpeed == 4) {
								gameSpeed = 1;
							}
							
							if (gameSpeed == 1) {
								
								slow = false;
								game.setSlow(false);
								
							}
							else if (gameSpeed == 2) {
								
								slow = true;
								game.setSlow(true);
								
							}
							else {
								
								slow = false;
								game.setSlow(false);
								
							}
							
						}
						
						if (trainingBotButton.buttonPressed()) {
							trainingBotOn = !trainingBotOn;
							screenRefreshManager.setChange(10, 160, 200, 200);
							screenRefreshManager.setChange(0, 0, 1280, 30);
							screenRefreshManager.setChange(0, 0, 300, 500);
							double p2X = player2.getX();
							double p2Y = player2.getY();
							if (trainingBotOn) {
								if (isSmash)
									player2 = new SmashTrainingBot(game, 2, ((CharacterSelectState)(game.getCharacterSelectState())).getPlayer2Char(), p2X, p2Y);
								else
									player2 = new TrainingBot(game, 2, ((CharacterSelectState)(game.getCharacterSelectState())).getPlayer2Char(), p2X, p2Y);
								player2.setOpponent(player1);
								player1.setOpponent(player2);
								((CharacterSelectState)(game.getCharacterSelectState())).getPlayer2Char().resetAttackCounters();
							}
							else {
								player2 = new SmashPlayer(game, 2, ((CharacterSelectState)(game.getCharacterSelectState())).getPlayer2Char(), p2X, p2Y, "JOGADOR 2");
								player2.setOpponent(player1);
								player1.setOpponent(player2);
								((CharacterSelectState)(game.getCharacterSelectState())).getPlayer2Char().resetAttackCounters();
								botBehavior = 0;
								botEscape = 0;
							}
						}
						
						if (trainingBotOn) {
							if (botBehaviorButton.buttonPressed()) {
								double p2X = player2.getX();
								double p2Y = player2.getY();
								screenRefreshManager.setChange(0, 0, 300, 500);
								screenRefreshManager.setChange(0, 0, 1280, 30);
								botBehavior++;
								if (botBehavior > 7) {
									botBehavior = 0;
									if (isSmash)
										player2 = new SmashTrainingBot(game, 2, ((CharacterSelectState)(game.getCharacterSelectState())).getPlayer2Char(), p2X, p2Y);
									else
										player2 = new TrainingBot(game, 2, ((CharacterSelectState)(game.getCharacterSelectState())).getPlayer2Char(), p2X, p2Y);
									player2.setOpponent(player1);
									player1.setOpponent(player2);
									((CharacterSelectState)(game.getCharacterSelectState())).getPlayer2Char().resetAttackCounters();
									if (isSmash)
										((SmashTrainingBot)(player2)).setEscapeOption(botEscape);
									else
										((TrainingBot)(player2)).setEscapeOption(botEscape);
								}
								if (botBehavior <= 4) {
									if (isSmash)
										((SmashTrainingBot)(player2)).setBehaviorOption(botBehavior);
									else
										((TrainingBot)(player2)).setBehaviorOption(botBehavior);
								}
								else if (botBehavior == 5) {
									if (((CharacterSelectState)(game.getCharacterSelectState())).getPlayer2Char() instanceof Bruno) {
										player2 = new SmashBrunoBotEasy(game, 2, ((CharacterSelectState)(game.getCharacterSelectState())).getPlayer2Char(), p2X, p2Y);
									}
									else if (((CharacterSelectState)(game.getCharacterSelectState())).getPlayer2Char() instanceof Carol) {
										player2 = new SmashCarolBotEasy(game, 2, ((CharacterSelectState)(game.getCharacterSelectState())).getPlayer2Char(), p2X, p2Y);
									}
									else if (((CharacterSelectState)(game.getCharacterSelectState())).getPlayer2Char() instanceof Lacerda) {
										player2 = new SmashLacerdaBotEasy(game, 2, ((CharacterSelectState)(game.getCharacterSelectState())).getPlayer2Char(), p2X, p2Y);
									}
									else if (((CharacterSelectState)(game.getCharacterSelectState())).getPlayer2Char() instanceof Obino) {
										player2 = new SmashObinoBotEasy(game, 2, ((CharacterSelectState)(game.getCharacterSelectState())).getPlayer2Char(), p2X, p2Y);
									}
									player2.setOpponent(player1);
									player1.setOpponent(player2);
									((CharacterSelectState)(game.getCharacterSelectState())).getPlayer2Char().resetAttackCounters();
								}
								else if (botBehavior == 6) {
									if (((CharacterSelectState)(game.getCharacterSelectState())).getPlayer2Char() instanceof Bruno) {
										player2 = new SmashBrunoBotMedium(game, 2, ((CharacterSelectState)(game.getCharacterSelectState())).getPlayer2Char(), p2X, p2Y);
									}
									else if (((CharacterSelectState)(game.getCharacterSelectState())).getPlayer2Char() instanceof Carol) {
										player2 = new SmashCarolBotMedium(game, 2, ((CharacterSelectState)(game.getCharacterSelectState())).getPlayer2Char(), p2X, p2Y);
									}
									else if (((CharacterSelectState)(game.getCharacterSelectState())).getPlayer2Char() instanceof Lacerda) {
										player2 = new SmashLacerdaBotMedium(game, 2, ((CharacterSelectState)(game.getCharacterSelectState())).getPlayer2Char(), p2X, p2Y);
									}
									else if (((CharacterSelectState)(game.getCharacterSelectState())).getPlayer2Char() instanceof Obino) {
										player2 = new SmashObinoBotMedium(game, 2, ((CharacterSelectState)(game.getCharacterSelectState())).getPlayer2Char(), p2X, p2Y);
									}
									player2.setOpponent(player1);
									player1.setOpponent(player2);
									((CharacterSelectState)(game.getCharacterSelectState())).getPlayer2Char().resetAttackCounters();
								}
								else if (botBehavior == 7) {
									if (((CharacterSelectState)(game.getCharacterSelectState())).getPlayer2Char() instanceof Bruno) {
										player2 = new SmashBrunoBotHard(game, 2, ((CharacterSelectState)(game.getCharacterSelectState())).getPlayer2Char(), p2X, p2Y);
									}
									else if (((CharacterSelectState)(game.getCharacterSelectState())).getPlayer2Char() instanceof Carol) {
										player2 = new SmashCarolBotHard(game, 2, ((CharacterSelectState)(game.getCharacterSelectState())).getPlayer2Char(), p2X, p2Y);
									}
									else if (((CharacterSelectState)(game.getCharacterSelectState())).getPlayer2Char() instanceof Lacerda) {
										player2 = new SmashLacerdaBotHard(game, 2, ((CharacterSelectState)(game.getCharacterSelectState())).getPlayer2Char(), p2X, p2Y);
									}
									else if (((CharacterSelectState)(game.getCharacterSelectState())).getPlayer2Char() instanceof Obino) {
										player2 = new SmashObinoBotHard(game, 2, ((CharacterSelectState)(game.getCharacterSelectState())).getPlayer2Char(), p2X, p2Y);
									}
									player2.setOpponent(player1);
									player1.setOpponent(player2);
									((CharacterSelectState)(game.getCharacterSelectState())).getPlayer2Char().resetAttackCounters();
								}
							}
							if (botBehavior <= 4) {
								if (botEscapeButton.buttonPressed()) {
									screenRefreshManager.setChange(0, 0, 300, 500);
									botEscape++;
									if (botEscape > 7) {
										botEscape = 0;
									}
									if (isSmash)
										((SmashTrainingBot)(player2)).setEscapeOption(botEscape);
									else
										((TrainingBot)(player2)).setEscapeOption(botEscape);
								}
							}
							/*
							if (botPlayerButton.buttonPressed()) {
								screenRefreshManager.setChange(0, 0, 1280, 720);
								double p2X = player2.getX();
								double p2Y = player2.getY();
								double p1X = player1.getX();
								double p1Y = player1.getY();
								if (botPlayer == 1) {
									botPlayer = 2;
									player1 = new Player(game, 1, ((CharacterSelectState)(game.getCharacterSelectState())).getPlayer1Char(), p1X, p1Y, "JOGADOR 1");
									player2 = new TrainingBot(game, 2, ((CharacterSelectState)(game.getCharacterSelectState())).getPlayer2Char(), p2X, p2Y);
									player2.setOpponent(player1);
									player1.setOpponent(player2);
									((CharacterSelectState)(game.getCharacterSelectState())).getPlayer2Char().resetAttackCounters();
									((CharacterSelectState)(game.getCharacterSelectState())).getPlayer1Char().resetAttackCounters();
								}
								else {
									botPlayer = 1;
									player2 = new Player(game, 2, ((CharacterSelectState)(game.getCharacterSelectState())).getPlayer2Char(), p2X, p2Y, "JOGADOR 2");
									player1 = new TrainingBot(game, 1, ((CharacterSelectState)(game.getCharacterSelectState())).getPlayer1Char(), p1X, p1Y);
									player2.setOpponent(player1);
									player1.setOpponent(player2);
									((CharacterSelectState)(game.getCharacterSelectState())).getPlayer2Char().resetAttackCounters();
									((CharacterSelectState)(game.getCharacterSelectState())).getPlayer1Char().resetAttackCounters();
								}
							}*/
						}

					}
					
						
					
					
					if (gameSpeed != 3 || playFrame) {
						
						for (int i = projectiles.size() - 1; i >= 0; i--) {
							
							projectiles.get(i).tick();
						}
						
						player1.hitDetection();
						player1.projectileHitDetection();
						player2.hitDetection();
						player2.projectileHitDetection();
						
						comboCounter.tick(player1, player2);
					}
				}
				else {
					
					
					parryFreezeCounter--;
					
				}
				
				if (true) {

					if (player1.getHealth() <= 0 && player2.getHealth() <= 0 && player1.score == maxScore-1 && player2.score == maxScore-1) {
						
				
				
						fighting = false;
						winner = -1;
						

						
					}
					
					else { 
							if (player1.getHealth() <= 0) {
							
	
							fighting = false;
	
							player1.restoreRound();
							if (!training)
								player2.increaseScore();
							
						}
					
						if (player2.getHealth() <= 0) {
						
							fighting = false;
							player2.restoreRound();
							if (!training)
								player1.increaseScore();
							else {
								percentEditor.resetBotPercent();
							}
						}
					}
				}
				
				if (gameSpeed != 3 || playFrame) {
			
					if (hitEffect.getFrameCounter() > 0) {
						
						hitEffect.decreaseFrameCounter();
						hitEffectActive = true;
						
						if (hitEffect.getFrameCounter() == 0) {
							
							screenRefreshManager.setChange(hitEffect.getX(), hitEffect.getY(), hitEffect.getWidth(), hitEffect.getHeight());
							hitEffectActive = false;
							hitEffect.resetFrameCounter();
						}
						
					}
					
					else {
						hitEffectActive = false;
					}
					
					playFrame = false;
				}
			}
		}
		else {
			
			screenRefreshManager.setChange(490, 210, 300, 300);
			
		
			if (player1.getScore() == maxScore) {
				
				winner = 1;
				
				
			}
			
			if (player2.getScore() == maxScore) {
				
				winner = 2;
				
				
			}
		
			
			if (countdownTimer < 210) {
				
				if (training || !suddenDeath && isSmash && player1.getScore() + player2.getScore() != 0) {
					countdownTimer = 209;
				}
				countdownTimer++;
				if (countdownTimer == 210) {
					
					fighting = true;
				}
			}
			
			
			else if (countdownTimer >= 210) {
				
				if (isSmash) {
					if (winner == 0)
						KOscreenTimer = 179;
				}
				KOscreenTimer++;
				if (KOscreenTimer == 1) {
					
					if (mode <= 2) {
						
						if (winner > 0)
								SoundManager.play("sounds/Victory.wav", false);
						else if (winner == -1) 
							SoundManager.play("sounds/SuddenDeath.wav", false);
						
					}
					
					else if (mode == 3) {
						
						if (winner == 1)
							SoundManager.play("sounds/Victory.wav", false);
						else if (winner == 2)
							SoundManager.play("sounds/Fail.wav", false);
						else if (winner == -1)
							SoundManager.play("sounds/SuddenDeath.wav", false);
					}
					
					else if (mode == 4) {
						
						if (winner == 1)
							SoundManager.play("sounds/Fail.wav", false);
						else if (winner == 2)
							SoundManager.play("sounds/Victory.wav", false);
						else if (winner == -1)
							SoundManager.play("sounds/SuddenDeath.wav", false);
					}

				}
				
				if (KOscreenTimer == 180) {
					
					screenRefreshManager.reset();
					
					
					if (winner == 0) {
						
						if (!suddenDeath) {
							
							newRound();
						}
						else {
							
							suddenDeath();
						}
					}
					else if (winner > 0){
						
						hitEffectActive = false;
						hitEffect.resetFrameCounter();
						KOscreenTimer = 0;
						countdownTimer = 0;
						parryFreezeCounter = 0;
					//	System.out.println("Winner: " + winner);
						if (winner == 1)
							p1wins++;
						else if (winner == 2)
							p2wins++;
						
						if (mode <= 2) {
							
							State.setState(game.getCharacterSelectState());
							((CharacterSelectState)(game.getCharacterSelectState())).init();
							
							/*if ((p1wins + p2wins) < numGames) {
								
								if ((p1wins + p2wins)%(numGames/10) == 0) {
									
									System.out.println(((p1wins + p2wins)/(double)(numGames))*100 + "%");
								}
								
								init(1, 0, false);
							}
							else {
								
								System.out.println("Player 1 wins: " + p1wins);
								System.out.println("Player 2 wins: " + p2wins);
								State.setState(game.getMenuState());
								((MenuState)(game.getMenuState())).init();
							}*/
							
						}
						else if (mode >= 3) {
							
							State.setState(game.getMenuState());
							((MenuState)(game.getMenuState())).init();
						}
						
					}
					else {
						
						suddenDeath();
					}
				}
			}
				
		}
		
		
	}

	@Override
	public void render(Graphics g) {
		
		//System.out.println(player2.getY());
		
		if (!mapRendered) {
			
			g.clearRect(0, 0, 1280, 720);
			screenRefreshManager.reset();
			mapRendered = true;
			
		}
		
		screenRefreshManager.render(g, map); 
		
		if (map == 0) {
			
			g.setColor(Color.black);
			g.fillRect(smashStageLeft, floorY, smashStageRight - smashStageLeft, floorHeight);
		}
		
		player1.render(g, showBoxes);
		player2.render(g, showBoxes);
		magicBall.render(g);
		
		if (!projectiles.isEmpty()) {
			
			for (Projectile projectile : projectiles) {
				
				projectile.render(g, showBoxes);
			}
		}
		
		
		if (hitEffectActive) {
			//System.out.println(hitEffect.getFrameCounter());
			g.drawImage(hitEffect.getImage(), hitEffect.getX(), hitEffect.getY(), hitEffect.getWidth(), hitEffect.getHeight(), null);
		}
		
		
		
		if (player1.getFrozen()) {
			
			g.drawImage(Assets.snowFlake, 300, 50, 50, 50, null);
		}
		
		if (player2.getFrozen()) {
			
			g.drawImage(Assets.snowFlake, 930, 50, 50, 50, null);
		}

		if (!isSmash) {
			

			g.setColor(Color.red);
			if (player1.getHealth() > 0)
				g.fillRect(290 + (300 - 2*player1.getHealth()), 20, 2*player1.getHealth(), 20);
			if (player2.getHealth() > 0)
				g.fillRect(690, 20, 2*player2.getHealth(), 20);
		}
		else {
			Text.drawString(g, "" + ((SmashPlayer)player1).getPercent() + "%", 590 - g.getFontMetrics(Assets.font15).stringWidth("" + ((SmashPlayer)player1).getPercent() + "%"), 37, false, Color.black, Assets.font25);
			Text.drawString(g, "" + ((SmashPlayer)player2).getPercent() + "%", 690, 37, false, Color.black, Assets.font25);
		}
		
		g.setColor(Color.green);
		g.fillRect(390 + (200 - 2*player1.getShield()), 45, 2*player1.getShield(), 20);
		g.fillRect(690, 45, 2*player2.getShield(), 20);
		
		g.setColor(Color.decode("2799606"));
		g.fillRect(490 + (100 - 10*player1.getMagic()), 70, 10*player1.getMagic(), 20);
		g.fillRect(690, 70, 10*player2.getMagic(), 20);
		
		g.setColor(Color.black);
		if (!isSmash) {
			g.drawRect(290, 20, 300, 20);
			g.drawRect(690, 20, 300, 20);
		}
		
		g.drawRect(390, 45, 200, 20);
		g.drawRect(690, 45, 200, 20);
		
		g.drawRect(490, 70, 100, 20);
		g.drawRect(690, 70, 100, 20);
		
		for (int x = 10; x <= 90; x += 10) {
			
			g.drawLine(490 + x, 70, 490 + x, 90);
		}
		
		for (int x = 10; x <= 90; x += 10) {
			
			g.drawLine(690 + x, 70, 690 + x, 90);
		}
		
		
		if (map == 2 || map == 3) {
			
			Text.drawString(g, player1.getName(), 590 - g.getFontMetrics(Assets.font15).stringWidth("JOGADOR 1"), 15, false, Color.white, Assets.font15);
			Text.drawString(g, player2.getName(), 690, 15, false, Color.white, Assets.font15);
		}
		else {
			
			Text.drawString(g, player1.getName(), 590 - g.getFontMetrics(Assets.font15).stringWidth("JOGADOR 1"), 15, false, Color.black, Assets.font15);
			Text.drawString(g, player2.getName(), 690, 15, false, Color.black, Assets.font15);
		}
		if (!training) {
			
			g.setColor(Color.green);
			
			int nCircles1, nCircles2;
			if (isSmash) {
				nCircles1 =  maxScore - player2.getScore();
				nCircles2 = maxScore - player1.getScore();
			}
			else {
				nCircles1 = player1.getScore();
				nCircles2 = player2.getScore();
			}
			for (int i = 0; i < nCircles1; i++) {
				
				g.fillOval(475 - 12*i, 6, 8, 8);
				
			}
			for (int i = 0; i < nCircles2; i++) {
				
				g.fillOval(800 + 12*i, 6, 8, 8);
				
			}
			
			g.setColor(Color.black);
			
			for (int i = 0; i < maxScore; i++) {
					
				g.drawOval(475 - 12*i, 6, 8, 8);
				g.drawOval(800 + 12*i, 6, 8, 8);
			}
			
		}
	
		
		if (!fighting) {
			
			if (isSmash && winner != 0) {
				if (KOscreenTimer < 180 && countdownTimer == 210) {
					
					g.drawImage(Assets.KOscreen, 490, 210, 300, 300, null);
				}
			}
			
			if (((isSmash && player1.getScore() + player2.getScore() == 0) || suddenDeath) && !training) {
				if (countdownTimer < 60) {
					
					g.drawImage(Assets.countdown[0], 540, 260, 200, 200, null);
				}
				
				else if (countdownTimer >= 60 && countdownTimer < 120) {
					
					g.drawImage(Assets.countdown[1], 540, 260, 200, 200, null);
				}
				
				else if (countdownTimer >= 120 && countdownTimer < 180) {
					
					g.drawImage(Assets.countdown[2], 540, 260, 200, 200, null);
				}
				
				else if (countdownTimer < 210) {
					
					g.drawImage(Assets.fight, 490, 210, 300, 300, null);
				}
			}
			if (winner == 1) {
				
				if (map == 2 || map == 3)
					Text.drawString(g, player1.getName() + " VENCEU!", 640, 190, true, Color.white, Assets.font30);
				else
					Text.drawString(g, player1.getName() + " VENCEU!", 640, 190, true, Color.black, Assets.font30);
			}
			else if (winner == 2) {
				
				if (map == 2 || map == 3)
					Text.drawString(g, player2.getName() + " VENCEU!", 640, 190, true, Color.white, Assets.font30);
				else
					Text.drawString(g, player2.getName() + " VENCEU!", 640, 190, true, Color.black, Assets.font30);
			}
			else if (winner < 0) {
				
				if (map == 2 || map == 3)
					Text.drawString(g, "EMPATE! MORTE SÚBITA INICIANDO...", 640, 190, true, Color.white, Assets.font30);
				else
					Text.drawString(g, "EMPATE! MORTE SÚBITA INICIANDO...", 640, 190, true, Color.black, Assets.font30);
			}
			
		}
		
		if (paused) {
			
			g.setColor(new Color(0, 0, 0, 100));
			g.fillRect(0, 0, 1280, 720);
			Text.drawString(g, "JOGO PAUSADO", 640, 200, true, Color.white, Assets.font30);
			
			resumeButton.drawButton(g);
			if (mode <= 2)
				characterButton.drawButton(g);
			menuButton.drawButton(g);
		}
		
		else if (training) {
			
			resetButton.drawButton(g);
			hitboxButton.drawButton(g);
			speedButton.drawButton(g);
			
			if (map == 2 || map == 3)
				Text.drawString(g, "Bot de treino:", 70, 190, true, Color.white, Assets.font20);
			else
				Text.drawString(g, "Bot de treino:", 70, 190, true, Color.black, Assets.font20);
			
			trainingBotButton.drawButton(g);
			
			if (trainingBotOn) {
				botBehaviorButton.drawButton(g);
				
				switch (botBehavior) {
					case 0:
						if (map == 2 || map == 3)
							Text.drawString(g, "Controlar", 140, 290, false, Color.white, Assets.font20);
						else
							Text.drawString(g, "Controlar", 140, 290, false, Color.black, Assets.font20);
						break;
					case 1:
						if (map == 2 || map == 3)
							Text.drawString(g, "Pular", 140, 290, false, Color.white, Assets.font20);
						else
							Text.drawString(g, "Pular", 140, 290, false, Color.black, Assets.font20);
						break;
					case 2:
						if (map == 2 || map == 3)
							Text.drawString(g, "Golpe Neutro", 140, 290, false, Color.white, Assets.font20);
						else
							Text.drawString(g, "Golpe Neutro", 140, 290, false, Color.black, Assets.font20);
						break;
					case 3:
						if (map == 2 || map == 3)
							Text.drawString(g, "Golpe pro Lado", 140, 290, false, Color.white, Assets.font20);
						else
							Text.drawString(g, "Golpe pro Lado", 140, 290, false, Color.black, Assets.font20);
						break;
					case 4:
						if (map == 2 || map == 3)
							Text.drawString(g, "Golpe pra Cima", 140, 290, false, Color.white, Assets.font20);
						else
							Text.drawString(g, "Golpe pra Cima", 140, 290, false, Color.black, Assets.font20);
						break;
					case 5:
						if (map == 2 || map == 3)
							Text.drawString(g, "Bot Fácil", 140, 290, false, Color.white, Assets.font20);
						else
							Text.drawString(g, "Bot Fácil", 140, 290, false, Color.black, Assets.font20);
						break;
					case 6:
						if (map == 2 || map == 3)
							Text.drawString(g, "Bot Médio", 140, 290, false, Color.white, Assets.font20);
						else
							Text.drawString(g, "Bot Médio", 140, 290, false, Color.black, Assets.font20);
						break;
					case 7:
						if (map == 2 || map == 3)
							Text.drawString(g, "Bot Difícil", 140, 290, false, Color.white, Assets.font20);
						else
							Text.drawString(g, "Bot Difícil", 140, 290, false, Color.black, Assets.font20);
						break;
				}
				
				if (botBehavior <= 4) {
					botEscapeButton.drawButton(g);
					switch (botEscape) {
						case 0:
							if (map == 2 || map == 3)
								Text.drawString(g, "Nada", 140, 340, false, Color.white, Assets.font20);
							else
								Text.drawString(g, "Nada", 140, 340, false, Color.black, Assets.font20);
							break;
						case 1:
							if (map == 2 || map == 3)
								Text.drawString(g, "Pular", 140, 340, false, Color.white, Assets.font20);
							else
								Text.drawString(g, "Pular", 140, 340, false, Color.black, Assets.font20);
							break;
						case 2:
							if (map == 2 || map == 3)
								Text.drawString(g, "Aéreo pra Frente", 140, 340, false, Color.white, Assets.font20);
							else
								Text.drawString(g, "Aéreo pra Frente", 140, 340, false, Color.black, Assets.font20);
							break;
						case 3:
							if (map == 2 || map == 3)
								Text.drawString(g, "Aéreo pra Cima", 140, 340, false, Color.white, Assets.font20);
							else
								Text.drawString(g, "Aéreo pra Cima", 140, 340, false, Color.black, Assets.font20);
							break;
						case 4:
							if (map == 2 || map == 3)
								Text.drawString(g, "Especial Neutro", 140, 340, false, Color.white, Assets.font20);
							else
								Text.drawString(g, "Especial Neutro", 140, 340, false, Color.black, Assets.font20);
							break;
						case 5:
							if (map == 2 || map == 3)
								Text.drawString(g, "Escudo Antes", 140, 340, false, Color.white, Assets.font20);
							else
								Text.drawString(g, "Escudo Antes", 140, 340, false, Color.black, Assets.font20);
							break;
						case 6:
							if (map == 2 || map == 3)
								Text.drawString(g, "Airdash Direita", 140, 340, false, Color.white, Assets.font20);
							else
								Text.drawString(g, "Airdash Direita", 140, 340, false, Color.black, Assets.font20);
							break;
						case 7:
							if (map == 2 || map == 3)
								Text.drawString(g, "Airdash Esquerda", 140, 340, false, Color.white, Assets.font20);
							else
								Text.drawString(g, "Airdash Esquerda", 140, 340, false, Color.black, Assets.font20);
							break;
					}
				}
				/*
				botPlayerButton.drawButton(g);
				if (map == 2 || map == 3) {
					Text.drawString(g, "" + botPlayer, 140, 390, false, Color.white, Assets.font20);
				}
				else {
					Text.drawString(g, "" + botPlayer, 140, 390, false, Color.black, Assets.font20);
				}
				*/
				if (map == 2 || map == 3)
					Text.drawString(g, "Ligado", 140, 240, false, Color.white, Assets.font20);
				else
					Text.drawString(g, "Ligado", 140, 240, false, Color.black, Assets.font20);
			}
			else {
				if (map == 2 || map == 3)
					Text.drawString(g, "Desligado", 140, 240, false, Color.white, Assets.font20);
				else
					Text.drawString(g, "Desligado", 140, 240, false, Color.black, Assets.font20);
			}
			
			
			comboCounter.render(g);
			percentEditor.render(g);

			if (gameSpeed == 1) {
				
				if (map == 2 || map == 3)
					Text.drawString(g, "Vel: x1", 140, 140, false, Color.white, Assets.font20);
				else
					Text.drawString(g, "Vel: x1", 140, 140, false, Color.black, Assets.font20);
			}
			else if (gameSpeed == 2) {
				
				if (map == 2 || map == 3)
					Text.drawString(g, "Vel: x0,5", 140, 140, false, Color.white, Assets.font20);
				else
					Text.drawString(g, "Vel: x0,5", 140, 140, false, Color.black, Assets.font20);
			}
			else {
				
				frameButton.drawButton(g);
				if (map == 2 || map == 3)
					Text.drawString(g, "Vel: 1 frame", 140, 140, false, Color.white, Assets.font20);
				else
					Text.drawString(g, "Vel: 1 frame", 140, 140, false, Color.black, Assets.font20);
			}
		
		}

		
	}
	
	private void newRound() {
		countdownTimer = 0;
		if (!isSmash) {
			//BIG AQU
			hitEffectActive = false;
			hitEffect.resetFrameCounter();
		}
		KOscreenTimer = 0;
		parryFreezeCounter = 0;
		if (!isSmash) {
			player1.restoreRound();
			player2.restoreRound();
		}
		else {
			if (player1.getHealth() == 0)
				player1.restoreRound();
			else if (player2.getHealth() == 0) {
				player2.restoreRound();
			}
		}

		if (!isSmash) {
			projectiles.clear();
			magicBall.grab();
		}
		if (player1.character instanceof Carol) {
			
			((Carol)(player1.character)).endSuper();
			player1.jumps = 2;
		}
		
		if (player2.character instanceof Carol) {
			
			((Carol)(player2.character)).endSuper();
			player2.jumps = 2;
		}
		
		if (!isSmash) {
			if (player1.character instanceof Lacerda) {
				
				((Lacerda)(player1.character)).resetBomb();
			}
			
			if (player2.character instanceof Lacerda) {
				
				((Lacerda)(player2.character)).resetBomb();
			}
		}
		
		if (!isSmash) {
			if (player1.character instanceof Obino) {
				
				((Obino)(player1.character)).deactivateTrap();
			}
			
			if (player2.character instanceof Obino) {
				
				((Obino)(player2.character)).deactivateTrap();
			}
		}
	}
	
	private void suddenDeath() {
		suddenDeath = true;
		countdownTimer = 0;
		winner = 0;
		hitEffectActive = false;
		hitEffect.resetFrameCounter();
		KOscreenTimer = 0;
		parryFreezeCounter = 0;
		player1.setSuddenDeath();
		player2.setSuddenDeath();
		projectiles.clear();
		magicBall.grab();
		
		if (player1.character instanceof Carol) {
			
			((Carol)(player1.character)).endSuper();
		}
		
		if (player2.character instanceof Carol) {
			
			((Carol)(player2.character)).endSuper();
		}
		
		if (player1.character instanceof Lacerda) {
			
			((Lacerda)(player1.character)).resetBomb();
		}
		
		if (player2.character instanceof Lacerda) {
			
			((Lacerda)(player2.character)).resetBomb();
		}
		
		if (player1.character instanceof Obino) {
			
			((Obino)(player1.character)).deactivateTrap();
		}
		
		if (player2.character instanceof Obino) {
			
			((Obino)(player2.character)).deactivateTrap();
		}
	}
	
	public Player getPlayer1() {
		
		return player1;
	}
	
	
	public Player getPlayer2() {
		
		return player2;
	}
	
	public SmashPlayer getSmashPlayer2() {
		return (SmashPlayer)player2;
	}
	
	public static int getParryFreezeCounter() {
		
		return parryFreezeCounter;
	}

	public static HitEffect getHitEffect() {
		
		return hitEffect;
	}
	
	
	public static void setParryFreezeCounter(int frames) {
		
		parryFreezeCounter = frames;
	}
	
	public static void decreaseParryFreezeCounter() {
		
		parryFreezeCounter--;
	}

	
	
	

}

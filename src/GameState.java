import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class GameState extends State {

	private SmashPlayer player1, player2;
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
	private Button hitboxButton, resetButton, restartButton, speedButton, frameButton, lockShieldButton, saveStateButton, loadStateButton, trainingBotButton, botBehaviorButton, botEscapeButton, botPlayerButton, menuButton, characterButton, resumeButton;
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
	private class TrainingSaveState {
		double p1x, p1y, p2x, p2y;
		int p1ld, p2ld, p1pc, p2pc, p1h, p2h;
		public void saveTrainingState() {
			p1x = player1.getX();
			p2x = player2.getX();
			p1y = player1.getY();
			p2y = player2.getY();
			p1ld = player1.getLookDirection();
			p2ld = player2.getLookDirection();
			p1pc = ((SmashPlayer)(player1)).getPercent();
			p2pc = ((SmashPlayer)(player2)).getPercent();
			p1h = player1.getHealth();
			p2h = player2.getHealth();
		}
		public void loadTrainingState() {
			player1.setPosition(p1x, p1y);
			player2.setPosition(p2x, p2y);
			player1.lookDirection = p1ld;
			player2.lookDirection = p2ld;
			((SmashPlayer)player1).setPercent(p1pc);
			((SmashPlayer)player2).setPercent(p2pc);
			player1.hitstunFrames = 0;
			player1.freezeFrames = 0;
			player1.xSpeed = 0;
			player1.ySpeed = 0;
			player2.hitstunFrames = 0;
			player2.freezeFrames = 0;
			player2.xSpeed = 0;
			player2.ySpeed = 0;
			player1.maxShield();
			player2.maxShield();
			player1.health = p1h;
			player2.health = p2h;
		}
		
	}
	private TrainingSaveState trainingSaveState = new TrainingSaveState();
	
	public ComboCounter comboCounter = new ComboCounter();
	
	private PercentEditor percentEditor;
	private HitsToEscapeEditor hitsToEscapeEditor;
	private boolean lockShield = false;
	
	public static int smashStageLeft = 150;
	public static int smashStageRight = 1130;
	
	public static final double GRAVITY = 1;
	
	private boolean playingReplay = false;
	
	private InputRecorder inputRecorder = new InputRecorder(game);
	public static Random random;
	public static long randomSeed;
	
	public GameState(Game game) {
		
		super(game);
		
		
	}
	
	
	public void init(int mode, int map, boolean suddenDeath) {
		
		//mode 1 = regular pvp fight
		//mode 2 = training pvp
		//mode 3 = bot
		
		
		
		//mode = 5;
		
		rightWall = 2000;
		leftWall = -1000;
		
		
		mapRendered = false;
		
		this.mode = mode;
		this.map = map;
		//this.map = 0;
		this.suddenDeath = suddenDeath;
		

		projectiles.clear();
		
		if (mode == 2) {
			
			training = true;
		}
		else
			training = false;
		
		
		if (mode <= 2) {
			
			
			player1 = new SmashPlayer(game, 1, ((CharacterSelectState)(game.getCharacterSelectState())).getPlayer1Char(), 240, floorY - 200, "JOGADOR 1", ((CharacterSelectState)(game.getCharacterSelectState())).getPlayer1InputDelay());
			player2 = new SmashPlayer(game, 2, ((CharacterSelectState)(game.getCharacterSelectState())).getPlayer2Char(), 840, floorY - 200, "JOGADOR 2", ((CharacterSelectState)(game.getCharacterSelectState())).getPlayer2InputDelay());
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
		if (mode == 5) {
			playingReplay = true;
			inputRecorder.startPlaying();
			player1 = new SmashPlayer(game, 1, inputRecorder.getP1Character(), 240, floorY - 200, "JOGADOR 1");
			player2 = new SmashPlayer(game, 2, inputRecorder.getP2Character(), 840, floorY - 200, "JOGADOR 2");
			this.map = inputRecorder.getGameMap();
		}
		else {
			playingReplay = false;
		}
		
		if (!training && !playingReplay) {				
			inputRecorder.startRecording();
		}
		
		if (!playingReplay) {			
			random = new Random();
			randomSeed = System.currentTimeMillis();
			random.setSeed(randomSeed);
		}
		else {
			random = new Random();
			random.setSeed(inputRecorder.getRandomSeed());
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
		maxScore = 4;

		
		
		if (mode <= 2) {
			
			resumeButton = new Button(game, 540, 265, 200, 50, Color.darkGray, "SEGUIR JOGANDO", Assets.font20, null, true);
			characterButton = new Button(game, 500, 335, 280, 50, Color.darkGray, "ESCOLHER PERSONAGENS", Assets.font20, null, true);
			menuButton = new Button(game, 540, 475, 200, 50, Color.darkGray, "VOLTAR AO MENU", Assets.font20, null, true);
			restartButton = new Button(game, 540, 405, 200, 50, Color.darkGray, "RECOMEÇAR", Assets.font20, null, true);
		}
		else if (mode >= 3) {
			
			resumeButton = new Button(game, 540, 300, 200, 50, Color.darkGray, "SEGUIR JOGANDO", Assets.font20, null, true);
			menuButton = new Button(game, 540, 440, 200, 50, Color.darkGray, "VOLTAR AO MENU", Assets.font20, null, true);
			restartButton = new Button(game, 540, 370, 200, 50, Color.darkGray, "RECOMEÇAR", Assets.font20, null, true);
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
			saveStateButton = new Button(game, 1150, 120, 55, 40, Color.darkGray, "SALVAR", Assets.font10, null, true);
			loadStateButton = new Button(game, 1215, 120, 55, 40, Color.darkGray, "CARREGAR", Assets.font10, null, true);
			lockShieldButton = new Button(game, 1150, 170, 120, 40, Color.DARK_GRAY, "TRAVAR ESCUDO", Assets.font10, null, true);
			percentEditor = new PercentEditor(game);
			hitsToEscapeEditor = new HitsToEscapeEditor(game);
			trainingSaveState.saveTrainingState();
			comboCounter.reset();
		}
		
	}
	
	@Override
	public void tick() {

		//System.out.println(player2.getX() + 100);
		
		
		if (fighting) { 
			
			screenRefreshManager.setChange(30, 600, 300, 100);

			if (game.getKeyManager(1).pause) {
				
				if (gameSpeed != 3) {
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
					
					if (mode == 1) {
						if (restartButton.buttonPressed()) {
							hitEffectActive = false;
							hitEffect.resetFrameCounter();
							KOscreenTimer = 0;
							countdownTimer = 0;
							parryFreezeCounter = 0;
							
							resetCharacters();
							
							if (!playingReplay) {
								inputRecorder.stopRecording(player1.character, player2.character, map);
							}
							
							init(mode, map, false);
						}
					}
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
					
					
					screenRefreshManager.setChange(290, 20, 700, 90);
					
					if (training) {
						
						if (frameButton.buttonPressed()) {
							playFrame = true;
						}
						if (game.getKeyManager(1).pause) {
							if (!pausePressed) {
								pausePressed = true;
								playFrame = true;
							}
						}
						else {
							pausePressed = false;
						}
					}
					
					
					if (gameSpeed != 3 || playFrame) {
						
						
						
						player1.measureCollision();
						player2.measureCollision();
						if (!playingReplay) {
							player1.getInput();
							player2.getInput();
						}
						else {
							byte[] frameInputs = inputRecorder.getFrameInputs();
							player1.getReplayInput(frameInputs[0]);
							player2.getReplayInput(frameInputs[1]);
						}
						if (!training && !playingReplay) {
							inputRecorder.recordInputs(player1, player2);
						}
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
						magicBall.tick(player1, player2);
					else {
						
						player1.maxMagic();
						player2.maxMagic();
						if (lockShield) {
							player1.maxShield();
							player2.maxShield();
						}
						
						percentEditor.tick();
						
						if (resetButton.buttonPressed()) {
							
							player1.maxHP();
							player2.maxHP();
							/*if (isSmash) {
								player1.restoreRound();
								player2.restoreRound();
							}*/
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
						if (lockShieldButton.buttonPressed()) {
							lockShield = !lockShield;
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
						if (saveStateButton.buttonPressed()) {
							trainingSaveState.saveTrainingState();
						}
						if (loadStateButton.buttonPressed()) {
							trainingSaveState.loadTrainingState();
							comboCounter.reset();
						}
						
						if (player1.pressingAttack && player1.pressingSpecial && player1.pressingShield) {
							trainingSaveState.loadTrainingState();
							comboCounter.reset();
						}
						
						if (trainingBotButton.buttonPressed()) {
							trainingBotOn = !trainingBotOn;
							screenRefreshManager.setChange(10, 160, 200, 200);
							screenRefreshManager.setChange(0, 0, 1280, 30);
							screenRefreshManager.setChange(0, 0, 300, 500);
							double p2X = player2.getX();
							double p2Y = player2.getY();
							if (trainingBotOn) {
								player2 = new SmashTrainingBot(game, 2, ((CharacterSelectState)(game.getCharacterSelectState())).getPlayer2Char(), p2X, p2Y);
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
							hitsToEscapeEditor.tick();
							if (botBehaviorButton.buttonPressed()) {
								double p2X = player2.getX();
								double p2Y = player2.getY();
								screenRefreshManager.setChange(0, 0, 300, 500);
								screenRefreshManager.setChange(0, 0, 1280, 30);
								botBehavior++;
								if (botBehavior > 9) {
									botBehavior = 0;
									player2 = new SmashTrainingBot(game, 2, ((CharacterSelectState)(game.getCharacterSelectState())).getPlayer2Char(), p2X, p2Y);
									player2.setOpponent(player1);
									player1.setOpponent(player2);
									((CharacterSelectState)(game.getCharacterSelectState())).getPlayer2Char().resetAttackCounters();
									((SmashTrainingBot)(player2)).setEscapeOption(botEscape);
								}
								if (botBehavior <= 6) {
									((SmashTrainingBot)(player2)).setBehaviorOption(botBehavior);
								}
								else if (botBehavior == 7) {
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
								else if (botBehavior == 8) {
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
								else if (botBehavior == 9) {
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
							if (botBehavior <= 6) {
								if (botEscapeButton.buttonPressed()) {
									screenRefreshManager.setChange(0, 0, 300, 500);
									botEscape++;
									if (botEscape > 9) {
										botEscape = 0;
									}
									((SmashTrainingBot)(player2)).setEscapeOption(botEscape);
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
							SoundManager.play("sounds/Death.wav", false);
							player1.restoreRound();
							if (!training)
								player2.increaseScore();
							
						}
					
						if (player2.getHealth() <= 0) {
						
							fighting = false;
							SoundManager.play("sounds/Death.wav", false);
							player2.restoreRound();
							if (!training)
								player1.increaseScore();
							else {
								percentEditor.resetBotPercent();
							}
						}
					}
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
				
				if (training || !suddenDeath && player1.getScore() + player2.getScore() != 0) {
					countdownTimer = 209;
				}
				countdownTimer++;
				if (countdownTimer == 210) {
					
					fighting = true;
				}
			}
			
			
			else if (countdownTimer >= 210) {
				
				if (winner == 0)
					KOscreenTimer = 179;
				
				KOscreenTimer++;
				if (KOscreenTimer == 181)
					KOscreenTimer = 180;
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
						
						
						if (mode != 3 && mode != 4) {
							if (restartButton.buttonPressed()) {
								SoundManager.clear();
								hitEffectActive = false;
								hitEffect.resetFrameCounter();
								KOscreenTimer = 0;
								countdownTimer = 0;
								parryFreezeCounter = 0;
								
								resetCharacters();
								
								if (!playingReplay) {
									inputRecorder.stopRecording(player1.character, player2.character, map);
								}
								
								init(mode, map, false);
							}
						}
						
						if (menuButton.buttonPressed()) {
							SoundManager.clear();
							hitEffectActive = false;
							hitEffect.resetFrameCounter();
							KOscreenTimer = 0;
							countdownTimer = 0;
							parryFreezeCounter = 0;
							
							if (!playingReplay) {
								inputRecorder.stopRecording(player1.character, player2.character, map);
							}
							
							if (mode <= 2) {
								
								State.setState(game.getCharacterSelectState());
								((CharacterSelectState)(game.getCharacterSelectState())).init();
								

								
							}
							else if (mode >= 3) {
								
								State.setState(game.getMenuState());
								((MenuState)(game.getMenuState())).init();
							}
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
			
			g.setColor(Color.LIGHT_GRAY);
			for (int i = 0; i < 720; i+=80) {
				g.drawLine(0, i, 1280, i);
				g.drawLine(0, i+1, 1280, i+1);
			}
			for (int j = 0; j < 1280; j+=80) {
				g.drawLine(j, 0, j, 720);
				g.drawLine(j+1, 0, j+1, 720);
			}
			g.setColor(Color.black);
			g.fillRect(smashStageLeft, floorY, smashStageRight - smashStageLeft, floorY);
			
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



		Color textColor;
		if (map == 2 || map == 3) {
			textColor = Color.white;
		}
		else {
			textColor = Color.black;
		}
		//Text.drawString(g, "" + ((SmashPlayer)player1).getPercent() + "%", 590 - g.getFontMetrics(Assets.font15).stringWidth("" + ((SmashPlayer)player1).getPercent() + "%"), 37, false, textColor, Assets.font30);
		//Text.drawString(g, "" + ((SmashPlayer)player2).getPercent() + "%", 690, 37, false, textColor, Assets.font30);
		PercentRenderer.renderPercent(g, player1, 590, 20, false);
		PercentRenderer.renderPercent(g, player2, 710, 20, true);
		
		g.setColor(Color.green);
		if (player1.getShield() < 20)
			g.setColor(Color.decode("1547309"));
		g.fillRect(390 + (200 - 2*player1.getShield()), 55, 2*player1.getShield(), 20);
		g.setColor(Color.green);
		if (player2.getShield() < 20)
			g.setColor(Color.decode("1547309"));
		g.fillRect(690, 55, 2*player2.getShield(), 20);
		
		g.setColor(Color.decode("2799606"));
		g.fillRect(490 + (100 - 10*player1.getMagic()), 80, 10*player1.getMagic(), 20);
		g.fillRect(690, 80, 10*player2.getMagic(), 20);
		
		g.setColor(Color.black);
		
		g.drawRect(390, 55, 200, 20);
		g.drawRect(690, 55, 200, 20);
		
		g.drawRect(490, 80, 100, 20);
		g.drawRect(690, 80, 100, 20);
		
		for (int x = 10; x <= 90; x += 10) {
			
			g.drawLine(490 + x, 80, 490 + x, 100);
		}
		
		for (int x = 10; x <= 90; x += 10) {
			
			g.drawLine(690 + x, 80, 690 + x, 100);
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

			nCircles1 =  maxScore - player2.getScore();
			nCircles2 = maxScore - player1.getScore();

			for (int i = 0; i < nCircles1; i++) {
				
				//g.fillOval(475 - 12*i, 6, 8, 8);
				g.drawImage(player1.character.stockIcon, 470 - 25*i, 10, 27, 27, null);
				
			}
			for (int i = 0; i < nCircles2; i++) {
				
				//g.fillOval(800 + 12*i, 6, 8, 8);
				g.drawImage(player2.character.stockIcon, 795 + 25*i, 10, 27, 27, null);
			}
			
		}
	
		
		if (!fighting) {
			
			if (winner != 0) {
				if (KOscreenTimer < 180 && countdownTimer == 210) {
					
					g.drawImage(Assets.KOscreen, 490, 210, 300, 300, null);
				}
				else if (KOscreenTimer == 180 && countdownTimer == 210) {
					menuButton.drawButton(g);
					if (mode != 3 && mode != 4) {
						restartButton.drawButton(g);
					}
				}
			}
			
			if (((player1.getScore() + player2.getScore() == 0) || suddenDeath) && !training) {
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
			Text.drawString(g, "JOGO PAUSADO", 640, 120, true, Color.white, Assets.font30);
			if (training) {
				Text.drawString(g, "ATALHOS DE TREINO:", 640, 180, true, Color.white, Assets.font20);
				Text.drawString(g, "Passar Frame: Pause", 640, 220, true, Color.white, Assets.font20);
				Text.drawString(g, "Carregar Savestate: Escudo + Ataque + Especial", 640, 240, true, Color.white, Assets.font20);
			}
			resumeButton.drawButton(g);
			if (mode <= 2) {
				characterButton.drawButton(g);
				if (mode == 1) {
					restartButton.drawButton(g);
				}
			}
			menuButton.drawButton(g);
		}
		
		else if (training) {
			
			resetButton.drawButton(g);
			hitboxButton.drawButton(g);
			speedButton.drawButton(g);
			saveStateButton.drawButton(g);
			loadStateButton.drawButton(g);
			lockShieldButton.drawButton(g);
			
			if (map == 2 || map == 3)
				Text.drawString(g, "Bot de treino:", 70, 190, true, Color.white, Assets.font20);
			else
				Text.drawString(g, "Bot de treino:", 70, 190, true, Color.black, Assets.font20);
			
			trainingBotButton.drawButton(g);
			
			if (trainingBotOn) {
				botBehaviorButton.drawButton(g);
				hitsToEscapeEditor.render(g);
				
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
							Text.drawString(g, "IJAD AF", 140, 290, false, Color.white, Assets.font20);
						else
							Text.drawString(g, "IJAD AF", 140, 290, false, Color.black, Assets.font20);
						break;
					case 6:
						if (map == 2 || map == 3)
							Text.drawString(g, "IJAD AC", 140, 290, false, Color.white, Assets.font20);
						else
							Text.drawString(g, "IJAD AC", 140, 290, false, Color.black, Assets.font20);
						break;
					case 7:
						if (map == 2 || map == 3)
							Text.drawString(g, "Bot Fácil", 140, 290, false, Color.white, Assets.font20);
						else
							Text.drawString(g, "Bot Fácil", 140, 290, false, Color.black, Assets.font20);
						break;
					case 8:
						if (map == 2 || map == 3)
							Text.drawString(g, "Bot Médio", 140, 290, false, Color.white, Assets.font20);
						else
							Text.drawString(g, "Bot Médio", 140, 290, false, Color.black, Assets.font20);
						break;
					case 9:
						if (map == 2 || map == 3)
							Text.drawString(g, "Bot Difícil", 140, 290, false, Color.white, Assets.font20);
						else
							Text.drawString(g, "Bot Difícil", 140, 290, false, Color.black, Assets.font20);
						break;
				}
				
				if (botBehavior <= 6) {
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
						case 8:
							if (map == 2 || map == 3)
								Text.drawString(g, "Airdash Cima", 140, 340, false, Color.white, Assets.font20);
							else
								Text.drawString(g, "Airdash Cima", 140, 340, false, Color.black, Assets.font20);
							break;
						case 9:
							if (map == 2 || map == 3)
								Text.drawString(g, "Airdash Baixo", 140, 340, false, Color.white, Assets.font20);
							else
								Text.drawString(g, "Airdash Baixo", 140, 340, false, Color.black, Assets.font20);
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
		KOscreenTimer = 0;
		parryFreezeCounter = 0;

		
		if (player1.getHealth() == 0)
			player1.restoreRound();
		else if (player2.getHealth() == 0) {
			player2.restoreRound();
		}
	
		if (player1.character instanceof Carol) {
			
			((Carol)(player1.character)).endSuper();
			player1.jumps = 2;
		}
		
		if (player2.character instanceof Carol) {
			
			((Carol)(player2.character)).endSuper();
			player2.jumps = 2;
		}
	}
	
	private void resetCharacters() {
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

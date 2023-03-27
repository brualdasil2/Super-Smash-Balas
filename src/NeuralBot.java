import java.util.Random;

import com.github.chen0040.rl.learning.qlearn.QLearner;

import basicneuralnetwork.NeuralNetwork;

public class NeuralBot extends SmashPlayer {
	
	//public static int ATK = 0, DEF = 1, NEU = 2;
	
	//private int[] layerSizes = {29, 20, 16, 16, 8};
	//private NeuralNetwork brain = new NeuralNetwork(29, 8, layerSizes);
	private QLearner brain;
	private int frameCounter = 0;
	private boolean opponentOnRight = false, opponentOnLeft = false;
	private int actionChosen = 0;
	
	public NeuralBot(Game game, int playerNumb, Character character, double x, double y, QLearner brain) {
		
		super(game, playerNumb, character, x, y, "BOT (N)", 10);
		this.brain = brain;
	}
	
	
	public void setPlayerParams(int playerNumb) {
		this.playerNumb = playerNumb;
		if (playerNumb == 1) {
			this.x = 240;
		}
		else {
			this.x = 840;
		}
		this.y = GameState.floorY - 200;
	}

	private int chooseRandomIndex(double[] arr) {
        double[] cumulativeProbs = new double[arr.length];
        double sum = 0.0;
        
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            cumulativeProbs[i] = sum;
        }
        
        double rand = new Random().nextDouble() * sum;
        
        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (rand <= cumulativeProbs[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        
        return lo;
    }
	
	private void setFrames(int frames) {
		
		if (frameCounter == 0)
			frameCounter = frames;
		
		frameCounter--;
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
	
	private void stand() {
		setFrames(5);
	}
	private void shortShield() {
		setFrames(15);
		pressingShield = true;
	}
	private void longShield() {
		setFrames(30);
		pressingShield = true;
	}
	private void shortDashAway() {
		setFrames(15);
		if (opponentOnLeft)
			pressingRight = true;
		if (opponentOnRight)
			pressingLeft = true;
	}
	private void longDashAway() {
		
		setFrames(30);
		
		if (opponentOnLeft)
			pressingRight = true;
		if (opponentOnRight)
			pressingLeft = true;
	}
	private void shortDashTo() {
		setFrames(15);
		if (opponentOnLeft) {
			pressingLeft = true;
		}
		if (opponentOnRight) {	
			pressingRight = true;
		}
	}
	private void longDashTo() {
		setFrames(30);
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
		setFrames(15);
		pressingJump = true;
	}
	private void jumpTo() {	
		setFrames(20);
		if (frameCounter == 9) {
			turnToOpponent();
			pressingJump = true;
		}
		if (frameCounter <= 8) {	
			turnToOpponent();
		}
	}
	private void airdashTo() {
		turnToOpponent();
		pressingAirdash = true;
	}
	private void airdashAway() {
		turnAway();
		pressingAirdash = true;
	}
	private void airdashUp() {
		pressingUp = true;
		pressingAirdash = true;
	}
	private void wavedashTo() {
		setFrames(4);
		if (frameCounter == 3) {
			turnToOpponent();
			pressingJump = true;
		}
		else {
			turnToOpponent();
			pressingShield = true;
			pressingAirdash = true;
		}
	}
	private void wavedashAway() {
		setFrames(4);
		if (frameCounter == 3) {
			pressingJump = true;
		}
		else {
			turnAway();
			pressingShield = true;
			pressingAirdash = true;
		}
	}
	private void jab() {
		setFrames(4);
		if (frameCounter == 3 || frameCounter == 2) {
			turnToOpponent();
		}
		if (frameCounter == 1) {	
			pressingAttack = true;
		}
	}
	private void dashAttack() {
		setFrames(3);
		if (frameCounter == 2 || frameCounter == 1) {
			turnToOpponent();
			pressingAttack = true;
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
		setFrames(10);
		turnToOpponent();
		pressingSpecial = true;
	}
	private void upSpecial() {
		setFrames(30);
		if (frameCounter == 29) {
			pressingUp = true;
			pressingSpecial = true;
		}
	}
	private void neutralSpecial() {
		setFrames(30);
		pressingSpecial = true;
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
	
	private double distToSideBz() {
		double distToLeft = Math.abs(x - leftBlastzone);
		double distToRight = Math.abs(x - rightBlastzone);
		return (Math.min(distToLeft, distToRight));
	}
	private double distToTopBz() {
		return Math.abs(y - topBlastzone);
	}
	private double horDistToOp() {
		return Math.abs(x - opponent.x);
	}
	private double verDistToOp() {
		return Math.abs(y - opponent.y);
	}
	private double distToCenter() {
		return Math.abs((int)((x + currentAttack.getCollisionbox().getX() + currentAttack.getCollisionbox().getWidth()/2) - 640));
	}
	private boolean justShielded() {
		return framesSinceLastShield <= 20;
	}
	private int framesToPunish() {
		if (!opponent.attacking) {
			return 0;
		}
		AttackFrame attackFrames[] = opponent.getCurrentAttack().getFrames().clone();
		int uF = opponent.character.attackUF;
		int framesPunish = 0;
		for (int i = uF; i < opponent.getCurrentAttack().getUniqueFrames(); i++) {
			framesPunish += attackFrames[i].getDuration();
		}
		return (framesPunish - opponent.character.attackIF + 1); //+1 because of one extra frame to shield after
	}
	private boolean lowOnShield() {
		return shield < 20;
	}
	
	private void filterUnusableActions(double[] brainOutputs) {
		int[] mustHaveAnyStamina = {1, 2};
		int[] mustHaveSomeStamina = {9, 10, 11, 12, 13, 24, 25, 26};
		int[] mustHave2Mana = {21, 23};
		int mustHave4Mana = 22;
		
		if (shield < 5) {
			for (int i : mustHaveAnyStamina) {
				brainOutputs[i] = 0;
			}
		}
		if (shield < 20) {
			for (int i : mustHaveSomeStamina) {
				brainOutputs[i] = 0;
			}
		}
		if (magic < 2) {
			for (int i : mustHave2Mana) {
				brainOutputs[i] = 0;
			}
		}
		if (magic < 4) {
			brainOutputs[mustHave4Mana] = 0;
		}
	}
	
	public int getCurrentState() {
		//int currentState = 0;
		double myCenterX = x + currentAttack.getCollisionbox().getX() + currentAttack.getCollisionbox().getWidth()/2;
		double myCenterY = y + currentAttack.getCollisionbox().getY() + currentAttack.getCollisionbox().getHeight()/2;
		double myXInLine = myCenterX - leftBlastzone;
		double xLineSize = rightBlastzone - leftBlastzone;
		int myTileX = (int)((myXInLine/xLineSize)*8);
		return 10;
	}
	
	protected void getInput() {
		
		
		int currentState = getCurrentState();
		
		actionChosen = brain.selectAction(currentState).getIndex();
		
		opponentOnLeft = (opponent.x - x < 0);
		opponentOnRight = (opponent.x - x > 0);
		pressNothing();
		
		switch(actionChosen) {
			case 0:
				stand();
				break;
			case 1:
				shortShield();
				break;
			case 2:
				longShield();
				break;
			case 3:
				shortDashAway();
				break;
			case 4:
				longDashAway();
				break;
			case 5:
				shortDashTo();
				break;
			case 6:
				longDashTo();
				break;
			case 7:
				jump();
				break;
			case 8:
				jumpTo();
				break;
			case 9:
				airdashTo();
				break;
			case 10:
				airdashAway();
				break;
			case 11:
				airdashUp();
				break;
			case 12:
				wavedashTo();
				break;
			case 13:
				wavedashAway();
				break;
			case 14:
				jab();
				break;
			case 15:
				dashAttack();
				break;
			case 16:
				upTilt();
				break;
			case 17:
				upTilt();
				break;
			case 18:
				jumpFair();
				break;
			case 19:
				jumpBair();
				break;
			case 20:
				jumpUpAir();
				break;
			case 21:
				sideSpecial();
				break;
			case 22:
				upSpecial();
				break;
			case 23:
				neutralSpecial();
				break;
			case 24:
				ijadFair();
				break;
			case 25:
				ijadBair();
				break;
			case 26:
				ijadUpAir();
				break;
		}
	}
}

import java.util.Random;

import basicneuralnetwork.NeuralNetwork;

public class NeuralBot extends SmashPlayer {
	
	//private int[] layerSizes = {29, 20, 16, 16, 8};
	//private NeuralNetwork brain = new NeuralNetwork(29, 8, layerSizes);
	private Brain brain;
	private int frameCounter = 0;
	private boolean opponentOnRight = false, opponentOnLeft = false;
	private int actionChosen = 0;
	
	public NeuralBot(Game game, int playerNumb, Character character, double x, double y, Brain brain) {
		
		super(game, playerNumb, character, x, y, "BOT (N)");
		//brain = new NeuralNetwork(29, 2, 16, 8);
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
		setFrames(5);
		pressingShield = true;
	}
	private void longShield() {
		setFrames(15);
		pressingShield = true;
	}
	private void shortDashAway() {
		setFrames(5);
		if (opponentOnLeft)
			pressingRight = true;
		if (opponentOnRight)
			pressingLeft = true;
	}
	private void longDashAway() {
		
		setFrames(15);
		
		if (opponentOnLeft)
			pressingRight = true;
		if (opponentOnRight)
			pressingLeft = true;
	}
	private void shortDashTo() {
		setFrames(5);
		if (opponentOnLeft) {
			pressingLeft = true;
		}
		if (opponentOnRight) {	
			pressingRight = true;
		}
	}
	private void longDashTo() {
		setFrames(15);
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
	
	
	protected void getInput() {
		double[] brainInputs = new double[45];
		double[] brainOutputs = new double[27];
		brainInputs[0] = x;
		brainInputs[1] = y;
		brainInputs[2] = xSpeed;
		brainInputs[3] = ySpeed;
		brainInputs[4] = percent;
		brainInputs[5] = shield;
		brainInputs[6] = airdashCounter;
		brainInputs[7] = opponent.x;
		brainInputs[8] = opponent.y;
		brainInputs[9] = opponent.xSpeed;
		brainInputs[10] = opponent.ySpeed;
		brainInputs[11] = ((SmashPlayer)(opponent)).percent;
		brainInputs[12] = opponent.shield;
		brainInputs[13] = ((SmashPlayer)(opponent)).airdashCounter;
		brainInputs[14] = opponent.jabbing ? 1 : 0;
		brainInputs[15] = opponent.dashing ? 1 : 0;
		brainInputs[16] = opponent.upTilting ? 1 : 0;
		brainInputs[17] = opponent.fairing ? 1 : 0;
		brainInputs[18] = opponent.bairing ? 1 : 0;
		brainInputs[19] = opponent.upAiring ? 1 : 0;
		brainInputs[20] = opponent.neutralSpecialing ? 1 : 0;
		brainInputs[21] = opponent.sideSpecialing ? 1 : 0;
		brainInputs[22] = opponent.upSpecialing ? 1 : 0;
		brainInputs[23] = opponent.character.attackIF;
		brainInputs[24] = opponent.character.attackUF;
		brainInputs[25] = magic;
		brainInputs[26] = opponent.magic;
		brainInputs[27] = onAir ? 1 : 0;
		brainInputs[28] = opponent.onAir ? 1 : 0;
		brainInputs[29] = jabbing ? 1 : 0;
		brainInputs[30] = dashing ? 1 : 0;
		brainInputs[31] = upTilting ? 1 : 0;
		brainInputs[32] = fairing ? 1 : 0;
		brainInputs[33] = bairing ? 1 : 0;
		brainInputs[34] = upAiring ? 1 : 0;
		brainInputs[35] = neutralSpecialing ? 1 : 0;
		brainInputs[36] = sideSpecialing ? 1 : 0;
		brainInputs[37] = upSpecialing ? 1 : 0;
		brainInputs[38] = character.attackIF;
		brainInputs[39] = character.attackUF;
		brainInputs[40] = opponent.hitstunFrames;
		brainInputs[41] = jumps;
		brainInputs[42] = opponent.jumps;
		brainInputs[43] = shielding ? 1 : 0;
		brainInputs[44] = opponent.shielding ? 1 : 0;
		
		brainOutputs = brain.getNetwork().guess(brainInputs);
		
		if (frameCounter == 0) {
			actionChosen = chooseRandomIndex(brainOutputs);
		}
		
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

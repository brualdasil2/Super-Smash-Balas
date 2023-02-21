import basicneuralnetwork.NeuralNetwork;

public class NeuralBot extends SmashPlayer {
	
	//private int[] layerSizes = {29, 20, 16, 16, 8};
	//private NeuralNetwork brain = new NeuralNetwork(29, 8, layerSizes);
	private Brain brain;
	
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

	protected void getInput() {
		double[] brainInputs = new double[45];
		double[] brainOutputs = new double[8];
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
		//System.out.println("OUTPUTS:");
		//for (double i : brainOutputs) {
			//System.out.println(i);
		//}
		
		pressingLeft = Math.random() > brainOutputs[0];
		pressingRight = Math.random() > brainOutputs[1];
		pressingUp = Math.random() > brainOutputs[2];
		pressingShield = Math.random() > brainOutputs[3];
		pressingAttack = Math.random() > brainOutputs[4];
		pressingSpecial = Math.random() > brainOutputs[5];
		pressingJump = Math.random() > brainOutputs[6];
		pressingAirdash = Math.random() > brainOutputs[7];
	}
}

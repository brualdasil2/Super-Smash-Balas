import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class PercentRenderer {
	
	private static int DIGIT_HEIGHT = 30;
	private static int DIGIT_WIDTH = (int)(DIGIT_HEIGHT*0.6923);
	private static int PERCENT_HEIGHT = 20;
	private static int PERCENT_WIDTH = (int)(PERCENT_HEIGHT*0.6923);
	
	private static int getDigit(int number, int index) {
		return (number / (int)Math.pow(10, index))%10;
	}
	
	private static boolean allZeroAfterThis(int index, int[] digitsValues) {
		for (int i = index+1; i < 5; i++) {
			if (digitsValues[i] != 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void renderPercent(Graphics g, SmashPlayer player, int x, int y, boolean shiftLeft) {
		int percent = player.getPercent();
		double weight = player.character.weight;
		double kbMultiplier = ((0.7 + 0.00004524 * Math.pow(percent, 2) + 0.002548 * percent)/weight);
		double hsMultiplier = (0.7 + 0.00001310 * Math.pow(percent, 2) + 0.003369 * percent);
		double colorDeterminer = kbMultiplier + hsMultiplier;
		BufferedImage[] digitsImgArray;
		int[] digitsValues = new int[5];
		//System.out.println(colorDeterminer);
		if (colorDeterminer < 1.8) {
			digitsImgArray = Assets.lowDigits;
		}
		else if (colorDeterminer < 2.75) {
			digitsImgArray = Assets.midDigits;
		}
		else if (colorDeterminer < 3.5) {
			digitsImgArray = Assets.highDigits;
		}
		else {
			digitsImgArray = Assets.ultraDigits;
		}
		for (int i = 0; i < 5; i++) {
			digitsValues[i] = getDigit(percent, i);
		}
		int digitsToRender = 0;
		for (int i = 0; i < 5; i++) {
			if (allZeroAfterThis(i, digitsValues)) {
				break;
			}
			digitsToRender++;
		}
		for (int i = 0; i < 5; i++) {			
			int shamt;
			if (shiftLeft) {
				shamt = (int)DIGIT_WIDTH*digitsToRender;
			}
			else {
				shamt = -PERCENT_WIDTH;
			}
			g.drawImage(digitsImgArray[digitsValues[i]], x - (DIGIT_WIDTH)*(i+1) + shamt, y, DIGIT_WIDTH, DIGIT_HEIGHT, null);
			if (allZeroAfterThis(i, digitsValues)) {
				break;
			}
		}
		if (shiftLeft) {
			g.drawImage(digitsImgArray[10], x + (int)DIGIT_WIDTH*(digitsToRender), y+DIGIT_HEIGHT-PERCENT_HEIGHT, PERCENT_WIDTH, PERCENT_HEIGHT, null);
		}
		else {
			g.drawImage(digitsImgArray[10], x - PERCENT_WIDTH, y+DIGIT_HEIGHT-PERCENT_HEIGHT, PERCENT_WIDTH, PERCENT_HEIGHT, null);
		}
	}
}

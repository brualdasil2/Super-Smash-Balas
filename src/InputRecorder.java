import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public class InputRecorder {
	private Game game;
	private String fileName = "replays/lastReplay.pbr";
	private byte[] gameInputs;
	private int currentIndex = 0;
	private byte[] p1InputsArray;
	private byte[] p2InputsArray;
	private long randomSeed;
	private Character p1Character, p2Character;
	private int gameMap;
	
	private byte[] longToBytes(long x) {
	    ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
	    buffer.putLong(x);
	    return buffer.array();
	}

	private long bytesToLong(byte[] bytes) {
	    ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
	    buffer.put(bytes);
	    buffer.flip();//need flip 
	    return buffer.getLong();
	}
	
	public InputRecorder(Game game) {
		this.game = game;
	}
	
	public void startRecording() {
		gameInputs = new byte[1000000];
		currentIndex = 0;
		p1InputsArray = new byte[8];
		p2InputsArray = new byte[8];
	}
	
	private byte encodeCharacter(Character character) {
		byte charData = (byte)0x00;
		if (character instanceof Bruno) {
			charData = (byte)0x00;
		}
		else if (character instanceof Carol) {
			charData = (byte)0x01;
		}
		if (character instanceof Lacerda) {
			charData = (byte)0x02;
		}
		if (character instanceof Obino) {
			charData = (byte)0x03;
		}
		charData = (byte)(charData << 1);
		byte skinData = (byte)character.getSkin();
		charData |= skinData;
		return charData;
	}
	private Character decodeCharacter(byte charData) {
		Character pChar;
		int skin = (int)(charData & (byte)0x01);
		charData = (byte)(charData >> 1);
		switch(charData) {
			case 0x00:
				pChar = new Bruno(skin);
				break;
			case 0x01:
				pChar = new Carol(skin);
				break;
			case 0x02:
				pChar = new Lacerda(skin);
				break;
			case 0x03:
				pChar = new Obino(skin);
				break;
			default:
				pChar = new Bruno(skin);
		}
		return pChar;
	}
	
	public void stopRecording(Character p1Char, Character p2Char, int map) {
		File file = new File(fileName);
		file.getParentFile().mkdirs();
		try {
			file.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			FileOutputStream fis = new FileOutputStream(fileName);
			try {
				byte[] seedBytes = longToBytes(GameState.randomSeed);
				fis.write(seedBytes);
				fis.write((byte)map);
				byte p1CharData = encodeCharacter(p1Char);
				byte p2CharData = encodeCharacter(p2Char);
				fis.write(p1CharData);
				fis.write(p2CharData);
				fis.write(gameInputs, 0, 100000);
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public void startPlaying() {
		gameInputs = new byte[1000000];
		currentIndex = 0;
		try {
			FileInputStream fis = new FileInputStream(fileName);
			try {
				byte[] seedBytes = new byte[8];
				fis.read(seedBytes, 0, 8);
				randomSeed = bytesToLong(seedBytes);
				byte[] mapByte = new byte[1];
				fis.read(mapByte, 0, 1);
				gameMap = (int)(mapByte[0]);
				byte[] playerCharacterBytes = new byte[2];
				fis.read(playerCharacterBytes, 0, 2);
				p1Character = decodeCharacter(playerCharacterBytes[0]);
				p2Character = decodeCharacter(playerCharacterBytes[1]);
				fis.read(gameInputs, 0, 100000);
				//System.out.println(gameInputs[1]);
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public byte[] getFrameInputs() {
		byte p1Inputs = gameInputs[currentIndex];
		currentIndex++;
		byte p2Inputs = gameInputs[currentIndex];
		currentIndex++;
		byte[] frameInputs = {
				p1Inputs,
				p2Inputs
		};
		return frameInputs; 
	}
	
	public void recordInputs(SmashPlayer p1, SmashPlayer p2) {
		boolean p1PressingJump = p1.pressingJump;
		boolean p1PressingAttack = p1.pressingAttack;
		boolean p1PressingSpecial = p1.pressingSpecial;
		boolean p1PressingUp = p1.pressingUp;
		boolean p1PressingShield = p1.pressingShield;
		boolean p1PressingAirdash = p1.pressingAirdash;
		boolean p1PressingLeft = p1.pressingLeft;
		boolean p1PressingRight = p1.pressingRight;
		

		p1InputsArray[0] = (byte) (p1PressingJump ? 0x80 : 0x00);
		p1InputsArray[1] = (byte) (p1PressingAttack ? 0x40 : 0x00);
		p1InputsArray[2] = (byte) (p1PressingSpecial ? 0x20 : 0x00);
		p1InputsArray[3] = (byte) (p1PressingUp ? 0x10 : 0x00);
		p1InputsArray[4] = (byte) (p1PressingShield ? 0x08 : 0x00);
		p1InputsArray[5] = (byte) (p1PressingAirdash ? 0x04 : 0x00);
		p1InputsArray[6] = (byte) (p1PressingLeft ? 0x02 : 0x00);
		p1InputsArray[7] = (byte) (p1PressingRight ? 0x01 : 0x00);
		
		byte p1InputsByte = 0x00;
		for (byte b : p1InputsArray) {
			p1InputsByte |= b;
		}
		
		boolean p2PressingJump = p2.pressingJump;
		boolean p2PressingAttack = p2.pressingAttack;
		boolean p2PressingSpecial = p2.pressingSpecial;
		boolean p2PressingUp = p2.pressingUp;
		boolean p2PressingShield = p2.pressingShield;
		boolean p2PressingAirdash = p2.pressingAirdash;
		boolean p2PressingLeft = p2.pressingLeft;
		boolean p2PressingRight = p2.pressingRight;
		
		p2InputsArray[0] = (byte) (p2PressingJump ? 0x80 : 0x00);
		p2InputsArray[1] = (byte) (p2PressingAttack ? 0x40 : 0x00);
		p2InputsArray[2] = (byte) (p2PressingSpecial ? 0x20 : 0x00);
		p2InputsArray[3] = (byte) (p2PressingUp ? 0x10 : 0x00);
		p2InputsArray[4] = (byte) (p2PressingShield ? 0x08 : 0x00);
		p2InputsArray[5] = (byte) (p2PressingAirdash ? 0x04 : 0x00);
		p2InputsArray[6] = (byte) (p2PressingLeft ? 0x02 : 0x00);
		p2InputsArray[7] = (byte) (p2PressingRight ? 0x01 : 0x00);
		
		byte p2InputsByte = 0x00;
		for (byte b : p2InputsArray) {
			p2InputsByte |= b;
		}
		
		gameInputs[currentIndex] = p1InputsByte;
		currentIndex++;
		gameInputs[currentIndex] = p2InputsByte;
		currentIndex++;
		
		
	}
	
	public long getRandomSeed() {
		return randomSeed;
	}
	public Character getP1Character() {
		return p1Character;
	}
	public Character getP2Character() {
		return p2Character;
	}
	public int getGameMap() {
		return gameMap;
	}
}

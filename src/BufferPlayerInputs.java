
public class BufferPlayerInputs {
	PlayerInputs[] buffer;
	private int bufferSize;
	
	public BufferPlayerInputs(int inputDelay) {
		bufferSize = inputDelay;
		buffer = new PlayerInputs[inputDelay];
		for (int i = 0; i < inputDelay; i++) {
			buffer[i] = null;
		}
	}
	
	public PlayerInputs shiftBuffer(PlayerInputs newInputs) {
		if (bufferSize == 0) {
			return newInputs;
		}
		PlayerInputs oldInputs = buffer[0];
		for (int i = 0; i < bufferSize-1; i++) {
			buffer[i] = buffer[i+1];
		}
		buffer[bufferSize-1] = (PlayerInputs)newInputs.clone();

		return oldInputs;
	}
}

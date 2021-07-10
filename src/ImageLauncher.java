import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLauncher {

	public static BufferedImage loadImage(String path) {
		
		try {
			return ImageIO.read(ImageLauncher.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
}

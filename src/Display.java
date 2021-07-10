import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Display {
	
	private JFrame frame;
	private Canvas canvas;
	
	private String title;
	private int width, height;
	

	public Display(String title, int width, int height) {
		
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
	}
	
	private void createDisplay() {
		
		//Create frame
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/textures/Logo_Icone.png")));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setIgnoreRepaint(true);
		
		
		//Create canvas
		canvas =  new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		canvas.setIgnoreRepaint(true);

		
		frame.add(canvas);
		
		frame.pack();
		
	}
	
	
	

	
	public Canvas getCanvas() {
		return canvas;
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public int getWidth() {
		
		return width;
	}

}

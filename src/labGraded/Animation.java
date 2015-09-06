package labGraded;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/** AnimationDemo */
@SuppressWarnings("serial")
public class Animation extends JFrame {
	public Animation() {
		// Create two MovingMessagePanel for displaying two moving messages
		this.setLayout(new GridLayout(2, 1));
		add(new MovingMessagePanel("message 1 moving?"));
		add(new MovingMessagePanel("message 2 moving?"));
	}

	/** Main method */
	public static void main(String[] args) {
		Animation frame = new Animation();
		frame.setTitle("AnimationDemo");
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(280, 100);
		frame.setVisible(true);
	}

	// Inner class: Displaying a moving message
	static class MovingMessagePanel extends JPanel {
		
		private ImageIcon imageIcon1 = new ImageIcon("/imgs/silly_walks_small1.jpg"); // need to fix img references
		private Image image1 = imageIcon1.getImage();
		
		private ImageIcon imageIcon2 = new ImageIcon("/imgs/silly_walks_small2.jpg"); // need to fix img references
		private Image image2 = imageIcon2.getImage();
		
		private ImageIcon imageIcon3 = new ImageIcon("/imgs/silly_walks_small3.jpg"); // need to fix img references
		private Image image3 = imageIcon3.getImage();
		
		private ImageIcon imageIcon4 = new ImageIcon("/imgs/silly_walks_small4.jpg"); // need to fix img references
		private Image image4 = imageIcon4.getImage();
		
		private String message = "Welcome to Java";
		private int xCoordinate = 0;
		private int yCoordinate = 20;
		public int count = 25;
		public int imagesequence;
		
		private Timer timer = new Timer(1000, new TimerListener());
		public MovingMessagePanel(String message) {
			this.message = message; 

			// Start timer for animation
			timer.start();

			// Control animation speed using mouse buttons
			this.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int delay = timer.getDelay();
					if (e.getButton() == MouseEvent.BUTTON1) 
						timer.setDelay(delay > 10 ? delay - 30 : 0);
					else if (e.getButton() == MouseEvent.BUTTON3) 
						timer.setDelay(delay < 50000 ? delay + 1000 : 50000);
				}
			});
		}

		@Override /** Paint the message */
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			imagesequence++;
			if (xCoordinate > (getWidth() - image1.getWidth(null))) {
				count = -25;
			}
			else if (xCoordinate == 0) {
				count = 25;
			}
			xCoordinate += count;
			imagesequence++;
			
			if((xCoordinate % 2 == 0) && (count > 0) && (imagesequence == 1)) {
				g.drawImage(image1, xCoordinate, yCoordinate, 50, 60, this);
			}
			else if (xCoordinate % 2 != 0 && count > 0 && (imagesequence == 2)) {
				g.drawImage(image2, xCoordinate, yCoordinate, 50, 60, this);
				imagesequence = 1;	
			}
			
			else if (xCoordinate % 2 == 0 && count < 0 && (imagesequence == 1)) {
				g.drawImage(image1, xCoordinate, yCoordinate, -50, 60, this);
			}
			else if (xCoordinate % 2 != 0 && count < 0 && (imagesequence == 2)) {
				g.drawImage(image2, xCoordinate, yCoordinate, -50, 60, this);
				imagesequence = 1;
			}
		}

		class TimerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	}
}
}
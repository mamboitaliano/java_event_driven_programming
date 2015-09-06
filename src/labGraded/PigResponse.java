package labGraded;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class PigResponse extends JFrame {
	
	PigResponse() {
	
	setLayout(new GridLayout(2, 3 , 10, 10));
	JButton oink = new JButton("Oink");
	JButton oink2 = new JButton("Oink Oink");
	
	PigListenerClass myPigListenerObj = new PigListenerClass();
	oink.addActionListener(myPigListenerObj);
	oink.setActionCommand("Oink");
	
	PigListenerClass myPigListenerObj2 = new PigListenerClass();
	oink2.addActionListener(myPigListenerObj2);
	oink2.setActionCommand("Oink Oink");
	
	add(oink);
	add(oink2);
	
	}
	
	class PigListenerClass implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Snarf snarf");
			String action = e.getActionCommand();
			if (action == "Oink")
				System.out.println("Wreeeeeeee!");
			else
				System.out.println("Slaughterin' time...");
		}
	}	
	
	public static void main(String[] args) {
		PigResponse myStuff = new PigResponse();
		myStuff.setTitle("Piggy");
		myStuff.setSize(400, 200);
		myStuff.setLocationRelativeTo(null);
		myStuff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myStuff.setVisible(true);
	}
}

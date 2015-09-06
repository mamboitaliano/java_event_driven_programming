package labNotGraded;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class HandleEvent extends JFrame {
	public HandleEvent() {
		// Create two buttons
		JButton jbtOK = new JButton("OK");
		JButton jbtCancel = new JButton("Cancel");
		
		// Create a panel to hold buttons
		JPanel panel = new JPanel();
		panel.add(jbtOK);
		panel.add(jbtCancel);
		
		add(panel); // Add panel to the frame
		
		// Register listeners
		OKListenerClass listener1 = new OKListenerClass();
		CancelListenerClass listener2 = new CancelListenerClass();
		jbtOK.addActionListener(listener1);
		jbtCancel.addActionListener(listener2);
	}
	

	public static void main(String[] args) {
		JFrame frame = new HandleEvent();
		frame.setTitle("Handle Event");
		frame.setSize(200, 150);
		frame.setLocation(200, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class OKListenerClass implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Fasho");
		
		double userNumber1;
		double userNumber2;
		
		Scanner input1 = new Scanner (System.in);
		Scanner input2 = new Scanner (System.in);
		
		System.out.println("Enter a double data value as userNumber1: ");
		userNumber1 = input1.nextDouble();
		
		System.out.println("Enter a double data value as userNumber2: ");
		userNumber2 = input2.nextDouble();
		
		
		System.out.println("The product of userNumber1 multiplied by userNumber2 is: " + returnNumber(userNumber1, userNumber2));
	}
	
	public double returnNumber(double a, double b) {
		double aTimesB = a * b;
		return aTimesB;
	}
}

class CancelListenerClass implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Aborting...");
	}
}


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;

/**
 * 
 */

/**
 * @author SJHSStudent
 *
 */
public class MediumDifficulty extends JFrame implements ActionListener {

	static JLabel myLabel;
	static JButton button;
	static JButton button1;
	static JButton button2;
	static JButton button3;
	static GridLayout layout;
	static JPanel mainPanel;
	static JPanel buttonPanel;

	public MediumDifficulty() {
		super("Sports Quiz");
		if(ClassOne.selection == 2) {
			myLabel = new JLabel();
			mainPanel.add(myLabel);
			myLabel.setText("Q1: ");

			button = new JButton("A. ");
			button.setActionCommand("a");
			button.addActionListener(this);
			buttonPanel.add(button);

			button1 = new JButton("B. ");
			button1.setActionCommand("b");
			button1.addActionListener(this);
			buttonPanel.add(button1);

			button2 = new JButton("C. ");
			button2.setActionCommand("c");
			button2.addActionListener(this);
			buttonPanel.add(button2);

			button3 = new JButton("D. ");
			button3.setActionCommand("d");
			button3.addActionListener(this);
			buttonPanel.add(button3);
			
			add(buttonPanel, BorderLayout.SOUTH);

			add(mainPanel, BorderLayout.CENTER);

			setSize(getPreferredSize());
			pack();
			setVisible(true);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();// reference for JButton
		int ctr = 0;

		switch (button.getActionCommand()) {
		case "a":
			myLabel.setText("Sorry, incorrect. The correct answer was ");
			break;
		case "b":
			myLabel.setText("Sorry, incorrect. The correct answer was ");
			break;
		case "c":
			myLabel.setText("Correct!");
			ctr++;
			break;
		case "d":
			myLabel.setText("Sorry, incorrect. The correct answer was ");
			break;

		}

	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new MediumDifficulty();
	}
}

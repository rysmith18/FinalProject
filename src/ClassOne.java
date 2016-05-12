import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * 
 */

/**
 * @author SJHSStudent
 *
 */
public class ClassOne extends JFrame implements ActionListener{
	JLabel myLabel;
	static JButton button;
	static GridLayout layout;
	static  JPanel mainPanel;
	static JPanel buttonPanel;
	static int selection = 0;
	
	public ClassOne() {
		super("Sports Quiz");
		
		mainPanel = new JPanel();
		buttonPanel = new JPanel();
		
		buttonPanel.setLayout(new GridLayout(4, 4));
		
		button = new JButton("A. Easy");
		button.setActionCommand("easy");
		button.addActionListener(this);
		buttonPanel.add(button);
		
		button = new JButton("B. Medium");
		button.setActionCommand("medium");
		button.addActionListener(this);
		buttonPanel.add(button);
		
		button = new JButton("C. Hard");
		button.setActionCommand("hard");
		button.addActionListener(this);
		buttonPanel.add(button);
		
		button = new JButton("Quit");
		button.setActionCommand("quit");
		button.addActionListener(this);
		buttonPanel.add(button);
		
		add(buttonPanel, BorderLayout.SOUTH);
		
		myLabel = new JLabel("Welcome to the sports quiz! Choose your difficulty:");
		mainPanel.add(myLabel);
		
		add(mainPanel, BorderLayout.CENTER);
		
		setSize(getPreferredSize());
		pack();
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();//reference for JButton
		
		switch(button.getActionCommand()) {
		case "easy":
			selection = 1;
			break;
		case "medium":
			selection = 2;
			break;
		case "hard":
			selection = 3;
			break;
		case "quit":
			System.exit(0);
			break;
		default:
			JOptionPane.showMessageDialog(null, "Error, Program Crashed. So much 10.");
			break;
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ClassOne();
	}

	

}

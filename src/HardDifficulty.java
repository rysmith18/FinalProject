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
public class HardDifficulty extends JFrame implements ActionListener{
	JTextField answer = new JTextField();
	JLabel myLabel;
	static JButton button;
	//static JButton button1;
	//static JButton button2;
	//static JButton button3;
	static GridLayout layout;
	static  JPanel mainPanel;
	static JPanel buttonPanel;
	int ctr = 0;
	JLabel label;
	
	public HardDifficulty() {
		super("Sports Quiz");
		
		mainPanel = new JPanel();
		buttonPanel = new JPanel();
		
		mainPanel.setLayout(new GridLayout(4, 4));
		
		myLabel = new JLabel("Q1: ");
		mainPanel.add(myLabel);
		
		label = new JLabel("What MLB player broke the single-season hit record in 2004?");
		mainPanel.add(label);
		
		answer.setText("Enter answer here");
		buttonPanel.add(answer);
		
		button = new JButton("Submit Answer");
		button.setActionCommand("foo");
		button.addActionListener(this);
		buttonPanel.add(button);
		
		add(buttonPanel, BorderLayout.SOUTH);
		
		add(mainPanel, BorderLayout.CENTER);
		
		setSize(getPreferredSize());
		pack();
		setVisible(true);
		
		
			/*mainPanel.setLayout(new GridLayout(4, 4));
			
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
			setVisible(true);*/
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();// reference for JButton
		if(button.getActionCommand() == "foo") {
			if(answer.getText() == "Ichiro" || answer.getText() == "Suzuki" || answer.getText() == "Ichiro Suzuki") {
				myLabel.setText("Correct!, Q2:");
			} else {
				myLabel.setText("Nope, it was Ichiro Suzuki. Q2:");
			}
			label.setText("What NFL team lost the Super Bowl by one yard?");
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new HardDifficulty();
	}

}

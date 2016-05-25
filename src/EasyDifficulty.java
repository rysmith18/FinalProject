import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.*;

/**
 * 
 */

/**
 * @author Ryan Smith
 *
 */
public class EasyDifficulty extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	static JLabel myLabel;
	static JButton button;
	static JButton button1;
	static JButton button2;
	static JButton button3;
	static GridLayout layout;
	static JPanel mainPanel = new JPanel();
	static JPanel buttonPanel = new JPanel();
	int ctr = 0;
	int otherCtr = 0;
	static int playAgain;
	int selection = 0;
	int[] answerArray = new int[5];

	public EasyDifficulty() {
		super("Sports Quiz (Easy)");
	
		
		mainPanel.setLayout(new GridLayout(4, 4));
		
		myLabel = new JLabel();
		mainPanel.add(myLabel);
		myLabel.setText("Q1: What MLB team did famed Puerto Rican outfielder Roberto Clemente play for?");

		button = new JButton("A. Pittsburgh Steelers");
		button.setFont(new Font("TimesRoman", Font.BOLD, 24));
		button.setActionCommand("a");
		button.addActionListener(this);
		buttonPanel.add(button);

		button1 = new JButton("B. Los Angeles Dodgers");
		button1.setFont(new Font("TimesRoman", Font.BOLD, 24));
		button1.setActionCommand("b");
		button1.addActionListener(this);
		buttonPanel.add(button1);

		button2 = new JButton("C. Pittsburgh Pirates");
		button2.setFont(new Font("TimesRoman", Font.BOLD, 24));
		button2.setActionCommand("c");
		button2.addActionListener(this);
		buttonPanel.add(button2);

		button3 = new JButton("D. Montreal Royals");
		button3.setFont(new Font("TimesRoman", Font.BOLD, 24));
		button3.setActionCommand("d");
		button3.addActionListener(this);
		buttonPanel.add(button3);
		
		

		add(buttonPanel, BorderLayout.SOUTH);

		add(mainPanel, BorderLayout.CENTER);

		setSize(getPreferredSize());
		pack();
		setVisible(true);
		

		
		

	}

	public static void askQuestionOne() {
		myLabel.setText("Q1: What MLB team did famed Puerto Rican outfielder Roberto Clemente play for?");
		button.setText("A. Pittsburgh Steelers");
		button1.setText("B. Los Angeles Dodgers");
		button2.setText("C. Pittsburgh Pirates");
		button3.setText("D. Montreal Royals");
	}

	public static void askQuestionTwo() {
		myLabel.setText("Q2: Which hockey star was nicknamed \"The Great One\"?");
		button.setText("A. Wayne Gretzky");
		button1.setText("B. Mario Lemieux");
		button2.setText("C. Gordie Howe");
		button3.setText("D. Bobby Hull");
	}

	public static void askQuestionThree() {
		myLabel.setText("Q3: Which NFL team has never won a Super Bowl?");
		button.setText("A. Denver Broncos");
		button1.setText("B. Cleveland Browns");
		button2.setText("C. Baltimore Ravens");
		button3.setText("D. Seattle Seahawks");
	}

	public static void askQuestionFour() {
		myLabel.setText("Q4: In what sport are passing, dribbling, and shooting fundamental skills?");
		button.setText("A. Soccer");
		button1.setText("B. Basketball");
		button2.setText("C. Football");
		button3.setText("D. Both A and B");
	}

	public static void askQuestionFive() {
		myLabel.setText("Q5: Which NBA superstar won 6 championships with the Chigago Bulls?");
		button.setText("A. Dennis Rodman");
		button1.setText("B. Larry Bird");
		button2.setText("C. Magic Johnson");
		button3.setText("D. Michael Jordan");
	}

	public void viewResults() {
		JOptionPane.showMessageDialog(null, "You got " + ctr + " questions right!");
	}

	public void playIncorrectSound() {
		try {
			File soundFive = new File("Windows_Hardware_Remove.wav");// creating
																		// sound
																		// file
																		// reference
			AudioInputStream soundFiveStream = AudioSystem.getAudioInputStream(soundFive);// creating
																							// AudioInputStream
																							// for
																							// soundFive
			AudioFormat formatFive = soundFiveStream.getFormat();// new audio
																	// format
			DataLine.Info soundFiveInfo = new DataLine.Info(Clip.class, formatFive);
			Clip soundFiveClip = (Clip) AudioSystem.getLine(soundFiveInfo);// creates
																			// clip
																			// to
																			// be
																			// played
			// getDelay(SoundRecord.delay);
			soundFiveClip.open(soundFiveStream);// opens the clip
			soundFiveClip.start();// plays the clip
			// buttonList.add("five");
		} catch (Exception e5) {
			System.out.println(e5);
		}
	}

	public void playCorrectSound() {
		try {
			File dingSound = new File("ding.wav");// creating sound file
													// reference
			AudioInputStream ding = AudioSystem.getAudioInputStream(dingSound);// creating
																				// AudioInputStream
																				// for
																				// sound
																				// ding
			AudioFormat formatOne = ding.getFormat();// new audio format
			DataLine.Info dingInfo = new DataLine.Info(Clip.class, formatOne);
			Clip dingClip = (Clip) AudioSystem.getLine(dingInfo);// creates clip
																	// to be
																	// played
			// getDelay(SoundRecord.delay);
			dingClip.open(ding);// opens the clip
			dingClip.start();// plays the clip
			// buttonList.add("one");
		} catch (Exception e1) {
			System.out.println(e1);
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		//JButton button = (JButton) e.getSource();// reference for JButton
		
		e.getActionCommand();
	}
	
	
	public void answerQuestionOne(ActionEvent e) {
		if(e.getActionCommand() == "a" || e.getActionCommand() == "b" || e.getActionCommand() == "d") {
			playIncorrectSound();
			JOptionPane.showMessageDialog(null, "Wrong! It was Roberto Clemente.");
		} else if(e.getActionCommand() == "c") {
			ctr++;
			playCorrectSound();
			JOptionPane.showMessageDialog(null, "Right!");
		}
	selection = 0;
	}
	
	public void answerQuestionTwo(ActionEvent e1) {
		if(e1.getActionCommand() == "b" || e1.getActionCommand() == "c" || e1.getActionCommand() == "d") {
			playIncorrectSound();
			JOptionPane.showMessageDialog(null, "Wrong! It was Wayne Gretzky.");
		} else if(e1.getActionCommand() == "a") {
			ctr++;
			playCorrectSound();
			JOptionPane.showMessageDialog(null, "Right!");
		}
	selection = 0;
	}
	
	public void answerQuestionThree(ActionEvent e2) {
		if(e2.getActionCommand() == "a" || e2.getActionCommand() == "c" || e2.getActionCommand() == "d") {
			playIncorrectSound();
			JOptionPane.showMessageDialog(null, "Wrong! It was the Cleveland Browns.");
		} else if(e2.getActionCommand() == "b") {
			ctr++;
			playCorrectSound();
			JOptionPane.showMessageDialog(null, "Right!");
		}
	selection = 0;
	}
	
	public void answerQuestionFour(ActionEvent e3) {
		if(e3.getActionCommand() == "a" || e3.getActionCommand() == "b" || e3.getActionCommand() == "c") {
			playIncorrectSound();
			JOptionPane.showMessageDialog(null, "Wrong! It was both Basketball and Soccer.");
		} else if(e3.getActionCommand() == "d") {
			ctr++;
			playCorrectSound();
			JOptionPane.showMessageDialog(null, "Right!");
		}
	selection = 0;
	}
	
	public void answerQuestionFive(ActionEvent e4) {
		if(e4.getActionCommand() == "a" || e4.getActionCommand() == "b" || e4.getActionCommand() == "c") {
			playIncorrectSound();
			JOptionPane.showMessageDialog(null, "Wrong! It was Michael Jordan.");
			viewResults();
		} else if(e4.getActionCommand() == "d") {
			ctr++;
			playCorrectSound();
			JOptionPane.showMessageDialog(null, "Right!");
			viewResults();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new EasyDifficulty();
		do {
			askQuestionOne();
			playAgain = JOptionPane.showConfirmDialog(null,"Want to play again?" , "Play Again?", JOptionPane.YES_NO_OPTION);
		} while(playAgain == JOptionPane.YES_OPTION);
		if(playAgain == JOptionPane.NO_OPTION) {
			System.exit(0);
		}
	}

}


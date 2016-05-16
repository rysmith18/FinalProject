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
 * @author SJHSStudent
 *
 */
public class EasyDifficulty extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JLabel myLabel;
	static JButton button;
	static JButton button1;
	static JButton button2;
	static JButton button3;
	static GridLayout layout;
	static JPanel mainPanel = new JPanel();
	static JPanel buttonPanel = new JPanel();
	int ctr = 0;
	//File questions = new File("Questions.txt");
	int selection = 0;

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

	public void askQuestionOne() {
		myLabel.setText("Q1: What MLB team did famed Puerto Rican outfielder Roberto Clemente play for?");
		button.setText("A. Pittsburgh Steelers");
		button1.setText("B. Los Angeles Dodgers");
		button2.setText("C. Pittsburgh Pirates");
		button3.setText("D. Montreal Royals");
	}

	public void askQuestionTwo() {
		myLabel.setText("Q2: Which hockey star was nicknamed \"The Great One\"?");
		button.setText("A. Wayne Gretzky");
		button1.setText("B. Mario Lemieux");
		button2.setText("C. Gordie Howe");
		button3.setText("D. Bobby Hull");
	}

	public void askQuestionThree() {
		myLabel.setText("Q3: Which NFL team has never won a Super Bowl?");
		button.setText("A. Denver Broncos");
		button1.setText("B. Cleveland Browns");
		button2.setText("C. Baltimore Ravens");
		button3.setText("D. Seattle Seahawks");
	}

	public void askQuestionFour() {
		myLabel.setText("Q4: In what sport are passing, dribbling, and shooting fundamental skills?");
		button.setText("A. Soccer");
		button1.setText("B. Basketball");
		button2.setText("C. Football");
		button3.setText("D. Both A and B");
	}

	public void askQuestionFive() {
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

		askQuestionOne();
		if (e.getActionCommand() == "a" || e.getActionCommand() == "b" || e.getActionCommand() == "d") {
			selection = 1;
			answerQuestionOne();
			//playIncorrectSound();
			//JOptionPane.showMessageDialog(null, "Wrong! It was Roberto Clemente.");
		} else if (e.getActionCommand() == "c") {
			selection = 2;
			//ctr++;
			//playCorrectSound();
			//JOptionPane.showMessageDialog(null, "Right!");
		}
		
		
		
		askQuestionTwo();
		if (e.getActionCommand() == "b" || e.getActionCommand() == "c" || e.getActionCommand() == "d") {
			selection = 1;
			answerQuestionTwo();
			//playIncorrectSound();
			//JOptionPane.showMessageDialog(null, "Wrong! It was Wayne Gretzky.");
		} else if (e.getActionCommand() == "a") {
			selection = 2;
			answerQuestionTwo();
			//ctr++;
			//playCorrectSound();
			//JOptionPane.showMessageDialog(null, "Right!");
		}
		//JOptionPane.showConfirmDialog(null, "Continue?");
		
		askQuestionThree();
		if (e.getActionCommand() == "a" || e.getActionCommand() == "c" || e.getActionCommand() == "d") {
			selection = 1;
			answerQuestionThree();
			//playIncorrectSound();
			//JOptionPane.showMessageDialog(null, "Wrong! It was the Cleveland Browns.");
		} else if (e.getActionCommand() == "b") {
			selection = 2;
			answerQuestionThree();
			//ctr++;
			//playCorrectSound();
			//JOptionPane.showMessageDialog(null, "Right!");
		}
		//JOptionPane.showConfirmDialog(null, "Continue?");
		
		askQuestionFour();
		if (e.getActionCommand() == "a" || e.getActionCommand() == "b" || e.getActionCommand() == "c") {
			selection = 1;
			answerQuestionFour();
			//playIncorrectSound();
			//JOptionPane.showMessageDialog(null, "Wrong! It was both Basketball and Soccer.");
		} else if (e.getActionCommand() == "d") {
			selection = 2;
			answerQuestionFour();
			//ctr++;
			//playCorrectSound();
			//JOptionPane.showMessageDialog(null, "Right!");
		}
		//JOptionPane.showConfirmDialog(null, "Continue?");
		
		askQuestionFive();
		if (e.getActionCommand() == "a" || e.getActionCommand() == "b" || e.getActionCommand() == "c") {
			selection = 1;
			answerQuestionFive();
			//playIncorrectSound();
			//JOptionPane.showMessageDialog(null, "Wrong! It was Michael Jordan.");
			//viewResults();
		} else if (e.getActionCommand() == "d") {
			selection = 2;
			answerQuestionFive();
			//ctr++;
			//playCorrectSound();
			//JOptionPane.showMessageDialog(null, "Right!");
			//viewResults();
		}
		
		

		/*
		 * switch(button.getActionCommand()) { case "a": myLabel.setText(
		 * "Sorry, incorrect. The correct answer was "); this.button.setText(
		 * "Next question"); button1.setText(""); button2.setText("");
		 * button3.setText("End quiz"); if(button.getActionCommand() == "a")
		 * {//Q2 myLabel.setText("Q2: "); this.button.setText("A. ");
		 * button1.setText("B. "); button2.setText("C. "); button3.setText("D. "
		 * ); if(button.getActionCommand() == "a") {
		 * myLabel.setText("Correct!"); ctr++; this.button.setText(
		 * "Next Question"); button1.setText(""); button2.setText("");
		 * button3.setText("End quiz"); if(button.getActionCommand() == "a")
		 * {//Q3 myLabel.setText("Q3: "); this.button.setText("A. ");
		 * button1.setText("B. "); button2.setText("C. "); button3.setText("D. "
		 * ); if(button.getActionCommand() == "b") {
		 * myLabel.setText("Correct!"); ctr++; this.button.setText(
		 * "Next question"); button1.setText(""); button2.setText("");
		 * button3.setText("End quiz"); if(button.getActionCommand() == "a")
		 * {//Q4 myLabel.setText("Q4: "); this.button.setText("A. ");
		 * button1.setText("B. "); button2.setText("C. "); button3.setText("D. "
		 * ); if(button.getActionCommand() == "d") {
		 * myLabel.setText("Correct!"); ctr++; this.button.setText(
		 * "Next question"); button1.setText(""); button2.setText("");
		 * button3.setText(""); if(button.getActionCommand() == "a") {//Q5
		 * myLabel.setText("Q5: "); this.button.setText("A. "); button1.setText(
		 * "B. "); button2.setText("C. "); button3.setText("D. ");
		 * if(button.getActionCommand() == "d") { ctr++; myLabel.setText(
		 * "Correct! You got " + ctr + " questions right!"); } else
		 * if(button.getActionCommand() == "a" || button.getActionCommand() ==
		 * "b" || button.getActionCommand() == "c") { myLabel.setText(
		 * "Sorry, incorrect.  The correct answer was You got " + ctr +
		 * " questions right!"); } } else if(button.getActionCommand() == "d") {
		 * myLabel.setText("You got " + ctr + " questions right!");
		 * 
		 * } } else if(button.getActionCommand() == "a" ||
		 * button.getActionCommand() == "b" || button.getActionCommand() == "c")
		 * { myLabel.setText("Sorry, incorrect. The correct answer was ");
		 * this.button.setText("Next Question"); button1.setText("");
		 * button2.setText(""); button3.setText("End quiz");
		 * if(button.getActionCommand() == "a") { myLabel.setText("Q5: ");
		 * this.button.setText("A. "); button1.setText("B. "); button2.setText(
		 * "C. "); button3.setText("D. "); if(button.getActionCommand() == "d")
		 * { ctr++; myLabel.setText("Correct! You got " + ctr +
		 * " questions right!"); } else if(button.getActionCommand() == "a" ||
		 * button.getActionCommand() == "b" || button.getActionCommand() == "c")
		 * { myLabel.setText(
		 * "Sorry, incorrect.  The correct answer was You got " + ctr +
		 * " questions right!"); } } else if(button.getActionCommand() == "d") {
		 * myLabel.setText("You got " + ctr + " questions right!");
		 * 
		 * } }
		 * 
		 * } else if(button.getActionCommand() == "d") { myLabel.setText(
		 * "You got " + ctr + " questions right!"); } } else
		 * if(button.getActionCommand() == "a" || button.getActionCommand() ==
		 * "c" || button.getActionCommand() == "d") { //Q3 myLabel.setText(
		 * "Sorry, incorrect. The correct answer was "); this.button.setText(
		 * "Next Question"); button1.setText(""); button2.setText("");
		 * button3.setText("End quiz");
		 * 
		 * } } else if(button.getActionCommand() == "d") { myLabel.setText(
		 * "You got " + ctr + " questions right!"); } } else
		 * if(button.getActionCommand() == "b" || button.getActionCommand() ==
		 * "c" || button.getActionCommand() == "d") { //Q2 myLabel.setText(
		 * "Sorry, incorrect. The correct answer was "); this.button.setText(
		 * "Next Question"); button1.setText(""); button2.setText("");
		 * button3.setText("End quiz");
		 * 
		 * }
		 * 
		 * } else if(button.getActionCommand() == "d") { myLabel.setText(
		 * "You got " + ctr + " questions right!"); } break; case "b":
		 * myLabel.setText("Sorry, incorrect. The correct answer was "); break;
		 * case "c": myLabel.setText("Correct!"); ctr++; break; case "d":
		 * myLabel.setText("Sorry, incorrect. The correct answer was "); break;
		 * }
		 */

	}
	
	public void answerQuestionOne() {
		if(selection == 1) {
			playIncorrectSound();
			JOptionPane.showMessageDialog(null, "Wrong! It was Roberto Clemente.");
		} else if(selection == 2) {
			ctr++;
			playCorrectSound();
			JOptionPane.showMessageDialog(null, "Right!");
		}
	}
	
	public void answerQuestionTwo() {
		if(selection == 1) {
			playIncorrectSound();
			JOptionPane.showMessageDialog(null, "Wrong! It was Wayne Gretzky.");
		} else if(selection == 2) {
			ctr++;
			playCorrectSound();
			JOptionPane.showMessageDialog(null, "Right!");
		}
	selection = 0;
	}
	
	public void answerQuestionThree() {
		if(selection == 1) {
			playIncorrectSound();
			JOptionPane.showMessageDialog(null, "Wrong! It was the Cleveland Browns.");
		} else if(selection == 2) {
			ctr++;
			playCorrectSound();
			JOptionPane.showMessageDialog(null, "Right!");
		}
	selection = 0;
	}
	
	public void answerQuestionFour() {
		if(selection == 1) {
			playIncorrectSound();
			JOptionPane.showMessageDialog(null, "Wrong! It was both Basketball and Soccer.");
		} else if(selection == 2) {
			ctr++;
			playCorrectSound();
			JOptionPane.showMessageDialog(null, "Right!");
		}
	selection = 0;
	}
	
	public void answerQuestionFive() {
		if(selection == 1) {
			playIncorrectSound();
			JOptionPane.showMessageDialog(null, "Wrong! It was Michael Jordan.");
			viewResults();
		} else if(selection == 2) {
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
	}

}

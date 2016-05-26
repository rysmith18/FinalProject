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
	static int c = 0;
	static int ctr = 0;
	int otherCtr = 0;
	static int medium;
	static int hard;
	int selection = 0;
	static String answer;
	static String[] answerArray = new String[5];
	static String[] actualAnswers = { "c", "a", "b", "d", "d" };
	static String[] mediumAnswerArray = new String[5];
	static String[] mediumActualAnswers = {"b", "d", "a", "b", "d"};
	static String[] hardAnswerArray = new String[5];
	static String[] hardActualAnswers = {"c", "d", "c", "a", "d"};

	public EasyDifficulty() {
		super("Sports Quiz");

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
		myLabel.setText(
				"Q1: What MLB team did famed Puerto Rican outfielder Roberto Clemente play for?  You have 15 seconds for each question.");
		button.setText("A. Pittsburgh Steelers");
		button1.setText("B. Los Angeles Dodgers");
		button2.setText("C. Pittsburgh Pirates");//Correct answer
		button3.setText("D. Montreal Royals");
	}

	public static void askQuestionTwo() {
		myLabel.setText("Q2: Which hockey star was nicknamed \"The Great One\"?");
		button.setText("A. Wayne Gretzky");//Correct answer
		button1.setText("B. Mario Lemieux");
		button2.setText("C. Gordie Howe");
		button3.setText("D. Bobby Hull");
	}

	public static void askQuestionThree() {
		myLabel.setText("Q3: Which NFL team has never won a Super Bowl?");
		button.setText("A. Denver Broncos");
		button1.setText("B. Cleveland Browns");//Correct answer
		button2.setText("C. Baltimore Ravens");
		button3.setText("D. Seattle Seahawks");
	}

	public static void askQuestionFour() {
		myLabel.setText("Q4: In what sport are passing, dribbling, and shooting fundamental skills?");
		button.setText("A. Soccer");
		button1.setText("B. Basketball");
		button2.setText("C. Football");
		button3.setText("D. Both A and B");//Correct answer
	}

	public static void askQuestionFive() {
		myLabel.setText("Q5: Which NBA superstar won 6 championships with the Chigago Bulls?");
		button.setText("A. Dennis Rodman");
		button1.setText("B. Larry Bird");
		button2.setText("C. Magic Johnson");
		button3.setText("D. Michael Jordan");//Correct answer
	}

	public static void viewResults() {
		myLabel.setText("Answer key: 1: Roberto Clemente, 2: Wayne Gretzky, 3: Cleveland Browns, 4: Both Basketball and Soccer, 5: Michael Jordan");
		JOptionPane.showMessageDialog(null, "You got " + ctr + " questions right!");
	}
	
	public static void askQuestionSix() {
		myLabel.setText("Q1: Who won the Green Jacket in 2016? You have ten seconds for each question.");
		button.setText("A. Jason Day");
		button1.setText("B. Danny Willett");//Correct answer
		button2.setText("C. Jordan Spieth");
		button3.setText("D. Tiger Woods");
	}
	
	public static void askQuestionSeven() {
		myLabel.setText("Q2: Which NBA team set an NBA record with 73 wins in 2015-16");
		button.setText("A. Chicago Bulls");
		button1.setText("B. Seattle SuperSonics");
		button2.setText("C. Boston Celtics");
		button3.setText("D. Golden State Warriors");//Correct answer
	}
	
	public static void askQuestionEight() {
		myLabel.setText("Q3: Which player from the answer to the previous question won the MVP award during the same season?");
		button.setText("A. Steph Curry");//Correct answer
		button1.setText("B. Isaiah Thomas");
		button2.setText("C. Derrick Rose");
		button3.setText("D. Klay Thompson");
	}
	
	public static void askQuestionNine() {
		myLabel.setText("Q4: Prior to their NLDS run in 2013, how many consecutive losing seasons did the Pittsburgh Pirates have?");
		button.setText("A. 21");
		button1.setText("B. 20");//Correct answer
		button2.setText("C. 18");
		button3.setText("D. 0");
	}
	
	public static void askQuestionTen() {
		myLabel.setText("Q5: Name the only year in which an NFL team went undefeated and won the Super Bowl, and name the team that achieved the feat.");
		button.setText("A. 2007 New England Patriots");
		button1.setText("B. 2004 Pittsburgh Steelers");
		button2.setText("C. 2015 Cleveland Browns");
		button3.setText("D. 1972 Miami Dolphins");//Correct answer
	}
	
	public static void viewMediumResults() {
		myLabel.setText("Answer key: 1: Danny Willett, 2: Golden State Warriors, 3: Steph Curry, 4: 20, 5: 1972 Miami Dolphins");
		JOptionPane.showMessageDialog(null, "You got " + ctr + " questions right!");
	}
	
	public static void askQuestionEleven() {
		myLabel.setText("Q1: Pete Rose holds the all-time MLB hits record. How many hits did he have in his career?  5 seconds for each question.");
		button.setText("A. 4191");
		button1.setText("B. 5000");
		button2.setText("C. 4256");//Correct answer
		button3.setText("D. 2162");
	}
	
	public static void askQuestionTwelve() {
		myLabel.setText("Q2: It started out as a desperation pass from Terry Bradshaw to \"Frenchy\" Fuqua, but it eventually became what famous football play?");
		button.setText("A. The Catch");
		button1.setText("B. Red Right 88");
		button2.setText("C. The Holy Roller");
		button3.setText("D. The Immaculate Reception");//Correct answer
	}
	
	public static void askQuestionThirteen() {
		myLabel.setText("Q3: The player last picked in the annual NHL All Star fantasy draft wins...");
		button.setText("A. ...the Stanley Cup!");
		button1.setText("B. ...free mortgage!");
		button2.setText("C. ...a brand new car!");//Correct answer
		button3.setText("D. ...all my money!");
	}
	
	public static void askQuestionFourteen() {
		myLabel.setText("Q4: In cricket, how many runs are scored when a player hits the ball past the boundary on the fly?");
		button.setText("A. Six");//Correct answer
		button1.setText("B. Four");
		button2.setText("C. One");
		button3.setText("D. Ten");
	}
	
	public static void askQuestionFifteen() {
		myLabel.setText("Q5: On a scale of 1-100, how much of a sports genius are you?");
		button.setText("A. 100!");
		button1.setText("B. 90");
		button2.setText("C. 95");
		button3.setText("D. 50");//Correct answer
	}
	
	public static void viewHardResults() {
		myLabel.setText("Answer key: 1: 4256, 2: The Immaculate Reception, 3: ...a brand new car!, 4: Six, 5: Learn to stay humble once in a while! 50");
		JOptionPane.showMessageDialog(null, "You got " + ctr + " questions right!");
	}

	public static void playIncorrectSound() {
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

	public static void playCorrectSound() {
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
		// JButton button = (JButton) e.getSource();// reference for JButton

		answer = e.getActionCommand();

	}

	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new EasyDifficulty();
		while (c < 5) {
			askQuestionOne();
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			answerArray[0] = answer;
			if (answerArray[0] == actualAnswers[0]) {
				playCorrectSound();
				ctr++;
				JOptionPane.showMessageDialog(null, "Right!");
				c++;
			} else {
				playIncorrectSound();
				JOptionPane.showMessageDialog(null, "Wrong!");
				c++;
			}

			askQuestionTwo();
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			answerArray[1] = answer;
			if (answerArray[1] == actualAnswers[1]) {
				playCorrectSound();
				ctr++;
				JOptionPane.showMessageDialog(null, "Right!");
				c++;
			} else {
				playIncorrectSound();
				JOptionPane.showMessageDialog(null, "Wrong!");
				c++;
			}

			askQuestionThree();
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			answerArray[2] = answer;
			if (answerArray[2] == actualAnswers[2]) {
				playCorrectSound();
				ctr++;
				JOptionPane.showMessageDialog(null, "Right!");
				c++;
			} else {
				playIncorrectSound();
				JOptionPane.showMessageDialog(null, "Wrong!");
				c++;
			}

			askQuestionFour();
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			answerArray[3] = answer;
			if (answerArray[3] == actualAnswers[3]) {
				playCorrectSound();
				ctr++;
				JOptionPane.showMessageDialog(null, "Right!");
				c++;
			} else {
				playIncorrectSound();
				JOptionPane.showMessageDialog(null, "Wrong!");
				c++;
			}

			askQuestionFive();
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			answerArray[4] = answer;
			if (answerArray[4] == actualAnswers[4]) {
				playCorrectSound();
				ctr++;
				JOptionPane.showMessageDialog(null, "Right!");
				c++;
				viewResults();
			} else {
				playIncorrectSound();
				JOptionPane.showMessageDialog(null, "Wrong!");
				c++;
				viewResults();
			}
			if(ctr == 5) {
				medium = JOptionPane.showConfirmDialog(null, "You got them all right! Want to try harder questions?", "Want a challenge?", JOptionPane.YES_NO_OPTION);
				if(medium == JOptionPane.YES_OPTION) {
					ctr = 0;
					askQuestionSix();
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					mediumAnswerArray[0] = answer;
					if(mediumAnswerArray[0] == mediumActualAnswers[0]) {
						playCorrectSound();
						ctr++;
						JOptionPane.showMessageDialog(null, "Right!");
						c++;
					} else {
						playIncorrectSound();
						JOptionPane.showMessageDialog(null, "Wrong!");
						c++;
					}
					askQuestionSeven();
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					mediumAnswerArray[1] = answer;
					if(mediumAnswerArray[1] == mediumActualAnswers[1]) {
						playCorrectSound();
						ctr++;
						JOptionPane.showMessageDialog(null, "Right!");
						c++;
					} else {
						playIncorrectSound();
						JOptionPane.showMessageDialog(null, "Wrong!");
						c++;
					}
					askQuestionEight();
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					mediumAnswerArray[2] = answer;
					if(mediumAnswerArray[2] == mediumActualAnswers[2]) {
						playCorrectSound();
						ctr++;
						JOptionPane.showMessageDialog(null, "Right!");
						c++;
					} else {
						playIncorrectSound();
						JOptionPane.showMessageDialog(null, "Wrong!");
						c++;
					}
					askQuestionNine();
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					mediumAnswerArray[3] = answer;
					if(mediumAnswerArray[3] == mediumActualAnswers[3]) {
						playCorrectSound();
						ctr++;
						JOptionPane.showMessageDialog(null, "Right!");
						c++;
					} else {
						playIncorrectSound();
						JOptionPane.showMessageDialog(null, "Wrong!");
						c++;
					}
					askQuestionTen();
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					mediumAnswerArray[4] = answer;
					if(mediumAnswerArray[4] == mediumActualAnswers[4]) {
						playCorrectSound();
						ctr++;
						JOptionPane.showMessageDialog(null, "Right!");
						c++;
						viewMediumResults();
					} else {
						playIncorrectSound();
						JOptionPane.showMessageDialog(null, "Wrong!");
						c++;
						viewMediumResults();
					}
					if(ctr == 5) {
						hard = JOptionPane.showConfirmDialog(null, "You got them all right! Want to try the TERRIBLY HARD QUESTIONS?", "WARNING: HARD QUESTIONS AHEAD", JOptionPane.YES_NO_OPTION);
						if(hard == JOptionPane.YES_OPTION) {
							ctr = 0;
							askQuestionEleven();
							try {
								Thread.sleep(5000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							hardAnswerArray[0] = answer;
							if(hardAnswerArray[0] == hardActualAnswers[0]) {
								playCorrectSound();
								ctr++;
								JOptionPane.showMessageDialog(null, "Right!");
								c++;
							} else {
								playIncorrectSound();
								JOptionPane.showMessageDialog(null, "Wrong!");
								c++;
							}
							askQuestionTwelve();
							try {
								Thread.sleep(5000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							hardAnswerArray[1] = answer;
							if(hardAnswerArray[1] == hardActualAnswers[1]) {
								playCorrectSound();
								ctr++;
								JOptionPane.showMessageDialog(null, "Right!");
								c++;
							} else {
								playIncorrectSound();
								JOptionPane.showMessageDialog(null, "Wrong!");
								c++;
							}
							askQuestionThirteen();
							try {
								Thread.sleep(5000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							hardAnswerArray[2] = answer;
							if(hardAnswerArray[2] == hardActualAnswers[2]) {
								playCorrectSound();
								ctr++;
								JOptionPane.showMessageDialog(null, "Right!");
								c++;
							} else {
								playIncorrectSound();
								JOptionPane.showMessageDialog(null, "Wrong!");
								c++;
							}
							askQuestionFourteen();
							try {
								Thread.sleep(5000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							hardAnswerArray[3] = answer;
							if(hardAnswerArray[3] == hardActualAnswers[3]) {
								playCorrectSound();
								ctr++;
								JOptionPane.showMessageDialog(null, "Right!");
								c++;
							} else {
								playIncorrectSound();
								JOptionPane.showMessageDialog(null, "Wrong!");
								c++;
							}
							askQuestionFifteen();
							try {
								Thread.sleep(5000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							hardAnswerArray[4] = answer;
							if(hardAnswerArray[4] == hardActualAnswers[4]) {
								playCorrectSound();
								ctr++;
								JOptionPane.showMessageDialog(null, "Right!");
								c++;
								viewHardResults();
							} else {
								playIncorrectSound();
								JOptionPane.showMessageDialog(null, "Wrong!");
								c++;
								viewHardResults();
							}
							if(ctr == 5) {
								JOptionPane.showMessageDialog(null, "Way to stay humble. You're a sports genius!");
							}
						}
					}
				}
			}
		} 

	}

}

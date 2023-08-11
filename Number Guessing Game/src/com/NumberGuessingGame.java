package com;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGuessingGame {
	private JButton guessButton;
	private JPanel mypanel;
	private JLabel image;

	public NumberGuessingGame() {
		guessButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				int computerNumber = (int) (Math.random()*100 + 1);
				int userAnswer = 0;
				int count = 1;

				while (userAnswer != computerNumber)
				{
					String response = JOptionPane.showInputDialog(null,
							"Enter a guess between 1 and 100", "Guessing Game", 3);
					userAnswer = Integer.parseInt(response);
					JOptionPane.showMessageDialog(null, ""+ determineGuess(userAnswer, computerNumber, count));
					count++;
				}
			}

			public String determineGuess(int userAnswer, int computerNumber, int count){
				if (userAnswer <=0 || userAnswer >100) {
					return "Your guess is invalid";
				}
				else if (userAnswer == computerNumber ){
					return "Correct!\nTotal Guesses: " + count;
				}
				else if (userAnswer > computerNumber) {
					return "Your guess is too high, try again.\nTry Number: " + count;
				}
				else if (userAnswer < computerNumber) {
					return "Your guess is too low, try again.\nTry Number: " + count;
				}
				else {
					return "Your guess is incorrect\nTry Number: " + count;
				}
			}
		});
	}

	public static void main(String[] args) {

		JFrame frame=new JFrame("GuessingGame");
		frame.setContentPane(new NumberGuessingGame().mypanel);
		frame.setSize(620,490);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);


	}
}

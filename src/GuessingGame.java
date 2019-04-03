import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessingGame extends JFrame {
	private JTextField textGuess;
	private JLabel lblOutput;
	private int theNumber;
	public void checkGuess() {
		String guessText = textGuess.getText();
		String message = "";
		int guess = Integer.parseInt(guessText);
	
		if (guess < theNumber) 
			message = guess + " is too low. Try again.";
		else if (guess > theNumber)  
				message = guess + " is too high. Try again.";
		else  
			message = guess + " is correct. You win!";
		lblOutput.setText(message);
		textGuess.requestFocus();
		textGuess.selectAll();
		
	}
	
	public void newGame() {
		theNumber = (int)(Math.random() * 100 + 1);
		
	}
		
	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Daniel HiLo Guessing Game");
		getContentPane().setLayout(null);
		
		JLabel lblDanielHiloGuessing = new JLabel("Daniel Hi-Lo Guessing Game");
		lblDanielHiloGuessing.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDanielHiloGuessing.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanielHiloGuessing.setBounds(0, 22, 432, 29);
		getContentPane().add(lblDanielHiloGuessing);
		
		JLabel lblGuessANumber = new JLabel("Guess a number between -100 and 200");
		lblGuessANumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGuessANumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGuessANumber.setBounds(12, 73, 269, 16);
		getContentPane().add(lblGuessANumber);
		
		textGuess = new JTextField();
		textGuess.setBounds(294, 73, 89, 18);
		getContentPane().add(textGuess);
		textGuess.setColumns(10);
		
		JButton btnGuess = new JButton("GUESS");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnGuess.setBounds(167, 151, 97, 25);
		getContentPane().add(btnGuess);
		
		lblOutput = new JLabel("Enter a number above and click Guess!");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOutput.setBounds(0, 198, 432, 29);
		getContentPane().add(lblOutput);
	}

	public static void main(String[] args) {
		
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450,300));
		theGame.setVisible(true);
	}
}

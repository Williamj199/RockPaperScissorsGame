import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RockPaperScissors extends JFrame {
    private JButton rockButton, paperButton, scissorsButton; // Buttons for user to choose rock, paper, or scissors
    private JLabel resultLabel, statsLabel; // Labels to display game result and statistics
    private int userWins, computerWins, draws; // Variables to track number of wins, losses, and draws

    public RockPaperScissors() {
        // Set up JFrame
        setTitle("Rock Paper Scissors Game"); // Set window title
        setSize(300, 200); // Set window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set close operation
        setLayout(new GridLayout(4, 1)); // Set layout to grid with 4 rows and 1 column

        // Initialize components
        rockButton = new JButton("Rock"); // Create Rock button
        paperButton = new JButton("Paper"); // Create Paper button
        scissorsButton = new JButton("Scissors"); // Create Scissors button
        resultLabel = new JLabel(" "); // Create label for displaying game result
        statsLabel = new JLabel("Wins: 0 | Losses: 0 | Draws: 0"); // Create label for displaying game statistics

        // Add action listeners
        rockButton.addActionListener(new ButtonListener()); // Add action listener to Rock button
        paperButton.addActionListener(new ButtonListener()); // Add action listener to Paper button
        scissorsButton.addActionListener(new ButtonListener()); // Add action listener to Scissors button

        // Add components to the JFrame
        add(rockButton); // Add Rock button
        add(paperButton); // Add Paper button
        add(scissorsButton); // Add Scissors button
        add(resultLabel); // Add result label
        add(statsLabel); // Add statistics label

        // Initialize stats
        userWins = 0; // Set initial user wins to 0
        computerWins = 0; // Set initial computer wins to 0
        draws = 0; // Set initial draws to 0
    }

    // ActionListener for button clicks
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get user selection
            String userChoice = e.getActionCommand(); // Get the label of the button clicked

            // Generate computer selection
            String[] choices = {"Rock", "Paper", "Scissors"}; // Define array of choices
            Random random = new Random(); // Create Random object
            String computerChoice = choices[random.nextInt(choices.length)]; // Select random choice for computer

            // Determine winner
            String result = determineWinner(userChoice, computerChoice); // Determine winner based on user and computer choices

            // Update stats and display result
            updateStats(result); // Update statistics based on result
            JOptionPane.showMessageDialog(null, result); // Display result in popup window
        }
    }

    // Method to determine the winner
    private String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) { // If user and computer choices are the same
            draws++; // Increment draws
            return "Draw! Both chose " + userChoice + "."; // Return draw message
        } else if ((userChoice.equals("Rock") && computerChoice.equals("Scissors")) || // If user wins
                   (userChoice.equals("Paper") && computerChoice.equals("Rock")) ||
                   (userChoice.equals("Scissors") && computerChoice.equals("Paper"))) {
            userWins++; // Increment user wins
            return "You win! " + userChoice + " beats " + computerChoice + "."; // Return user win message
        } else { // If computer wins
            computerWins++; // Increment computer wins
            return "Computer wins! " + computerChoice + " beats " + userChoice + "."; // Return computer win message
        }
    }

    // Method to update and display stats
    private void updateStats(String result) {
        statsLabel.setText("Wins: " + userWins + " | Losses: " + computerWins + " | Draws: " + draws); // Update statistics label
    }

    // Main method to start the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RockPaperScissors game = new RockPaperScissors(); // Create instance of game
            game.setVisible(true); // Make the game window visible
        });
    }
}


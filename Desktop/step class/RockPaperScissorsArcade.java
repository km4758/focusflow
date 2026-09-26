import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsArcade {

    // Required method signature from the task
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        
        // Determine player win conditions
        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }
        
        // If it's not a draw and the player didn't win, the computer wins
        return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int n = 5; // Number of rounds
        String[] options = {"Rock", "Paper", "Scissors"};
        
        // Arrays to store round history for the summary table
        String[] playerMoves = new String[n];
        String[] computerMoves = new String[n];
        String[] results = new String[n];
        
        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println("Welcome to The College Coding Arcade!");
        System.out.println("Get ready for " + n + " rounds of Rock-Paper-Scissors against the computer.\n");

        // Game Loop
        for (int i = 0; i < n; i++) {
            System.out.print("Round " + (i + 1) + " - Enter Rock, Paper, or Scissors: ");
            String pMove = scanner.nextLine().trim();
            
            // Basic input validation
            while (!pMove.equalsIgnoreCase("Rock") && 
                   !pMove.equalsIgnoreCase("Paper") && 
                   !pMove.equalsIgnoreCase("Scissors")) {
                System.out.print("Invalid move! Please enter Rock, Paper, or Scissors: ");
                pMove = scanner.nextLine().trim();
            }
            
            // Format to ensure capital first letter for the table
            pMove = pMove.substring(0, 1).toUpperCase() + pMove.substring(1).toLowerCase();
            
            // Generate computer move
            String cMove = options[random.nextInt(3)];
            
            // Determine result
            String roundResult = playRound(pMove, cMove);
            
            System.out.println("Computer chose: " + cMove);
            System.out.println("Result: " + roundResult + "\n");
            
            // Record data
            playerMoves[i] = pMove;
            computerMoves[i] = cMove;
            results[i] = roundResult;
            
            // Update stats
            if (roundResult.equals("Player Wins")) {
                wins++;
            } else if (roundResult.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }
        
        // Print Summary Table
        System.out.println("=======================================================================");
        System.out.printf("%-10s | %-15s | %-15s | %-15s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("-----------------------------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("Round %-4d | %-15s | %-15s | %-15s%n", (i + 1), playerMoves[i], computerMoves[i], results[i]);
        }
        System.out.println("=======================================================================");
        
        // Calculate and print final stats
        double winPercentage = ((double) wins / n) * 100.0;
        System.out.printf("\nFinal Summary (after %d rounds):%n", n);
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n", wins, losses, draws, winPercentage);
        
        scanner.close();
    }
}
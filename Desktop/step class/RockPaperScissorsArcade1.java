public class RockPaperScissorsArcade1 {

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
        int n = 5; // Number of rounds
        
        // Predefined lists to match the exact sample output case
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Paper", "Rock"};
        String[] computerMoves = {"Scissors", "Paper", "Rock", "Rock", "Paper"};
        String[] results = new String[n];
        
        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println("Running Live Demo (Sample Input/Output)...\n");

        // Game Loop
        for (int i = 0; i < n; i++) {
            String pMove = playerMoves[i];
            String cMove = computerMoves[i];
            
            // Determine result
            String roundResult = playRound(pMove, cMove);
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
    }
}

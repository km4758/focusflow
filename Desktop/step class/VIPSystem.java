import java.util.Scanner;

public class VIPSystem {

    // One-line method to check the ID
    public static String validateCustomerId(String id) {
        return id.startsWith("VIP-") ? "VIP Customer" : "Regular Customer";
    }

    public static void main(String[] args) {
        // Set up the Scanner to read user input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user
        System.out.print("Enter Customer ID: ");
        String userInput = scanner.nextLine().trim();
        
        // Process the input and print the result
        System.out.println("Output: " + validateCustomerId(userInput));
        
        // Close the scanner
        scanner.close();
    }
}
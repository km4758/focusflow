public class QATextVerification {

    // 1. Iterative Approach: Compare characters from both ends moving toward the middle
    public static boolean isPalindromeIterative(String text) {
        if (text == null) return false;
        
        int left = 0;
        int right = text.length() - 1;
        
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 2. Recursive Approach: Compare first and last, shrinking the substring each call
    public static boolean isPalindromeRecursive(String text) {
        if (text == null) return false;
        
        // Base case: a string of 0 or 1 characters is a palindrome
        if (text.length() <= 1) {
            return true;
        }
        
        // If first and last characters don't match, it's not a palindrome
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        
        // Recursive call with the inner substring
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    // 3. Array Reversal Approach: Convert to array, reverse it, and compare to original
    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) return false;
        
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];
        
        // Reverse the array manually
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }
        
        // Convert reversed array back to string and compare
        String reversedText = new String(reversed);
        return text.equals(reversedText);
    }

    // Helper method to format boolean result into the requested output string
    private static String formatResult(boolean isPal) {
        return isPal ? "Palindrome" : "Not Palindrome";
    }

    public static void main(String[] args) {
        // Sample Inputs
        String[] testInputs = {"madam", "hello"};

        System.out.println("Running QA Text Verification Toolkit...\n");

        for (String input : testInputs) {
            // Run all three approaches
            boolean iterResult = isPalindromeIterative(input);
            boolean recResult = isPalindromeRecursive(input);
            boolean arrResult = isPalindromeArrayReversal(input);

            // Print the formatted output exactly as requested in the sample
            System.out.println("Input: \"" + input + "\"");
            System.out.printf("Output: Iterative: %s | Recursive: %s | Array Reversal: %s%n", 
                              formatResult(iterResult), 
                              formatResult(recResult), 
                              formatResult(arrResult));
        }
    }
}
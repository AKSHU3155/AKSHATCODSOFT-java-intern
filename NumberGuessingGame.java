
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    // Method for playing one round
    public static boolean playGame(Scanner scanner) {
        Random rand = new Random();
        int numberToGuess = rand.nextInt(100) + 1; // Random number 1-100
        int attemptsAllowed = 7;
        int attemptsTaken = 0;

        System.out.println("\n🎯 Welcome to the Number Guessing Game!");
        System.out.println("I have picked a number between 1 and 100.");
        System.out.println("You have " + attemptsAllowed + " attempts to guess it!\n");

        while (attemptsTaken < attemptsAllowed) {
            System.out.print("Attempt " + (attemptsTaken + 1) + ": Enter your guess: ");

            // Step 2: Take input
            int guess;
            try {
                guess = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("⚠️ Please enter a valid number!");
                scanner.next(); // clear invalid input
                continue;
            }

            attemptsTaken++;

            // Step 3: Compare guess
            if (guess == numberToGuess) {
                System.out.println("✅ Correct! The number was " + numberToGuess + ".");
                return true; // Round won
            } else if (guess < numberToGuess) {
                System.out.println("📉 Too low! Try again.");
            } else {
                System.out.println("📈 Too high! Try again.");
            }
        }

        System.out.println("❌ Out of attempts! The number was " + numberToGuess + ".");
        return false; // Round lost
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        int roundsPlayed = 0;

        while (true) {
            roundsPlayed++;
            boolean won = playGame(scanner);

            if (won) {
                score++;
                System.out.println("🏆 You won this round!");
            } else {
                System.out.println("😢 Better luck next time!");
            }

            System.out.println("📊 Score: " + score + " wins out of " + roundsPlayed + " rounds.\n");

            // Step 6: Option to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();

            if (!playAgain.equals("yes") && !playAgain.equals("y")) {
                System.out.println("\n🎮 Thanks for playing! Final Score:");
                System.out.println("🏅 " + score + " wins in " + roundsPlayed + " rounds.");
                break;
            }
        }

        scanner.close();
    }
}

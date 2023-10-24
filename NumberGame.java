import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.println("Welcome to the Number Guessing Game!");
        boolean playAgain = true;
        int totalRounds = 0;
        int totalAttempts = 0;

        while (playAgain) {
            totalRounds++;
            int targetNumber = random.nextInt(100) + 1;
            int attempts = 0;

            System.out.println("\nRound " + totalRounds + ":");
            System.out.println("I have chosen a number between 1 and 100. Can you guess it?");
            
            while (true) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the number " + targetNumber + " in " + attempts + " attempts.");
                    totalAttempts += attempts;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low. Try a higher number.");
                } else {
                    System.out.println("Too high. Try a lower number.");
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next();
            playAgain = playAgainInput.equalsIgnoreCase("yes");
        }

        double averageAttempts = (double) totalAttempts / totalRounds;
        System.out.println("\nGame over. You played " + totalRounds + " rounds with an average of " + String.format("%.2f", averageAttempts) + " attempts per round.");
    }
}

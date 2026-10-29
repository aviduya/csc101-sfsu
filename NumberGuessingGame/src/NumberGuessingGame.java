import java.util.Random;
import java.util.Scanner;


public class NumberGuessingGame {

    public static void main(String[] args) {
        boolean isGuessed = false;
        int numberToGuess = new Random().nextInt(1, 101);
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the number guessing game!\n");

        while(!isGuessed) {
            System.out.print("Please guess a number between 1 and 100: ");

            if (!input.hasNextInt()) {
                System.out.println("Invalid input. Please try again");
                input.next();
                continue;
            }

            int userGuess = input.nextInt();

            if (userGuess < 1 || userGuess > 100) {
                System.out.println("Enter a number between 1 and 100.");
                continue;
            }

            if (userGuess < numberToGuess) {
                System.out.println("Your guess is too low, try again");
            } else if (userGuess > numberToGuess) {
                System.out.println("Your guess is too high, try again");
            } else {
                System.out.print("Correct! The Number to guess is " + numberToGuess);
                isGuessed = true;
            }
        }
        input.close();
    }
}

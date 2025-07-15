import java.util.Scanner;

public class Assignment5 {
    public static void main(String[] args) {
        System.out.println("Welcome to Kailyn Ding's number guessing game! Enter a number, and I will tell you if it's too big or too small. You have 10 guesses! ");
        Scanner s = new Scanner(System.in);
        int secretNum = 24;
        int guess;
        int numGuesses = 10;

        while (numGuesses>0) {
            System.out.print("Enter your guess: ");
            guess = s.nextInt();

            if (1 <= guess & guess <=999) {
                numGuesses -= 1;
                if (guess == secretNum) {
                    System.out.print("Congratulations! That is the secret number! :3");
                    break;
                }
                else if (numGuesses != 0 & guess < secretNum) {
                    System.out.printf("Choose a larger number! You have %d guesses left.\n", numGuesses);
                }
                else if (numGuesses != 0 & guess > secretNum) {
                    System.out.printf("Choose a smaller number! You have %d guesses left.\n", numGuesses);
                }

            }
            else {
                System.out.println("Invalid Input! Ensure your number is between 1 and 999!");
            }

            if (numGuesses == 0 & guess != secretNum) {
                System.out.print("Too bad! Try harder next time! ");
            }
        }



    }
}
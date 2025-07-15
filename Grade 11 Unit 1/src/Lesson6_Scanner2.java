// Ask the user to continuously enter positive integers
// If they enter a non-positive integer, it will display the sum of all the positive integers that were entered
import java.util.Scanner;

public class Lesson6_Scanner2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int number;
        int sum = 0;

        System.out.print("Type in your number git: ");
        number = s.nextInt();
        while (number > 0) {
            sum += number;
            System.out.print("Type in your number kailyn DINGgit: ");
            number = s.nextInt();
        }
        System.out.printf("your sum is %d kailyn DONG!", sum);
    }
}

// Note:
// s.nextLine obtains string input
// s.nextInt obtains an integer input
// s.nextDouble obtains a double input
// s.nextBoolean obtains a boolean input
// s.next() obtains a string input up to the first space
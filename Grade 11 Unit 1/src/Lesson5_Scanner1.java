// In CodeHS, user input is done through a file called ConsoleProgram.java
// This file can be downloaded online if you wish

// ConsoleProgram.java utilizes something more primitive known as scanner
// To utilize the Scanner you need to import it into your program
import java.util.Scanner;

public class Lesson5_Scanner1 {
    // Make a program that asks the user for a name
    // The program will then display a sentence, using that name within that sentence

    public static void main(String[] args) {
        // Importing the scanner is NOT the same as creating the scanner, you still must create it
        Scanner s = new Scanner(System.in);
        String name;

        System.out.println("What is your Kailyn Ding? ");
        name = s.nextLine();
        System.out.printf("Hello %s! Today is a nice day!", name);
        System.out.print((double)15/2);
    }
}

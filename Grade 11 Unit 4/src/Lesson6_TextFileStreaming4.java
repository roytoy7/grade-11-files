import java.util.Scanner;
import java.io.*;
public class Lesson6_TextFileStreaming4 {
    public static void main(String[] args) throws IOException{
        // Variables
        Scanner inputFile = new Scanner(new File("marksWithNames.txt"));
        PrintWriter outputFile = new PrintWriter(new FileWriter("markWithNames2.txt"));

        String firstName;
        String lastName;
        double termMark;
        double finalExam;


        // Print the header:
        outputFile.printf("%-15s%-15s%-15s%-15s%-15s%n", "First Name", "Last Name",
                "Term Marks", "Final Exam", "Final Grade");

        while (inputFile.hasNextLine()){
            firstName = inputFile.next();
            lastName = inputFile.next();
            termMark = inputFile.nextDouble();
            finalExam = inputFile.nextDouble();
            outputFile.printf("%-15s%-15s%-15.1f%-15.1f%-15.1f%n", firstName, lastName, termMark, finalExam
            , (finalExam*0.3+termMark*0.7));
        }

        // Close Files
        inputFile.close();
        outputFile.close();
        System.out.println("YOU DID IT KAILYN DING DONG JIT");
    }
}

import java.util.Scanner;
import java.io.*;
public class Lesson5_TextFileStreaming3 {
    // Goal:
    // Duplicate all the data from grades into grades 2
    // With the addition of the follow attached at the bottom:
    // Average: ______%
    public static void main(String[] args) throws IOException{
        // Variables
        Scanner inputFile = new Scanner(new File("grades.txt"));
        PrintWriter outputFile = new PrintWriter(new FileWriter("grades2.txt"));
        double currentEntry;
        double sumEntries = 0;
        int noOfEntries = 0;

        while (inputFile.hasNextLine()){
            currentEntry = inputFile.nextDouble();
            noOfEntries++;
            sumEntries += currentEntry;
            outputFile.println(currentEntry);
        }
        outputFile.printf("Average: %.1f%%", sumEntries/noOfEntries);

        inputFile.close();
        outputFile.close();
        System.out.println("Streaming completed, the mayor approves");
    }
}

import java.util.Scanner;
import java.io.*;
// 1) Read marksWithNames.txt and store all the data into their respective arrays
// 2) Overwrite so that it consists of the same data, but with formatting applied
// as well as an extra 'final grade' column
public class Lesson6_ArrayMethods5 {
    public static void main(String[] args) throws IOException{
        // Variables
        String[] firstName = new String[24];
        String[] lastName = new String[24];
        double[] termMarks = new double[24];
        double[] examMarks = new double[24];

        Scanner inputFile = new Scanner(new File("marksWithNames.txt"));
        PrintWriter outputFile;

        inputFile.nextLine();
        inputFile.nextLine();

        for (int i=0; i<24;i++){
            firstName[i] = inputFile.next();
            lastName[i] = inputFile.next();
            termMarks[i] = inputFile.nextDouble();
            examMarks[i] = inputFile.nextDouble();
        }
        inputFile.close();
        // overwrite with proper format and final grade
        outputFile = new PrintWriter(new FileWriter("marksWithNames.txt"));

        outputFile.printf("%-15s%-15s%-15s%-15s%-15s%n", "First Name", "Last Name", "Term Marks", "Exam Marks", "Final Grade");
        for (int i=0; i<24;i++){
            outputFile.printf("%-15s%-15s%-15.1f%-15.1f%-15.1f%n", firstName[i], lastName[i], termMarks[i], examMarks[i], termMarks[i]*0.7+examMarks[i]*0.3);
        }
        outputFile.close();
    }




}

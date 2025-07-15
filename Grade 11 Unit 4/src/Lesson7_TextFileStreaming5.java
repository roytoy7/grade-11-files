import java.util.Scanner;
import java.io.*;
// convert dates from mmdd to MMM (D)D
public class Lesson7_TextFileStreaming5 {

    // convertDate Method
    // Takes in a string parameter, s, which will be a date in MMDD format
    // the method then returns the date in MMM (D)D format

    public static String convertDate(String s){
        // PARSING
        // corresponds to the conversion between String and integer/double
        // Different from casting, which usually cannot fail
        // Is different because binary number storage of string is completely diff from int

        // Integer.parseInt(n)
        // Parses a string into an integer
        // given that it is possible
        // Integer.parseInt("97") -> 97
        // Integer.parseInt("14.15") -> throws an exception
        // Integer.parseInt("-123") -> -123
        // Integer.parseInt("abs") -> throws an exception

        // Double.parseDouble(s)
        // Parses a string into a double given that it is possible
        // Double.parseDouble("4") -> 4.0

        int month = Integer.parseInt(s.substring(0, 2));
        int day = Integer.parseInt(s.substring(2));
        String months = "JANFEBMARAPRMAYJUNJULAUGSEPOCTNOVDEC";
        return months.substring((month-1)*3, month*3) + " " + day;

    }

    public static void main(String[] args) throws IOException{
        Scanner inputFile = new Scanner(new File("dates.txt"));
        PrintWriter outputFile = new PrintWriter(new FileWriter("dates2.txt"));
        
        while (inputFile.hasNextLine()){
            outputFile.println(convertDate(inputFile.nextLine()));
        }

        inputFile.close();
        outputFile.close();
        System.out.println("gdicsad");
    }

}

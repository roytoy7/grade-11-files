import java.util.Scanner;
import java.io.*;
public class Lesson4_TextFileStreaming2 {
    public static void main(String[] args) throws IOException{
        Scanner inputFile = new Scanner(new File("names.txt"));
        PrintWriter outputFile = new PrintWriter(new FileWriter("employees.txt"));
        /*
        for (int i=1; i<=30; i++){
            outputFile.println(i + " " + inputFile.nextLine());
        }
        */
        int i = 1;
        while(inputFile.hasNextLine()){ // if u don't know how many lines
            outputFile.println(i + " " + inputFile.nextLine());
            i++;
        }
        inputFile.close();
        outputFile.close();
        System.out.println("Streaming completed, the mayor approves");
    }
}


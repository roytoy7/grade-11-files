import java.util.Scanner;
import java.io.*;
public class Lesson5_ArrayMethods4 {
    // Class Variable
    public static int[] highscore = new int[3];

    // Write a method called overwriteHighscore that takes an integer, score
    // This method will overwrite:
    // 1) The class variable 'highscore' if needed
    // 2) the textfile 'highscore.txt'
    // this method does not return any data

    public static void overwriteHighscore(int score) throws IOException{
        if (score>highscore[0]) {
            highscore[2] = highscore[1];
            highscore[1] = highscore[0];
            highscore[0] = score;
        }
        else if (score>highscore[1]){
            highscore[2] = highscore[1];
            highscore[1] = score;
        }
        else if (score>highscore[2]){
            highscore[2] = score;
        }

        // Updating the 'highscore.txt' textfile
        PrintWriter outputFile = new PrintWriter(new FileWriter("highscore.txt"));
        outputFile.println(highscore[0]);
        outputFile.println(highscore[1]);
        outputFile.println(highscore[2]);
        outputFile.close(); //optional
    }

    public static void main(String[] args) throws IOException{
        // Data Importation
        Scanner inputFile = new Scanner(new File("highscore.txt"));

        //Variables
        Scanner s = new Scanner(System.in);
        String userinput;
        int score;

        // Main Body
        highscore[0] = inputFile.nextInt();
        highscore[1] = inputFile.nextInt();
        highscore[2] = inputFile.nextInt();
        inputFile.close();

        System.out.print("Play? (y/n): ");
        userinput = s.next();
        while (!userinput.equals("n")){
            System.out.print("Score: ");
            score = s.nextInt();
            overwriteHighscore(score);
            System.out.printf("Highscores: %d, %d, %d%n%n", highscore[0], highscore[1], highscore[2]);
            System.out.print("Play again? (y/n): ");
            userinput = s.next();
        }
        System.out.println("Thank you for playing!");

    }
}

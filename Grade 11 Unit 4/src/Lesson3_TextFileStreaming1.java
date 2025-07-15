import java.util.Scanner;
import java.io.*; //**** MMEOROOZIIEE
public class Lesson3_TextFileStreaming1 {
    // In this program we will be:
    // Streaming the 4 data from the text file myData.txt
    // We will then print out a statement that relates to the 4 data type

    public static void main (String[] args) throws IOException{ ///MEMORIZE
        String name;
        int grade;
        double marks;
        String hobby;

        Scanner inputFile = new Scanner(new File("myData.txt"));

        name = inputFile.nextLine();
        grade = inputFile.nextInt();
        marks = inputFile.nextDouble();
        hobby = inputFile.nextLine();

        System.out.println(hobby);

        System.out.printf("Hellow! I am %s! I am a grade %d student with a %.2f%% " +
                "at Markville.", name, grade, marks);
    }
}

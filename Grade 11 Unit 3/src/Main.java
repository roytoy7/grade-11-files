
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String answer = "";
        while (!answer.toLowerCase().equals("yes")){
            System.out.print("Do you want to burn down the school (Yes or No)?: ");
            answer = s.nextLine();
            if (answer.toLowerCase().equals("yes")) System.out.println("the school burnt down!");
            else System.out.println("Choose again!");
        }
    }
}
import java.util.Scanner;
public class FormativeTask_3 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        for(int i=-5687; i<=287464 ;i+=139){
            System.out.println(i);
        }
        int n;
        System.out.println("\n\n\n");

        // Question 2
        System.out.print("Enter positive integer: ");
        n = s.nextInt();
        while (n<=0) {
            System.out.print("Enter positive integer: ");
            n = s.nextInt();
        }
        int acc = 0;
        System.out.printf("\nThe first %d perfect squares are: \n", n);
        for (int i=1; i<=n; i++) {
            System.out.println(i*i);
            acc += i*i;
        }
        System.out.printf("\nThe sum of the first %d perfect squares is: %d", n, acc);




    }
}

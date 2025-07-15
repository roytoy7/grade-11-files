public class Lesson4_Series {
    public static void main (String[] args){

        // Question 1
        System.out.println("---- Question 1 ----");
        // Display the solution to the following series using while loop:
        // 5 + 9 + 13 + ... + 489

        int acc1 = 0;
        int a = 5;
        while (a<=489){
            acc1 += a;
            a += 4;
        }
        System.out.println(acc1);

        // Question 2
        System.out.println("\n\n---- Question 2 ----");
        // Display the solution to the following series using for loop:
        // 97 + 84 + 71 + ... - 423

        int acc2 = 0;
        for (int i=97; i>=-423; i-=13) {
            acc2 += i;
        }
        System.out.println(acc2);

        // Question 3
        System.out.println("\n\n---- Question 3 ----");
        // Display the solution to the following series using for loop:
        // 2 + 6 + 18 + ... + 28697814
        int acc3 = 0;
        for (int i=2; i <= 28697814; acc3+=i, i *=3) {}
        System.out.println(acc3);

        // Question 4
        System.out.println("\n\n---- Question 4 ----");
        // Display the solution to the following series using while loop:
        // -5 + 10 - 20 + 40 - ... + 167 772 160
        int d = -5;
        int acc4 = 0;
        while (d != 167772160*-2) {
            acc4 += d;
            d *= -2;
        }
        System.out.println(acc4);

        // Question 5
        System.out.println("\n\n---- Question 5 ----");
        // Display the solution to the following series using for loop:
        // 3 x 5 x 7 x ... x 19
        int acc5 = 1;
        for (int i = 3; i <=19; i+=2) {
            acc5 *=i;
        }
        System.out.println(acc5);
    }
}

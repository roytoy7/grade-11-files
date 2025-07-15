public class Lesson3_ForLoops {
    public static void main (String[] args){
        // for (___;____;____)
        // 1) Local variable declaration
        // 2) Condition + execution
        // 3) Adjustment factor
        // These are local variables and get erased from memory :( (SELF ERASE GIT ONCE FOR LOOP IS BROCKEN AND EMO)
        // Professionals prefer for loops because the local variables self erase, which clears up un-use variables and makes memory more efficient

        // Question 1
        // Use a for loop to display the following sequence:
        // 9, 16, 23, 30...583

        System.out.println("----Question 1----");

        for(int a=9; a<=583; a+=7) {
            System.out.println(a + "git");
        }

        // Question 2
        System.out.println("\n\n---- Question 2 ----");
        // Display the following sequence:
        // -120, -107, -94, -81...348

        for(int b=-120; b<=348; b+=13) {
            System.out.println(b);
        }

        // Question 3
        System.out.println("\n\n---- Question 3 ----");
        // Display the following sequence:
        // 94, 86, 78....-298

        for(int c=94; c>=-298; c-=8) {
            System.out.println(c);
        }

        // Question 4
        System.out.println("\n\n---- Question 4 ----");
        // Display the following sequence:
        // 2, 6, 18, 54... 28697814

        for (int d=2; d<=28697814; d*=3) {
            System.out.printf("%,d%n", d);
        }

        // Question 5
        System.out.println("\n\n---- Question 5 ----");
        // Display the following sequence:
        // -5, 20, -80...-5242880
        for (int i=-5; i!=-5242880*-4; i*=-4) {
            System.out.printf("%,d%n", i);
        }

        // Question 6
        System.out.println("\n\n---- Question 6 ----");
        // Display the following sequence: 5 120, 8 116, 11 112... 95 0

        for (int i=0; (5+3*i) <= 95; i++){
            System.out.println((5+3*i) + " " + (120-4*i));
        }

        for (int x = 5, y = 120; x <=95; x+=3, y-=4) {
            System.out.println(x + " " + y);
        }

        int o = 5;
        int p = 120;
        while(p>=0) {
            System.out.println(o + " " + p);
            o += 3;
            p -= 4;
        }
        // You can declare more than one local variable (as many as you want)
        // You can also declare NOTHING!@!?@?
        // You can have conditions that do NOT rely on the local variables that were declared
        // You can have more than one or no adjustment factor
        // Adjustment factor can affect global variables
    }
}

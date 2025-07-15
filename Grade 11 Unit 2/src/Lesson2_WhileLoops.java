public class Lesson2_WhileLoops {
    public static void main (String[] args){
        // Question 1
        System.out.println("---- Question 1 ----");

        // Display the following sequence:
        // 9, 16, 23, 30...583

        int x = 9;
        while (x<=583){
            System.out.println(x);
            x += 7;
        }

        // What is the final value of a after we escape the loop?
        // 590 you GIT

        // Question 2
        System.out.println("\n\n---- Question 2 ----");
        // Display the following sequence:
        // -120, -107, -94, -81...348

        int b = -120;
        while (b<=348) {
            System.out.println(b);
            b += 13;
        }

        // Question 3
        System.out.println("\n\n---- Question 3 ----");
        // Display the following sequence:
        // 94, 86, 78....-298
        int c = 94;
        while (c>=-298) {
            System.out.println(c);
            c -= 8;
        }

        // Question 4
        System.out.println("\n\n---- Question 4 ----");
        // Display the following sequence:
        // 2, 6, 18, 54... 28697814
        int d = 2;
        while (d<=28697814){
            System.out.println(d);
            d *= 3;
        }

        // Question 5
        System.out.println("\n\n---- Question 4 ----");
        // Display the following sequence:
        // -5, 20, -80...-5242880
        int e = -5;
        while (e!=-5242880*-4) { // or do <= 5242880 or Math.abs(e) <= 5242880
            System.out.println(e);
            e *= -4;
        }

    }
}

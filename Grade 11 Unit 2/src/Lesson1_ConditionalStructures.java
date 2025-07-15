public class Lesson1_ConditionalStructures {
    public static void main(String[] args) {

        // Without running the program
        // Determine what will be displayed in the console

        // Q1
        System.out.println("----Question 1----");

        int a = 3;
        int b = 4;

        System.out.println("hi git");
        // How many conditional structures are here? TWO: initialization of conditional structure is if
        // There can be things attached to the if, so they end up forming one
        // Only a max of one output can happen within a conditional structure


        if (a >=b ) { // iS 3 BIGGER THAN 4 GIT/!?!@?@!?
            System.out.println("A");
        }

        else if (a + b != b + a){
            System.out.println("B");
        }
        else {
            System.out.println("C"); // displayed :3
        }
        if(Math.pow(a, 2) >=  Math.pow(b, 3)) { // FALSWEE!
            System.out.println("D");
        }
        else {
            System.out.println("E");
        }

        // Question 2
        System.out.println("\n----Question 4----");

        double c = 5.3;
        int d = 9;
        int e = 5;

        // there are 4 conditional structures in this one

        if (d % e < c % e) { // false
            System.out.println("A");
        }
        if (c%2 >= c%3) { // false
            System.out.println("B");
        }
        else if (d%2 != e%2) { // false
            System.out.println("C");
        }
        if (c%2 != c%3) { //true
            System.out.println("D");
        }
        if (d-c > d / e){ // true
            System.out.println("E");
        }
        else {
            System.out.println("F");
        }
    }
}

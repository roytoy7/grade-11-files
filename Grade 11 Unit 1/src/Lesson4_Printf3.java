public class Lesson4_Printf3 {
    public static void main(String[] args){
        // In the previous lesson, we talked about reserved spaces and left/right alignment

        String firstName = "Kailyn";
        String lastName = "Ding";

        System.out.printf("%15s%10s\n", firstName, lastName);

        // In this lesson, we'll cover 4 formatting that are NUMBERS specific
        // These formatting cannot apply to Strings

        // 1) Comma Separator, adds a comma every 3 digits starting from the right: 1,234,553,345
        // Add comma BEFORE reserved spacing
        int a = 12345678;
        System.out.printf("%,15d\n", a);
        System.out.printf("%,d\n", a);

        double b = 12345.67812419;
        System.out.printf("%,20f\n", b); // by default floats always get 6 decimal places and rounds
        System.out.printf("%,f\n", b);

        // 2) Leading Zeroes
        // Given a number is RIGHT ALIGNED, and there are enough reserved spaces
        // Before the number is printed, the computer will fill those reserved spaces with zeroes

        System.out.printf("%0,15d", a);
        //System.out.printf("\n%-15d", a); cannot have 0 and left alignment! does nOT WORK!!

        // 3) Positive Symbol
        // Adds a positive symbol in front of the number if it is positive. No effect if negative.
        // Add plus BEFORE reserved spaces
        int c = 344231;
        double d = -56.78;
        System.out.printf("\n%15d", c);
        System.out.printf("\n%+,15d", c);
        System.out.printf("\n%15.1f IRHWEOIHEE", d);
        System.out.printf("\n%+15f", d);

        // Mix and Match
        // You can mix and match the 3 flags however you want ;3
        // As long as you don't have left alignment and leading zero conflict

        System.out.printf("\n%0+,20d", a);
        System.out.printf("\n%,+-20f", b);

        // 4) Decimal Places ONLY APPLIES TO DOUBLES, %f
        // You can control the number of decimal places being displayed
        // By default, it displays 6 wow, you can display up to n AFTER the reserved spaces
        double e = 2.71828;
        System.out.printf("\n%20.8f", e); // It pads with 0 if you add more decimals, TRAILING 0
        System.out.printf("\n%.2f", e);

        // Ultimate :|
        System.out.printf("\n%+-20.5f", e);
        System.out.println("I HATE COMPSCI SCREW THIS");
        System.out.printf("%20s", "EWWWWWW JAVA");
        System.out.printf("\n%.9f", 5.6);

    }
}

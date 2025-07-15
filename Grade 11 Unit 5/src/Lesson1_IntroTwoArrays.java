public class Lesson1_IntroTwoArrays {
    public static void main (String[] args){
        int[] marks = new int[5];


        // marks, despite being called an array is actually a memory location
        // of where the array is located in the RAM ;3
        // So, when you run this:
        System.out.println(marks);
        // You'll get something like I@XXXXXXX
        // which represents the memory location inside the RAM

        marks[0] = 93;
        marks[1] = 82;
        marks[2] = 71;
        marks[3] = 90;
        marks[4] = 62;
        System.out.println(marks);
        // Question: How do i display the elements in the entire array
        // Answer: You have to use a for loop to display all the elements in the array
        // for (int i = 0;  )

        for(int i=0; i<5; i++){
            System.out.println(marks[i]);
        }

        // When an array is created, another integer variable is AUTOMATICALLY created
        // Similar to how string has method .length()
        // array has a variable that stores the size of the array
        // no brackets bc it is a variable, not a method
        System.out.println(marks.length);


        // PASS-BY-VALUE VS PASS-BY-REFERENCE

        // Pass-By-Value
        // When you set a second variable (primitive) to equal to the first variable (primitive)
        // the value is PASSED over (copied)
        // primitive = double, int, chr, bool
        int a = 5;
        int b = a;

        a+=3; // whatever you do to one does not affect the other
        System.out.println(b);

        // Pass-by-reference
        // When you set a second variable (non-primitive) to equal to a first variable
        // (non-primitive), the memory address is passed over

        int[] abc = marks; // copies over memory address which is why whatever you do to one affects other

        marks[0] = 39;

        System.out.println(abc[0]);

        abc[2] = 50;

        System.out.println(marks[2]);

        // Determine what will be displayed GIT:
        int x = 13;
        int y = x;

        int[] s = new int[3];
        int[] t = s;
        y+=3;
        s[0] = y;
        t[1] = x+y;
        x -=3;
        s[2] = t[0] + t[1];
        for (int i=0; i<3; i++){
            System.out.println(s[i]);
        }

        // 10, 16
        // 16
        // 29
        // 45


    }
}

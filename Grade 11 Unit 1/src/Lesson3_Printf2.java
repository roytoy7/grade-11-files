public class Lesson3_Printf2 {
    public static void main(String[] args){
        // Reserved Spacing
        String name = "Matthew Tan";
        String school = "KailynDingDongGitville";

        System.out.printf("%15s%13s\n", name, school); // If you add a number in between, it will add a reserved space
        // and will fill it in from the right (last length of string spaces)

        // Example 2
        String someWords = "marks";
        int mark = 42;

        System.out.printf("%10s%5d", someWords, mark);

        // Example 3
        String student1 = "Richard";
        String student2 = "Amrita";
        String student3 = "Matthew Tangent";
        int grade1 = 99;
        int grade2 = 99;
        int grade3 = 5;
        // BY DEFAULT, RESERVED SPACES ARE RIGHT ALIGNED
        // If you with your data to be left, add a  negative you GIT
        // In front of the reserved spacing number
        System.out.printf("\n%-17s%-10s\n", "Student Name", "Marks");
        System.out.printf("%-17s%-10d\n", student1, grade1);
        System.out.printf("%-17s%-10d\n", student2, grade2);
        System.out.printf("%-17s%-10d\n", student3, grade3);

        // What if texts are longer than reserved spaces???
        System.out.printf("%4s%5s", "Computer", "Science"); // As though reserved spaces was never there, they become nullified
        // If one of them is alright, then only that one will have a reserved that will work

        System.out.printf("\n%8s goes to %12s Secondary School. He graduated with average %s of %d.\n", name, school, someWords, mark);
    }
}

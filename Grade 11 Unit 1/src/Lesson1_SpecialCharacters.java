public class Lesson1_SpecialCharacters {

    public static void main(String[] args){
        // Q1: How do I display the double quotation symbol in a sentence?
        // A1: Use the escape character - \ backslash
        // Something should come after when you use the escape
        // In this case, to display the double quotation marks
        // we use \"
        System.out.println("I \"LOVE\" computer science");

        // Q2: If the computer treats backslash as a special character, how do you type backslash?
        // Just type two backslash bruh GIT \\\\\\\
        System.out.println("I \\LOVE\\ computer science");

        // Potential Test Question
        // Determine what will be displayed if we execute the following command
        System.out.println("\\\\\"\"\\\\\\\""); // ITS GOING TO BE THIS!!!: \\""\\\"

        // Q3: \n does a new line
        System.out.println("I\nlove\nkailyn\nding\nDONG");

        // Q4: \t, TAB SPACING
        //      Tab Spacing places the cursor to the next cursor position that is a multiple of 4
        //      First position of a line/cursor is 0. After typing a letter, the cursor moves to p1.
        //      If you tab, it moves it to the next 4 (0, 4, 8, 12) (move to the next 4th block grp)
        System.out.println("ab\tc\td");
        System.out.println("abcde\tfghi\tjk\tl"); // abcde   fghi    jk  l

        // Super fun exercise
        System.out.println("\"\ttt\nnnn\ttt\n\\\\nntt\"");
        // "   tt
        // nnn tt
        // \\nntt"


    }
}

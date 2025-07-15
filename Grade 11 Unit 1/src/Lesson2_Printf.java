public class Lesson2_Printf {
    public static void main(String[] args) {// 1 mark out of 8 application on the test
        //What does the 'f' in printf stand for?
        //'f' stands for format

        //printf and print are the same if no formatting

        //Both print/printf do not skip line

        //printf is more professional

        String name = "Kailyn Ding-";
        int grade = 11;
        String school = "Markville";

        System.out.println("My name is " + name + ", I'm a grade " + grade + " student at " + school + ".");
        System.out.printf("My name is %s, I'm a grade %d student at %s.", name, grade, school);
        //%s is a string placeholder
        //%d is a digit or integer placeholder
        //%f is a float or double placeholder
        //%b is a boolean placeholder

        //2nd example
        int a = 9;
        int b = 17;
        System.out.printf("\n%d x %d = %d", a, b, a*b);

        //3rd example
        String university = "Waterloo";
        double mark = 72.5;
        System.out.println("\nI'm " + name + " at " + school + ". I want to go to "
                + university + " with a " + mark + "%."); // println skips a line AFTER the line it writes
        System.out.printf("I'm %s at %s. I want to go to %s with a %f%%.",
                name, school, university, mark); // Double: display six decimal places
        // Display a single percentage symbol: %%
    }
}

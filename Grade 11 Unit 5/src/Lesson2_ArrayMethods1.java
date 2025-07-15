// Array Methods
// Array Parameter(s) -> Primitive Data
public class Lesson2_ArrayMethods1 {
    // Question 1
    // Write a method called totalChars which takes a String array, words
    // The method returns the total number of characters in the array words

    // totalChars({"Hello", "World", "!"} -> 11)
    public static int totalChars(String[] words){
        int sum = 0;

        for (int i=0; i<words.length;i++){
            sum += words[i].length();
        }
        return sum;
    }

    // Question 2
    // Write a method called average which takes an integer array, marks
    // The method returns the average of all the elements in marks

    public static double average(int[] marks){
        double kailyn = 0.00;
        for (int i=0; i<marks.length;i++){
            kailyn += marks[i];
        }
        return kailyn/marks.length;
    }
    public static void main(String[] args){
        String[] names = {"Kailyn", "Ding", "Dong", "JIT"};
        String[] emptyStringArray = {};
        int[] cook = {93, 92, 93, 96};
        System.out.println(totalChars(names));
        System.out.println(totalChars(emptyStringArray));
        System.out.println(average(cook));
    }

}

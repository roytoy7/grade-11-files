import java.util.*;
public class javaReview {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        /*
        String s = "     daniel Poopface Lin a      ";
        s = s.toLowerCase();
        System.out.println(s.trim());
        System.out.println(s);

         */

        /*
        1. [Input/Output, Loops]
        a) Write a program that lets you enter two sides of a right-angled triangle,
        and then prints the   length of the hypotenuse.
        b) Adding to the above program, make sure the lengths input by the user are valid.
        If it is not valid,  you must ask again until valid numbers are entered.



        System.out.println("What is the length of the first side?");
        double side1 = s.nextDouble();
        while (side1<=0){
            System.out.println("Please input a valid side length!");
            side1 = s.nextDouble();
        }

        System.out.println("What is the length of the second side?");
        double side2 = s.nextDouble();
        while (side2<=0){
            System.out.println("Please input a valid side length!");
            side2 = s.nextDouble();
        }
        double hyp = Math.pow((side1*side1)+(side2*side2),0.5);
        System.out.println("The length of the hypotenuse is " +
                Math.round(hyp*100)/100.0);

    2. [Loops]
    a) Write a program that finds the average between 10 numbers that are entered by the user.
    Round the result to two decimal places.
b) Adding to the above program, find and display the highest AND lowest of the 10 numbers entered.

        System.out.println("Enter 10 numbers: ");

        int a = s.nextInt();
        int max = a;
        int min = a;
        int sum = a;

        for (int i = 0; i<9;i++){
            a = s.nextInt();
            sum += a;
            max = Math.max(a, max);
            min = Math.min(a, min);
        }
        System.out.printf("The average is %.2f, the max number is %d and the min is %d", sum/10.0, max, min);
3. [Strings]
 Write a program that prints all the letters in the ODD positions of a string if it has an
 odd number of   letters. Otherwise, print all the letters in the EVEN positions of the string.
        System.out.println("Enter a string: ");
        String meow = s.nextLine();

        if (meow.length()%2==0) for (int i = 0; i<meow.length();i+=2) System.out.print(meow.charAt(i));
        else for (int i = 1; i<meow.length();i+=2) System.out.print(meow.charAt(i));

4. [Strings]
 Write a program that checks if a word is a palindrome.
 A palindrome is a word that is the same   forward and backward.
 (e.g. radar, Mom, MADam are all palindromes.)

        System.out.println("Enter a string: ");
        String meow = s.nextLine();
        boolean pee = true;
        for (int i = 0; i<meow.length();i++){
            if (meow.charAt(i)!=meow.charAt(meow.length()-i-1)) pee = false;
        }
        System.out.println(pee);

5. [Arrays, Methods]
 Write a method that lets you enter in a number and then it will translate it to its
 spoken form from   right to left. (ie. 32578 = eight seven five two three)
        int[] arrNum = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        String[] arrNames = {"zero", "one", "two", "three", "four", "five", "six", "seven",
        "eight", "nine"};
        System.out.println("Enter a number: ");
        int num = s.nextInt();
        while (num!=0){
            System.out.print(arrNames[num%10] + " ");
            num = (num-num%10)/10;
        }

         */
        String a = "yas";
        double g = 1412;

        System.out.println(swapLet(a));

        /*
1) Write a program that counts how many times a given word appears appears in a given sentence.
(case insensitive)
    (2 SOLUTIONS)

2) Write a program that REMOVES all occurrences of a given word in a
given sentence. (case insensitive)

3) Modify #2 such that it will remove any string that is entered by the user
(case insensitive), and then replace it with another string)
        poopo psfaodpacosdcjp spoadjcsop kdscap  poop poop caspojc spoop


        int count = 0;
        System.out.print("Enter a string: ");
        String origStr = s.nextLine();
        System.out.print("Enter a word: ");
        String word = s.nextLine();
        System.out.print("Enter the replacement word: ");
        String newWord = s.nextLine();

        int wordIndex = origStr.toLowerCase().indexOf(word.toLowerCase());
        while (wordIndex!=-1){
            origStr = origStr.substring(0, wordIndex) + newWord + origStr.substring(wordIndex+word.length());
            wordIndex = origStr.toLowerCase().indexOf(word.toLowerCase());
        }
        System.out.println(origStr);

         first solution
        for (int i = 0; i< origStr.length()-word.length()+1;i++){
            if (origStr.substring(i, i+word.length()).equalsIgnoreCase(word)) {
                count++;
                System.out.println(i);
                i+= word.length()-1;
            }

        }
        System.out.println(count);
        //sol2
        int wordDex = origStr.toLowerCase().indexOf(word.toLowerCase());
        while (wordDex!=-1){
            count++;
            origStr = origStr.substring(wordDex+word.length());
            System.out.println(origStr);
            wordDex = origStr.toLowerCase().indexOf(word.toLowerCase());
        }

        System.out.println(count);
        //2
        int wordIndex = origStr.toLowerCase().indexOf(word.toLowerCase());
        while (wordIndex!=-1){
            origStr = origStr.substring(0, wordIndex) + origStr.substring(wordIndex+word.length());
            wordIndex = origStr.toLowerCase().indexOf(word.toLowerCase());
        }
        System.out.println(origStr);
         */


    }

    public static String swapLet(String s){
        String word = "";
        for (int i = 0; i<s.length()/2;i++) {
            word += s.charAt(2*i + 1);
            word += s.charAt(2*i);
        }
        if (s.length()%2==1) word += s.charAt(s.length()-1);
        return word;
    }


}

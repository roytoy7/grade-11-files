public class Lesson1_StringMethods {
    public static void main(String[] args){
        // The following list of methods are the ONLY
        // acceptable methods you're allowed to use
        // for you assignments/assessments

        String school = "Markville SS!";
        // 1) toUpperCase()
        // This method returns a copy of the string, but with all lower cases converted to upper cases
        // og variable is still the same
        System.out.println(school.toUpperCase());

        // 2) toLowerCase()
        // This method returns a copy of the string, but with all upper cases converted to lower cases
        // og variable is still the same
        System.out.println(school.toLowerCase());

        // 3) charAt(#)
        // This method returns the character of a string at position #
        // The index of the character is the character after the cursor position of that number
        System.out.println(school.charAt(0));
        // Unlike Python, the command with #<0 does not work since index cannot be negative
        // If an index is too big, it says string index out of bound

        // 4) indexOf(s)
        // This method returns the index of the first LEFT occurrence
        // Of the string/character s in the string
        System.out.println(school.indexOf("a"));
        System.out.println(school.indexOf("ill"));

        // 5) equals(s)
        // This method returns true if the two strings are the same
        System.out.println(school.equals("chow"));
        System.out.println("Hello".equals("hello"));

        // 6) length()
        // This method returns the number of characters in the string
        // The number of characters is also the same as the last cursor position in a string
        System.out.println(school.length());

        // 7) lastIndexOf(s)
        // This  method returns the index in which the string/character s
        // is found in s, from the right side
        System.out.println(school.lastIndexOf("l"));

        // 8) substring(#)
        // This returns a copy of the string starting from the cursor position #
        // You cannot do negative number, but you can make a substring one greater value than length
        // This is because it grabs the cursor position in that index, which exists, giving an
        // empty string
        System.out.println(school.substring(6));
        System.out.println(school.substring(13));

        // 9) substring(#1, #2)
        // This method returns a copy of the string
        // From cursor position 1 to 2
        // Note: The difference between #2 and #1 is the number of
        // characters in your resulting string
        System.out.println(school.substring(4, 9));
    }
}

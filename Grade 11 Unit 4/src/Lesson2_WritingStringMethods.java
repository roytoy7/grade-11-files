public class Lesson2_WritingStringMethods {
    // 1) Write a method called everyN which takes a String s
    // and an integer n. This method returns a new String
    // consisting of every nth character from the String s

    public static String everyN(String s, int n){
        String kailyn = "";
        for (int i=0; i<s.length(); i++){
            if ((i+1)%n==0) kailyn+= s.charAt(i);
        }
        return kailyn;
    }


    // 2) Write a method addHyphens that takes a String str and returns
    // a new String with hyphens (-) added in between each character
    // of the String
    // addHyphens("Markville") -> "M-a-r-k-v-i-l-l-e"

    public static String addHyphens(String s){
        String kailynDing = "";
        for (int i=0; i<s.length()-1; i++){
            kailynDing += s.substring(i, i+1) + "-"; // or do += str.charAt(i) w no -1 condition
        }
        return kailynDing + s.substring(s.length()-1); // or return string w/o last char
    }

    // 3) Write a method called remove which takes a String str and a character ch
    // The method returns the string with all instances of ch removed
    // Remove ("Computer", 'r') -> "Compute"

    public static String remove(String str, char ch){
        String sb = "";
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i)!=ch){
                sb += str.charAt(i);
            }
        }
        return sb;
    }

    // 4) Write a method replace which takes a String str and two characters c1 and c2
    // The method returns a copy of str where all  instances of c1 replaced by c2
    // replace ("Markville", 'l', 'L')

    public static String remove(String str, char c1, char c2){
        String sb = "";
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i)!=c1){
                sb += str.charAt(i);
            }
            else sb += c2;
        }
        return sb;
    }


    public static void main(String[] args){
        System.out.println(everyN("abcdefgh", 2));
        System.out.println(everyN("abcdefgh", 3));
        System.out.println(addHyphens("markvilleeisdjiwdfregwhdjcfebwhsj"));
        System.out.println(everyN("Computer Science", 5));
        System.out.println(remove("kailyndingdingjot", 'i', 'E'));

    }
}

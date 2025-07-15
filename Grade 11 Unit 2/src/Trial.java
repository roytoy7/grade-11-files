public class Trial {
    public static void main(String[] args){
        int count1 = 0;
        int count2 = 0;
        String brackets = "{}{}{}{}{{}}}{}}";
        boolean kailyn = true;
        int x = 0;
        int y = 0;
        if (brackets.equals("")) {
        }

        else if (brackets.charAt(0) == '}' || brackets.charAt(brackets.length()-1) == '{') {
            kailyn = false;
        }

        else if (brackets.length() % 2 != 0) {
            kailyn = false;
        }
        else {
            System.out.println("h");
        }
        System.out.println(kailyn);
    }
}

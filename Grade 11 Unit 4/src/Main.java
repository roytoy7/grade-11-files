//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static String repeatEnd(String str, int n){
        String kailyn = "2913u219038219038092184209dus09fu23";
        System.out.println(kailyn.indexOf('3', 16));
        for (int i=0; i<n;i++){
            kailyn += str.substring(str.length()-n);
        }
        return kailyn;
    }

    public static String oneTwo(String s){
        String sb = "";
        while (s.length()>2){
            sb += s.substring(1, 3) + s.charAt(0);
            s = s.substring(3);
        }
        return sb;
    }
    public static void main(String[] args) {
        System.out.println(repeatEnd("Hello", 5));
        System.out.println(oneTwo("abcdefge"));
    }
}
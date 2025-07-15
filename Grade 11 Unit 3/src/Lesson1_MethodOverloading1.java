// Method Overloading

// The name of a method can be reused as long as the parameters are different
// This is useful for methods where their functionalities are identical/similar

// For this example, we''ll create 4 different methods, all of which are called
// 'max'. The method returns the maximum between some numbers
public class Lesson1_MethodOverloading1 {
    public static int max(int x, int y){
        if (x>y) {
            return x;
        }
        return y;
    }
    public static double max(double x, double y){
        if (x>y){
            return x;
        }
        return y;
    }

    public static int max(int x, int y, int z){
        return max(z, max(x,y));
    }


    public static double max(double x, double y, double z){
        if (x>y && x>z){
            return x;
        }
        else if (y>z && y>z) {
            return y;
        }
        return z;
    }

    public static void main(String[] args) {
        System.out.println(max(5,9));
        System.out.println(max(4.5, 9));
        System.out.println(max(5, 4, 12));
    }
}

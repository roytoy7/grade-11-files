public class Lesson2_MethodOverloading2 {
    public static int random(int x, int y){
        if (x>y){
            return x+y;
        }
        return x-y;
    }

    public static double random(double x, int y){
        if (x>y) return x*y;
        return 2*x;
    }

    public static int random(int x, double y){
        if (x>y) return (int)(2*y);
        return x;
    }

    /*
     public static double random(int x, int y){ // Already 2 integer methods, so it won't work
        if (x==y) return 0.0;
        return y/x;
    }
    You cannot have two methods that share the same
    1) number of parameters &&
    2) Same parameter types
    as this will create a conflict when the method is being called

    */

    public static int m1(int a, int b){
        for(int c=a+b;c>=0;){
            System.out.println(c);
            a-=2;
            b-=2;
            c-=a+b;
        }
        return a;
    }
    public static int m2(int a, int b){
        for(int c=0;c<=a+b;c++){
            a-=3;
            b-=2;
            c+=a+b;
            System.out.println(c);
        }
        return a;
    }
    public static int m3(int a, int b){
        if (b%a==1){
            return 2 + m1(a+1, b+1);
        }
        return 2*m2(b-1, a-1);
    }
    public static void main(String[] args){
        int a=13;
        int b=2;
        System.out.println(m3(a, b));
        System.out.println(m3(b, a));
        System.out.println("1232adqw3".toUpperCase());
    }
}

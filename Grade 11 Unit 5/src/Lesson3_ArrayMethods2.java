public class Lesson3_ArrayMethods2 {
    // Question 1:
    // Write a method called genArr which takes an integer parameter, n
    // The method returns an integer array that ranges from 1 to n

    public static int[] genArr(int n){
        // Variables
        if (n<=0) n=0;
        int[] kailyn = new int[n];

        for (int i=0; i<kailyn.length;i++){
            kailyn[i] = i+1;
        }
        return kailyn;
    }

    // Question 2:
    // Write a method also called genArr which takes two int para, start and end
    // The method returns an array that ranges

    public static int[] genArr(int start, int end){
        if (end>start) end = start-1;
        int kailyn[] = new int[end-start+1];

        for (int i=0; i<kailyn.length;i++){
            kailyn[i] = start + i;
        }
        return kailyn;
    }

    public static void main (String[] args){
        int [] numbers = genArr(1, 0);
        for (int i=0; i<numbers.length;i++){
            System.out.println(numbers[i]);
        }
    }

}

public class Lesson4_ArrayMethods3 {

    // Write a method called plusOne which takes an integer array, numbers
    // The method will return an integer array which shares the same size as numbers
    // with all the elements increased by one

    //plusOne({4, 5, 6, 2}) -> ({5, 6, 7, 3})

    public static int[] plusOne(int[] numbers){
        int[] kailyn = new int[numbers.length];
        for(int i=0; i<kailyn.length;i++){
            kailyn[i] = numbers[i]+1;
        }
        return kailyn;
    }

    // Write a method called extendArray
    // which takes an integer array and number, intArr and n
    // The method returns a new integer array with the element 'n' added to the back
    public static int[] extendArray(int[] intArr, int n){
        // Step 1) Declare a new array whose size is one more than the original array
        // Step 2) Make a for loop to copy over the data from the original to the new array
        // Step 3) Assign the last value of the array as the new number
        // Step 4) return the array
        int[] array = new int[intArr.length+1];

        for (int i=0; i<intArr.length;i++){
            array[i] = intArr[i];
        }
        array[array.length-1] = n;
        return array;
    }

    // extendArray({1, 4, 5, 9}, 5) -> {1, 4, 5, 9, 5}
    public static void main (String[] args){
        int[] meow = {1, 2, 45, 33, 1};
        meow = extendArray(meow, 9); // make sure to override it
        int[] ding = plusOne(meow);

        for (int i=0; i<ding.length;i++){
            System.out.println(ding[i]);
        }
    }


}

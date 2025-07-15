public class testing {
    public static int[][] extendArray(int[][] original, int[] newcoords){
        int[][] newArr = new int[original.length+1][2];
        for (int i=0;i<newArr.length-1;i++){
            newArr[i] = original[i];
        }
        System.out.println();
        newArr[newArr.length-1] = newcoords;
        return newArr;
    }
    public static int[] coord = {0, 200};
    public static int[][] unBlockCords = {{520, 354}, {572, 354}, {624, 354},
            {572, 306}, {624, 306}, {624, 258}, {1041, 354}, {1093, 354}, {1145, 354},
            {1093, 306}, {572, 0}, {572, 48}, {1610, 354}, {1662, 354}, {1662, 306},
            {1093, 0}, {1093, 48}};

    public static void main(String[] args){
        for (int i=0;i<9;i++){
            System.out.print("{" + (50*i+1722) + ", 135}, ");
        }
    }
}

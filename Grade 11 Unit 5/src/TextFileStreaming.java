import java.io.*;
import java.util.Scanner;
public class TextFileStreaming {
    public static int[] extendArray(int[] original, int added){
        int[] kailyn = new int[original.length+1];
        for (int i=0; i<original.length;i++){
            kailyn[i] = original[i];
        }
        kailyn[kailyn.length-1] = added;
        return kailyn;
    }
    public static double[] extendArray(double[] original, double added){
        double[] kailyn = new double[original.length+1];
        for (int i=0; i<original.length;i++){
            kailyn[i] = original[i];
        }
        kailyn[kailyn.length-1] = added;
        return kailyn;
    }
    public static boolean find(int[] array, int ID){
        for (int i=0; i<array.length;i++){
            if (ID == array[i]) return true;
        }
        return false;
    }
    public static int indexOf(int[] array, int ID){
        int i=0;
        for (;i<array.length;i++){
            if (array[i]==ID) return i;
        }
        return i;
    }
    public static void main(String[] args) throws IOException{

        Scanner s = new Scanner(System.in);
        String readFrom;
        System.out.print("Which year are you reading from, Mr.Chow?: ");
        readFrom = s.nextLine();
        Scanner inputFile = new Scanner(new File(readFrom + "_sales_summary.txt"));
        PrintWriter outputFile = new PrintWriter(new FileWriter(readFrom + "_bonus_summary.txt"));
        int empID;
        double salesAmt;
        int[] IDray = {};
        double[] amtray = {};
        double acc = 0; // determines bonus
        int index;
        inputFile.nextLine();
        inputFile.nextLine();

        while (inputFile.hasNextLine()){
            empID = inputFile.nextInt();
            salesAmt = inputFile.nextDouble();
            acc+=salesAmt;
            if (find(IDray, empID)==false) {
                IDray = extendArray(IDray, empID);
                amtray = extendArray(amtray, salesAmt);
            }
            else {
                index = indexOf(IDray, empID);
                amtray[index] += salesAmt;
            }




        }

        outputFile.printf("%-15s%11s%14s%n", "Employee ID", "Sales Total", "Bonus Total");
        outputFile.println("****************************************");

        for (int i =0; i<IDray.length;i++){
            outputFile.printf("%-15d%11.2f%14.2f%n", IDray[i], amtray[i], amtray[i]*0.05);
        }
        outputFile.println("****************************************");
        outputFile.printf("Number of employees: %d%n", IDray.length);
        outputFile.printf("Sales Total: %.2f%n", acc);
        outputFile.printf("Sales Total: %.2f%n", acc*0.05);
        outputFile.close();
        inputFile.close();
        System.out.println("KALINYkailyn ding");
    }

}

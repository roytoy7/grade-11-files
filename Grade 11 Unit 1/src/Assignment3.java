import java.util.Scanner;

public class Assignment3 {
    public static void main(String[] args){
        Scanner myObj = new Scanner(System.in);
        //prints beginning
        System.out.println("><><><><><><><><><><><><><><><><><><><><><><><><><");
        System.out.printf("%36s", "Chow Chow Fruit Center");
        System.out.println("\n><><><><><><><><><><><><><><><><><><><><><><><><><");

        //reads inputs
        System.out.print("\nNumber of apples purchased: ");
        int apples = myObj.nextInt();
        System.out.print("Number of oranges purchased: ");
        int oranges = myObj.nextInt();
        System.out.print("Amount of lychees purchased: ");
        double lychees = myObj.nextDouble();
        System.out.print("Amount of blueberries purchased: ");
        double blueberries = myObj.nextDouble();

        //receipt
        System.out.println("\n----------------------Receipt---------------------");
        System.out.printf("\n%-32s%8s%10s", "Description", "Quantity", "Price");
        System.out.printf("\n%-32s%8d%10.2f", "Apples @ $0.83/each", apples, apples * 0.83);
        System.out.printf("\n%-32s%8d%10.2f", "Oranges @ $0.75/each", oranges, oranges * 0.75);
        System.out.printf("\n%-32s%8.2f%10.2f", "Lychees @ $2.49/lbs", lychees, lychees * 2.49);
        System.out.printf("\n%-32s%8.2f%10.2f", "Blueberries @ $1.42/lbs", blueberries, blueberries * 1.42);

        double total = apples*0.83 + oranges*0.75 + lychees*2.49 + blueberries*1.42;
        System.out.printf("\n\n%40s%10.2f", "Subtotal", total);
        System.out.printf("\n%40s%10.2f", "H.S.T. (13%)", total * 0.13);
        System.out.printf("\n\n%40s%10.2f", "Net Total", total * 1.13);
        System.out.print("\n\n-------THANK YOU FOR SHOPPING WITH US TODAY!------");

    }


}

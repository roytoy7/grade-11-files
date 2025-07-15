import java.util.Scanner;
import java.io.*;
public class CIPHER {
    public static void main(String[] args) throws IOException{

        System.out.println("Welcome to Kailyn Ding's Cipher!!!");
        // variables
        Scanner s = new Scanner(System.in);
        String choice;
        String readFrom;
        String outputTo;
        String line;
        String originalLine = "AEIJOPRSTVX ";
        String subLine = "@=!?*#&$+^%_";


        while (true) {
            System.out.println("Would you like to encrypt or decrypt a file? ");
            choice = s.nextLine();

            System.out.println("Type the name of the text file you would like to read from: ");
            readFrom = s.nextLine();
            Scanner inputFile = new Scanner(new File(readFrom));
            //Scanner inputFile = new Scanner(new File("poem.txt"));

            System.out.println("Type the name of the text file you would like to output to: ");
            outputTo = s.nextLine();
            PrintWriter outputFile = new PrintWriter(new FileWriter(outputTo));
            while (inputFile.hasNextLine()){
                String newLine = "";
                String lastLine = "";
                //encryption
                if (choice.toLowerCase().equals("encrypt")){
                    // step 1
                    line = inputFile.nextLine().toUpperCase();

                    // step 2

                    for (int i=0; i<line.length(); i++){
                        if (originalLine.indexOf(line.charAt(i))!=-1) {
                            newLine += subLine.charAt(originalLine.indexOf(line.charAt(i)));
                        }
                        else {
                            newLine += line.charAt(i);
                        }
                    }


                    // step 3
                    if (newLine.length()%2==0){
                        newLine = newLine.substring(newLine.length()/2) + newLine.substring(0, newLine.length()/2);
                    }
                    else {
                        newLine = newLine.substring(newLine.length()/2+1) + newLine.substring(0, newLine.length()/2+1);
                    }

                    // step 4
                    newLine = newLine.substring(newLine.length()-2) + newLine.substring(2, newLine.length()-2) + newLine.substring(0, 2);

                    // step 5

                    if (newLine.length()%2==0){
                        newLine = newLine.substring(0, newLine.length()/2-2) + newLine.substring(newLine.length()/2, newLine.length()/2+2)
                                + newLine.substring(newLine.length()/2-2, newLine.length()/2) + newLine.substring(newLine.length()/2+2);
                    }
                    else {
                        newLine = newLine.substring(0, newLine.length()/2-1) + newLine.substring(newLine.length()/2+1, newLine.length()/2+3)
                                + newLine.substring(newLine.length()/2-1, newLine.length()/2+1) + newLine.substring(newLine.length()/2+3);
                    }

                    // step 6

                    for (int i=0; i<newLine.length()-1; i+=2){
                        lastLine += newLine.charAt(i+1);
                        lastLine += newLine.charAt(i);
                    }
                    if (newLine.length()%2==1) lastLine += newLine.charAt(newLine.length()-1);

                    outputFile.println(lastLine);
                }

                //decryption
                else if (choice.toLowerCase().equals("decrypt")){
                    line = inputFile.nextLine();

                    // step 6 reversed
                    for (int i=0; i<line.length()-1; i+=2){
                        newLine += line.charAt(i+1);
                        newLine += line.charAt(i);
                    }
                    if (line.length()%2==1) newLine += line.charAt(line.length()-1);



                    // step 5 reversed
                    if (newLine.length()%2==0){
                        newLine = newLine.substring(0, newLine.length()/2-2) + newLine.substring(newLine.length()/2, newLine.length()/2+2)
                                + newLine.substring(newLine.length()/2-2, newLine.length()/2) + newLine.substring(newLine.length()/2+2);
                    }
                    else {
                        newLine = newLine.substring(0, newLine.length()/2-1) + newLine.substring(newLine.length()/2+1, newLine.length()/2+3)
                                + newLine.substring(newLine.length()/2-1, newLine.length()/2+1) + newLine.substring(newLine.length()/2+3);
                    }


                    // step 4 reversed
                    newLine = newLine.substring(newLine.length()-2) + newLine.substring(2, newLine.length()-2) + newLine.substring(0, 2);


                    // step 3 reversed
                    if (newLine.length()%2==0){
                        newLine = newLine.substring(newLine.length()/2) + newLine.substring(0, newLine.length()/2);
                    }
                    else {
                        newLine = newLine.substring(newLine.length()/2) + newLine.substring(0, newLine.length()/2);
                    }


                    // step 2 reversed
                    for (int i=0; i<newLine.length(); i++){
                        if (subLine.indexOf(newLine.charAt(i))!=-1) {
                            lastLine += originalLine.charAt(subLine.indexOf(newLine.charAt(i)));
                        }
                        else {
                            lastLine += newLine.charAt(i);
                        }
                    }

                    // step 1 reversed and print
                    outputFile.println(lastLine.toLowerCase());

                }

            }
            inputFile.close();
            outputFile.close();
            System.out.println("KAILYN DING'S CODE IS DONE???????");

            System.out.println("Would you like to keep going? (type yes or no)");
            if (s.nextLine().toLowerCase().equals("no")){
                break;
            }


        }

    }

}

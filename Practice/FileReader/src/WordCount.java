import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCount
{
    public static void main(String [] args) throws Exception {
        try{
            File myFile = new File("98-0.txt");

            Scanner myScanner = new Scanner(myFile);
            int numOfWords = 0;
            String line;
            while(myScanner.hasNextLine()){
                line = myScanner.nextLine();

                numOfWords +=line.split(" ").length;
            }
            System.out.println("there are " + numOfWords+" words");

        }catch (FileNotFoundException e){
            System.out.println("File is missing");

        }




    }
}


import javax.swing.text.html.HTMLDocument;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Simulation
{

    private Scanner myScanner;


    ArrayList<Item> loadItems(File inputFile)
    {
        ArrayList<Item> myList = new ArrayList<>();
        try
        {
            String temp;
            String name;
            int weight;
            int postionOfEqualSign;
            myScanner = new Scanner(inputFile);
            while(myScanner.hasNextLine())
            {
                temp = myScanner.nextLine();
                postionOfEqualSign=temp.indexOf('=');
                name = temp.substring(0,postionOfEqualSign);
                weight = Integer.parseInt(temp.substring(postionOfEqualSign+1));
                Item myItem = new Item(name,weight);
                myList.add(myItem);
            }
        } catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }
        return myList;
    }

    ArrayList<Rocket> loadU1(ArrayList<Item> inputAL)
    {
        ArrayList<Rocket> u1List = new ArrayList<>();
        U1 u1Temp = new U1();


        for (Item tempItem :
                inputAL)
        {

            if(u1Temp.canCarry(tempItem))
            {
                u1Temp.carry(tempItem);
            }else{

                u1Temp.updateCrashChance(0.01);
                u1Temp.updateExplosionChance(0.05);
//                System.out.println("u1 crash chance is "+u1Temp.getCrashChance()+
//                        " exposion chance is "+u1Temp.getExplosionChance());
                u1List.add(u1Temp);
                u1Temp = new U1();
                u1Temp.carry(tempItem);

            }
        }

        return u1List;
    }

    ArrayList<Rocket> loadU2(ArrayList<Item> inputAL)
    {
        ArrayList<Rocket> u2List = new ArrayList<>();
        U2 u2Temp = new U2();


        for (Item tempItem :
                inputAL)
        {

            if(u2Temp.canCarry(tempItem))
            {
                u2Temp.carry(tempItem);
            }else{
                u2Temp.updateCrashChance(0.08);
                u2Temp.updateExplosionChance(0.04);
//                System.out.println("u2 crash chance is "+u2Temp.getCrashChance()+
//                        " exposion chance is "+u2Temp.getExplosionChance());
                u2List.add(u2Temp);
                u2Temp = new U2();
                u2Temp.carry(tempItem);

            }
        }

        return u2List;
    }

    int runSimulation (ArrayList<Rocket> inputAL)
    {
        int count = 0;
        int totalBudget = 0;
        boolean land, launch;

        for (Rocket tempRocket :
                inputAL)
        {
            land = tempRocket.land();
            launch = tempRocket.launch();

            while(land == false ||
                    launch == false)
            {
                land = tempRocket.land();
                launch = tempRocket.launch();
                System.out.println("Rocket mission failed -> resend rocket");
                totalBudget = totalBudget + tempRocket.getCost();
                count++;
            }
            System.out.println("Rocket mission success");
            totalBudget += tempRocket.getCost();
            count++;

        }

        System.out.println(count+" of rockets has been send");

        return totalBudget;
    }

}

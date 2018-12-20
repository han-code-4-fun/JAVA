import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main
{

    public static void main(String[] args) throws IOException
    {



        Simulation mySimulator = new Simulation();

        File parse1 = new File(Paths.get("phase-1.txt").toString());


        ArrayList<Item> myList1 = mySimulator.loadItems(parse1);


        ArrayList<Rocket> u1Rockets = mySimulator.loadU1(myList1);
        ArrayList<Rocket> u2Rockets = mySimulator.loadU2(myList1);

        int budgetU1 = mySimulator.runSimulation(u1Rockets);
        int budgetU2 = mySimulator.runSimulation(u2Rockets);

        System.out.println("\nPhase one cost:");
        System.out.println("total budget of u1 is $"+ budgetU1 + " million");
        System.out.println("total budget of u2 is $"+ budgetU2 + " million\n");

        File parse2 = new File(Paths.get("phase-2.txt").toString());
        ArrayList<Item> myList2 = mySimulator.loadItems(parse2);

        ArrayList<Rocket> u1Rocketsp2 = mySimulator.loadU1(myList2);
        ArrayList<Rocket> u2Rocketsp2 = mySimulator.loadU2(myList2);

        int budgetU1p2 = mySimulator.runSimulation(u1Rocketsp2);
        int budgetU2p2 = mySimulator.runSimulation(u2Rocketsp2);

        System.out.println("\nPhase two cost:");
        System.out.println("total budget of u1 is $"+ budgetU1p2 + " million");
        System.out.println("total budget of u2 is $"+ budgetU2p2 + " million");

        System.out.println("together u1 cost "+ (budgetU1+budgetU1p2)+
                "\nand u2 cost "+(budgetU2p2+budgetU2));
    }
}

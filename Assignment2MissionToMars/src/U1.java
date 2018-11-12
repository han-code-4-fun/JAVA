import java.util.Random;

public class U1 extends Rocket
{

//    int cost = 100;
//    int selfWeight = 10;
//    int maxWeight = 18;
//    Chance of launch explosion = 5% * (cargo carried / cargo limit)
//    Chance of landing crash = 1% * (cargo carried / cargo limit)



    U1()
    {
        this.setCost(100);
        this.setCurrentWeight(10000);
        this.setMaxWeight(18000);
        this.updateExplosionChance(0.05);
        this.updateCrashChance(0.01);
        myRan = new Random();
    }

    public boolean land()
    {

        double temp;

        temp = myRan.nextDouble();

        this.updateCrashChance(0.01);
        if(temp <= this.getCrashChance())
            return false;
        else
            return true;



    }


    public boolean launch()
    {

        double temp;

        temp = myRan.nextDouble();
        this.updateExplosionChance(0.05);
        if(temp <= this.getExplosionChance())
            return false;
        else
            return true;
    }
}

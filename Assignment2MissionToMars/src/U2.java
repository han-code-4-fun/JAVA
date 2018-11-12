import java.util.Random;

public class U2 extends Rocket
{
    /*
        Rocket cost = $120 Million
        Rocket weight = 18 Tonnes
        Max weight (with cargo) = 29 Tonnes
        Chance of launch explosion = 4% * (cargo carried / cargo limit)
        Chance of landing crash = 8% * (cargo carried / cargo limit)
     */
    U2()
    {
        this.setCost(120);
        this.setCurrentWeight(18000);
        this.setMaxWeight(29000);
        myRan = new Random();
        this.updateExplosionChance(0.04);
        this.updateCrashChance(0.08);
    }

    public boolean land()
    {

        double temp;

        temp = myRan.nextDouble();
        this.updateCrashChance(0.08);
        if(temp <= this.getCrashChance())
            return false;
        else
            return true;



    }


    public boolean launch()
    {

        double temp;

        temp = myRan.nextDouble();
        this.updateExplosionChance(0.04);
        if(temp <= this.getExplosionChance())
            return false;
        else
            return true;
    }
}

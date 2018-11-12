import java.util.Random;

public class Rocket implements SpaceShip
{


    private int cost;
    private double currentWeight;
    private double maxWeight;
    private double explosionChance;
    private double crashChance;

    Random myRan;

    public int getCost()
    {
        return cost;
    }

    public void setCost(int cost)
    {
        this.cost = cost;
    }


    public void setCurrentWeight(int currentWeight)
    {
        this.currentWeight = currentWeight;
    }


    public void setMaxWeight(int maxWeight)
    {
        this.maxWeight = maxWeight;
    }
    public void updateExplosionChance(double explosionChance)
    {
        this.explosionChance = explosionChance * (currentWeight/maxWeight);
    }

    public void updateCrashChance(double crashChance)
    {
        this.crashChance = crashChance * (currentWeight/maxWeight);
    }

    public double getExplosionChance()
    {
        this.explosionChance = 0.05 * currentWeight/maxWeight;
        return explosionChance;
    }

    public double getCrashChance()
    {
        return crashChance;
    }




    @Override
    public boolean launch()
    {
        return true;
    }

    @Override
    public boolean land()
    {
        return true;
    }

    @Override
    public boolean canCarry(Item inputItem)
    {
        if(inputItem.weight + currentWeight > maxWeight)
        {
            return false;
        }else
        {
            return true;
        }

    }

    @Override
    public void carry(Item inputItem)
    {
        currentWeight = currentWeight + inputItem.weight;

    }
}

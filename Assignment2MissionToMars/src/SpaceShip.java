public interface SpaceShip
{
    boolean launch();
    boolean land();
    boolean canCarry(Item inputItem);
    void carry(Item inputItem);
}

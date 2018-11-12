public class Run
{
    public static void main(String[] args)
    {
        final double PI = 3.14;
        LivingRoom myLivingRoom = new LivingRoom(5,3);
        double area = myLivingRoom.getArea();
        System.out.println(area);

        //PI = 23;//cannot change constant
        System.out.println(PI);
    }
}

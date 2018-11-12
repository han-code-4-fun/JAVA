public class Run
{
    public static void main(String[] args) {
        House myHouse = new House(5,1169);
        System.out.println("room number is "+myHouse.room+
                " and we have "+House.numberOfInstance+ " houses");
        House anotherHouse = new House(3,112);
        System.out.println("room number is "+anotherHouse.room+
                " and we have "+House.numberOfInstance+ " houses");
        anotherHouse.room = 2;
        myHouse.room = 32;
        System.out.println(myHouse.room);
        System.out.println(anotherHouse.room);

        System.out.println("area is " + House.area);

        System.out.println("area of myHouse is " + myHouse.area);

        anotherHouse.area = 999;
        if(House.area == 999)
        {
            System.out.println("changed class instance of static field will affect all");
            System.out.println(myHouse.area);
        }else
        {
            System.out.println("Only changed the value inside the instance anotherHouse");
        }
    }
}

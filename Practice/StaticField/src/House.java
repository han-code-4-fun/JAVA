public class House
{
    static int numberOfInstance;

    int room;

    int streetNum;

    static int area = 600;

    House(int roomNum, int streetNum)
    {
        room = roomNum;
        this.streetNum = streetNum;
        numberOfInstance++;
    }

}

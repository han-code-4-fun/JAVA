public class Room
{
    private double width;
    private double height;
    public Room(double width, double height){
        this.width = width;
        this.height =height;
    }
    public final double getArea(){
        return width*height;
    }
//    public Room(){
//
//    };

}

import java.util.ArrayList;

public class Run {
    public static void main(String[] args) {
        ContainerNum<Integer> myIntContainer = new ContainerNum<>();
        //Container<Integer> myIntContainer = new Container<Integer>();//same calling method

        myIntContainer.setValue(55);

        myIntContainer.showType();

        Container<Student> myStuContainer = new Container<>();

        //myStuContainer.setValue(55);

        myIntContainer.canUseSuperClass(new ArrayList<Number>());




    }

}

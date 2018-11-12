import java.util.ArrayList;

public class ContainerNum<T extends Number>
{//only accept number types
    T value;

    public T getValue()
    {
        return value;
    }

    public void setValue(T input){
        value = input;
    }

    public void showType(){
        System.out.println(value.getClass().getName());
    }

    public void canUseSuperClass(ArrayList<? super T>inputList)
    {
        //do something

    }

}

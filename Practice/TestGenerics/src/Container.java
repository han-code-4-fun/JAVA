public class Container<T>
{
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
    public void test(){}

}



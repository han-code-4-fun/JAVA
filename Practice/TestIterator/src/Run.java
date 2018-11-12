import java.util.*;

public class Run
{
    public static void main(String[] args) {
        ArrayList al = new ArrayList();


        al.add("C");
        al.add("A");
        al.add("E");
        al.add("B");
        al.add("D");
        al.add("F");

        Iterator iterator = al.iterator();

        System.out.println(iterator.next());//the pointer is saved in Iterator

        while(iterator.hasNext()){
            System.out.print(iterator.next()+" + ");
        }
        System.out.println();

        //this cause error because this Iterator has pointed to the last element+1
        //System.out.println(iterator.next());
        iterator = al.iterator();//reset iterator
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        //a more powerful iterator
        ListIterator listIterator = al.listIterator();

        System.out.println("The index of first element is "
                +listIterator.nextIndex()+ " and it's not incremented");

        System.out.println();

        while (listIterator.hasNext()){

            System.out.print(listIterator.nextIndex()+" ");
            //must use .next() otherwise it's infinite loop print out '0'
            listIterator.next();
        }

        System.out.println();


        listIterator = al.listIterator();
        while(listIterator.hasNext()){
            System.out.print(listIterator.next()+ "  ");
        }

        System.out.println("\nno reset, print backwards");
        while(listIterator.hasPrevious()){
            System.out.print(listIterator.previous() + "  ");
        }


    }
}

/*
This interface includes a single method definition called compareTo which takes an object as an input parameter of the same type and compares both objects ("this" object against the input argument object).

The main purpose of this interface is to give any class a chance to describe how to compare 2 objects of that class against each other. This will be really handy when we get to sorting or searching for such objects of that type.

For example:

Assume you have a class that represents a book:

public class Book{
   int numberOfPages;
   String title;
   String author;
}
And you are asked to implement the Comparable Interface so that you can sort the books according to the following criteria:

If a book has more pages than the other, then the book with the more pages goes first.
If both books have the same number of pages, then sort by the title alphabetically.
If both books have the same number of pages and the same title, then sort by the author alphabetically.
Before we start coding, let’s go through how the compareTo method should work:

The compareTo method takes a single input parameter (let's refer to it as the "specified object") and since this method belongs to an object itself (let's refer to it as "this object"), then the method simply compares the "specified" object against "this" object.

According to the documentation, there are 3 possible outcomes when comparing any 2 objects:

"This" object is considered less than the "specified" object
"This" object is considered equal to the "specified" object
"This" object is considered greater than the "specified" object
Respectively, for each of those cases, compareTo method should return:

A negative integer (any number less than 0)
zero (0)
A positive integer (any number greater than 0)
 */



public class Book implements Comparable<Book>
{
    int numberOfPages;
    String title;
    String author;

    public int compareTo(Book specifiedBook){

        if(this.numberOfPages != specifiedBook.numberOfPages)
        {
            return this.numberOfPages - specifiedBook.numberOfPages;
        }

        if(this.title.equals(specifiedBook.title) == false)
        {
            return this.title.compareTo(specifiedBook.title);
        }

        return this.author.compareTo(specifiedBook.author);
    }
}

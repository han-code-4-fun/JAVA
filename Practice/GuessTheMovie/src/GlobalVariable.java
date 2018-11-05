import java.util.Scanner;

import static java.lang.System.in;

public class GlobalVariable {


    Movies movies;
    String selectedMovie ;
    int life;
    char[] moviesToCharArray;
    char[] rightGuessing;
    char[] wrongGuessing ;
    Scanner myInput ;
    char inputLetter;
    boolean guessResult;
    boolean match;

    public GlobalVariable(Game myGame){
        movies = new Movies();


        selectedMovie = myGame.PickAMovie(movies.getMovies());


        life = 10;
        moviesToCharArray = selectedMovie.toCharArray();
        rightGuessing = new char[moviesToCharArray.length];
        wrongGuessing = new char[life];
        myInput = new Scanner(in);
        guessResult = false;
        match = false;

    }


}

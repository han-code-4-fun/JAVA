import java.util.Scanner;

import static java.lang.System.in;

public class GlobalVariable {


    Movies movies;
    String selectedMovie ;
    int life;
    char[] moviesInCharArray;

    //save users right guess char into an array
    char[] rightGuessCharArray;

    //save users wrong guess char into an array
    char[] wrongGuessCharArray;
    Scanner myInput ;
    char inputLetter;
    boolean guessResultThisTime;
    boolean win;

    public GlobalVariable(Game myGame){
        movies = new Movies();


        selectedMovie = myGame.PickAMovie(movies.getMovies());


        life = 10;
        moviesInCharArray = selectedMovie.toCharArray();

        //set length of both arrays
        rightGuessCharArray = new char[moviesInCharArray.length];
        wrongGuessCharArray = new char[life];

        myInput = new Scanner(in);

        guessResultThisTime = false;
        win = false;

    }


}

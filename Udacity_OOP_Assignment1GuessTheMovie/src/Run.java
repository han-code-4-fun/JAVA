import static java.lang.System.out;

import java.util.Arrays;


public class Run {


    public static void main(String[] args) {
        Game myGame = new Game();

        GlobalVariable g = new GlobalVariable(myGame);

        do {
            //print status before each turn
            out.print("You are guessing:");
            myGame.PrintRightGuess(g.rightGuessCharArray);

            out.print("You have guessed (" +
                    myGame.wrongGuessingNum(g.wrongGuessCharArray) +
                    ") wrong letters: ");
            myGame.PrintWrongGuess(g.wrongGuessCharArray);

            out.print("Guess a letter:");

            //take user input
            myGame.userInputHandler(g);

            g.guessResultThisTime = myGame.MatchUserInputToMovie(
                    g.inputLetter,
                    g.moviesInCharArray,
                    g.rightGuessCharArray,
                    g.wrongGuessCharArray,
                    g.life
            );

            if (g.guessResultThisTime == false) {
                //wrong guess results less times to try
                g.life -= 1;
            }

            if (Arrays.equals(g.rightGuessCharArray, g.moviesInCharArray)) {
                 g.win = true;
            }


        } while (g.life > 0 && g.win == false);

        if (g.win == true) {
            out.println("You Win! \n You have guessed '" + g.selectedMovie + "' correctly");
        } else {
            out.println("You lose");
        }

    }


}

import static java.lang.System.out;

import java.util.Arrays;


public class Run {


    public static void main(String[] args) {
        Game myGame = new Game();

        GlobalVariable gv = new GlobalVariable(myGame);

        do {
            out.print("You are guessing:");
            myGame.PrintRightGuess(gv.rightGuessing);

            out.print("You have guessed (" + myGame.numberOfValidCharArray(gv.wrongGuessing) +
                    ") wrong letters: ");
            myGame.PrintWrongGuess(gv.wrongGuessing);

            out.print("Guess a letter:");

            if (gv.myInput.hasNextLine()) {
                String temp = gv.myInput.nextLine();
                while (temp.length() > 1) {
                    out.println("Please enter a letter");
                    temp = gv.myInput.nextLine();
                }
                gv.inputLetter = temp.charAt(0);

                gv.guessResult = myGame.MatchGuessInputToPickedMovie(
                        gv.inputLetter,
                        gv.moviesToCharArray,
                        gv.rightGuessing,
                        gv.wrongGuessing,
                        gv.life
                );

            }

            if (gv.guessResult == false) {
                gv.life -= 1;
            }

            if (Arrays.equals(gv.rightGuessing, gv.moviesToCharArray)) {

                gv.match = true;
            }


        } while (gv.life > 0 && gv.match == false);

        if (gv.life > 0) {
            out.println("You Win! \n You have guessed '" + gv.selectedMovie + "' correctly");
        } else {
            out.println("You lose");
        }

    }


}

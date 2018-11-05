import static java.lang.System.out;

public class Game {

    public String PickAMovie(String movies[])

    {
        return movies[(int) (Math.random() * movies.length)];
    }

    public  void PrintRightGuess(char[] rightGuess) {
        for (int i = 0; i < rightGuess.length; i++) {
            if (rightGuess[i] == 0) {
                out.print("_");
            } else {
                out.print(rightGuess[i]);
            }
        }
        out.println();
    }

    public  void PrintWrongGuess(char[] wrongGuessing) {
        for (int i = 0; i < wrongGuessing.length; i++) {
            out.print(wrongGuessing[i] + " ");
        }
        out.println();
    }

    public  boolean MatchGuessInputToPickedMovie(char letter,
            char[] movieChar, char[] rightGuess, char[] wrongGuess, int life) {
        boolean find = false;


        for (int i = 0; i < movieChar.length; i++) {

            if (letter == movieChar[i]) {
                find = true;
                rightGuess[i] = movieChar[i];

            }

        }

        if (find == false) {
            wrongGuess[10 - life] = letter;

        }
        return find;
    }



    public  int numberOfValidCharArray(char[] inputArray) {
        int output = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] != 0) {
                output++;
            }
        }
        return output;
    }
}

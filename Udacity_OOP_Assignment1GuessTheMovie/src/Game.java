import static java.lang.System.out;

public class Game {

    // randomly select a movie for this game
    public String PickAMovie(String movies[])

    {
        return movies[(int) (Math.random() * movies.length)];
    }



    // print '_' for each letter in the selected movie except
    // if any letter was guessed right by user,
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

    //print users' incorrect guessing
    public  void PrintWrongGuess(char[] wrongGuessing) {
        for (int i = 0; i < wrongGuessing.length; i++) {
            out.print(wrongGuessing[i] + " ");
        }
        out.println();
    }

    //match user input with movie name, if matches, save
    //user input into rightGuess array, otherwise save to
    //wrongGuess array
    public  boolean MatchUserInputToMovie(char letter,
                                          char[] movieChar,
                                          char[] rightGuess,
                                          char[] wrongGuess,
                                          int life) {
        boolean find = false;
        //must complete for loop before return as a
        // char may appear multiple times in movie name
        for (int i = 0; i < movieChar.length; i++) {

            if (letter == movieChar[i]) {
                find = true;
                rightGuess[i] = letter;
            }
        }

        if (find == false) {
            wrongGuess[10 - life] = letter;
        }

        return find;
    }


    //count the number of times of user's wrong guessing
    public  int wrongGuessingNum(char[] inputArray) {
        int output = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] != 0) {
                output++;
            }
        }
        return output;
    }


    //handle user input, force user enter a char
    public void userInputHandler(GlobalVariable g)
    {

        if (g.myInput.hasNextLine()) {
            String temp = g.myInput.nextLine();
            //limit user input to a char
            while (temp.length() > 1 || temp.isEmpty()) {
                out.println("Please enter a letter");
                temp = g.myInput.nextLine();
            }
            g.inputLetter = temp.charAt(0);

        }
    }
}

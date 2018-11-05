import java.util.Scanner;

public class Run {
    public static void main(String[] args) {

            GuessNumberGame firstPlay = new GuessNumberGame();

            firstPlay.Guess();

    }
}


class GuessNumberGame {
    private int currentNumber;
    private Scanner myScanner;
    private int chanceToGuess;
    private int myGuess;

    public GuessNumberGame(){
        currentNumber = (int)(Math.random()*100+1);
        myScanner = new Scanner(System.in);
        chanceToGuess = 10;

    }

    public void Guess()
    {
        do{
            System.out.println("Please enter a number between 1 and 100");
            myGuess = myScanner.nextInt();
            if( myGuess> currentNumber)
            {
                System.out.println("It's bigger than the random number");
//                print();

            }
            if (myGuess < currentNumber)
            {
                System.out.println("It's smaller than the random number");
//                print();
            }
            if (myGuess == currentNumber)
            {
                break;
            }
            chanceToGuess--;
        }while(chanceToGuess>0);

        if(chanceToGuess == 0)
        {
            System.out.println("You LOSE");
        }else{
            System.out.println("You WIN");
        }



    }
    public void print(){
        System.out.println(currentNumber);
    }


}
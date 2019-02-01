/*
* A variation of the dice game Pig

Create a program that will randomly select two numbers from 1-6 (like rolling two dice). Show the dice rolls. You should also show the running score.


Prompt the user to either roll again or lose their turn.

A player scores the sum of the two dice thrown and gradually reaches a higher score as they continue to roll. If a single number 1 is thrown on either die, the score for that whole turn is lost. However a double 1 counts as 25.
When you reach a score of 100 (or more) the game ends.

See the example output below.*/
import java.util.Random;
import java.util.Scanner;

public class DiceGamePig {

    public static void main(String[]args){
        showWelcomeMessage();

        int a;
        int b;
        int score = 0;

        while (true){
            // Roll dice and save numbers
            a = rollDice();
            b = rollDice();
            System.out.println("Your rolls " + a + " & " + b);

            // Calculate score
            score += calculateScore(a, b);

            // Print score
            System.out.println("Score: " + score);

            // Special message when score hits 100
            if (score >= 100){
                System.out.println("You have scored over 100");
                break;
            }

            // Ask if user wants to roll again
            if (playAgain()==false){
                break;
            }

        }

        showExitMessage();
        System.exit(0);
    }


    /*
     * Rolls the dice once and returns a random number between 1 and 6
     */
    public static int rollDice(){
        Random rnd = new Random();
        int num = rnd.nextInt(6) + 1;
        return num;
    }


    /*
    * Calculate and return score
    * if A or B is 1, no pts
    * if A and B are 1, 25 pts
    * else, (A+B) pts*/
    public static int calculateScore(int a, int b){
        if (a==1 || b==1){
            return 0;
        } else if (a==1 && b==1){
            return 25;
        } else {
            return a + b;
        }
     }


    /*
     * Return true if user types "y" to play again
     * Return false if user types "n"*/
    public static boolean playAgain(){
        System.out.println("Roll again? y/n");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
//        input.close();
        if (!str.equalsIgnoreCase("n")){
            return true;
        } else {
            return false;
        }
    }


    public static void showWelcomeMessage(){
        System.out.println("Welcome! Let's Play Roll Dice!");
    }


    public static void showExitMessage(){
        System.out.println("Thank you for playing!");
    }

}

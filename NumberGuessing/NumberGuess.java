package NumberGuess;

import java.util.Random;
import java.util.Scanner;

public class NumberGuess {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        int k = 5; // no of trails
        int playerChoice;
        int computerchoice;
        int flag = 0;

        System.out.println("------------ Game Starts ----------------");
        System.out.println("No. of Trials is "+k);
        System.out.println("Choose Random Number Between 1 and 100");
        System.out.println("=========================================");

        computerchoice = rand.nextInt(100)+1;

        for(int i=0;i<k;i++){
            System.out.println("----------- Enter Numer To Guess --------------");
            playerChoice = sc.nextInt();
            if(playerChoice == computerchoice){
                System.out.println("Congrats! You have chosen Correct number");
                flag = 1;
                break;
            }
            else if(playerChoice > computerchoice){
                System.out.println("Sorry! Wrong Number \n Choosen Number is greater than Acutal Number");
            }
            else{
                System.out.println("Sorry! Wrong Number \n Choosen Number is less than Actual Number");
            }
        }

        if(flag == 1){
            System.out.println(" You WON");
        }
        else{
            System.out.println(" You LOST");
        }
        System.out.println("Computer Generated Random Number is "+computerchoice);
        System.out.println("--------------- Game Finished ----------------");
    }
}

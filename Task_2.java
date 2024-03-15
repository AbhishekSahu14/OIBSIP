import java.util.Random;
import java.util.Scanner;

public class Task_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand= new Random();
        int totalScore=0;
        int maxAttempts=10;
        System.out.println("Enter your name: ");
        String name= sc.nextLine();
        System.out.println("Hello "+name+"! Welcome to the NumberGuessing game.");
        System.out.println("You have maximum "+maxAttempts+" attempts per game. let's start...");
        boolean playagain=true;
        while(playagain){
            int systemNo= rand.nextInt(100)+1;
            boolean guessCorrect=false;
            int attemptsleft = maxAttempts;
            System.out.println("New game started. Guess the no(1-100).: ");
            while (!guessCorrect && attemptsleft>0){
                System.out.println("Enter your no: ");
                int userNo= sc.nextInt();
                if(userNo>1 && userNo<100){
                    if(userNo==systemNo) {
                        guessCorrect = true;
                        System.out.println("YAYYY! You guessed the correct no.");
                    }
                    else if(userNo<systemNo){
                        if(userNo==(systemNo-1)){
                            System.out.println("Too close, guess again...");
                        }
                        else{
                            System.out.println("Too low try again!");
                        }

                    }
                    else{
                        if(userNo==(systemNo+1)){
                            System.out.println("Too close, guess again...");
                        }
                        else{
                            System.out.println("Too high try again.");
                        }
                    }
                }
                else{
                    System.out.println("OOPS Invalid no.");
                }
                attemptsleft--;
            }
            if(!guessCorrect){
                System.out.println("Sorry, you have used all your attempts. The system no was "+systemNo);
            }
            totalScore+=attemptsleft;
            System.out.println("Your score is: "+totalScore);
            System.out.println("Do you want to play again(y/n): ");
            String choice= sc.next();
            playagain=choice.equalsIgnoreCase("y");
        }
        System.out.println("Thank you for playing! Your final score is:"+totalScore);
    }
}

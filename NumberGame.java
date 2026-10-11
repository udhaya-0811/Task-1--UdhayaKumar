import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class NumberGame {
    public static void main(String[] args) {

        Random random = new Random();
        int round = 1;
        int score = 0;
        Scanner scan = new Scanner(System.in);

        while (round <= 3) {

            System.out.println("Round - " + round);

            int targetNumber = random.nextInt(100) + 1;
            int guessCount = 0;
            int userInput = 0;
            boolean validInput = false;

            while (!validInput) {
                try {
                    System.out.print("Enter a number :");
                    userInput = scan.nextInt();
                    validInput = true;
                    guessCount++;

                } catch (InputMismatchException e) {
                    System.out.println("Enter a valid number");
                    scan.nextLine();
                }
            }

            while (userInput != targetNumber && guessCount < 5) {

                if (userInput > targetNumber) {
                    System.out.println("Too High");
                } 
                else if (userInput < targetNumber) {
                    System.out.println("Too Low");
                }

                validInput = false;

                while (!validInput) {
                    try {
                        System.out.println("Enter a number :");
                        userInput = scan.nextInt();
                        validInput = true;
                        guessCount++;

                    } catch (InputMismatchException e) {
                        System.out.println("Enter a valid number");
                        scan.nextLine();
                    }
                }
            }

            if (userInput == targetNumber) {
                System.out.println("Correct!");
                score++;
            } 
            else {
                System.out.println("5 Attempts reached");
            }

            System.out.println("Attempt :" + guessCount);

            round++;
        }

        System.out.println("Game Over");
        System.out.println("Final Score : " + score);
        scan.close();
    }
}
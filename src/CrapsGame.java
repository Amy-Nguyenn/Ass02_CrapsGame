import java.util.Random;
import java.util.Scanner;

public class CrapsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rnd = new Random();
        String playAgain;

        do {
            // Roll two dice
            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int sum = die1 + die2;

            System.out.println("You rolled: " + die1 + " + " + die2 + " = " + sum);

            // Check for win/loss in the initial roll
            if (sum == 7 || sum == 11) {
                System.out.println("You rolled a natural and won!");
            } else if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You lost.");
            } else {
                int point = sum;
                System.out.println("The point is set to: " + point);

                // Roll until the player wins or loses
                boolean keepRolling = true;
                while (keepRolling) {
                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    sum = die1 + die2;
                    System.out.println("You rolled: " + die1 + " + " + die2 + " = " + sum);

                    if (sum == point) {
                        System.out.println("You made your point and won!");
                        keepRolling = false;
                    } else if (sum == 7) {
                        System.out.println("You rolled a 7 and lost.");
                        keepRolling = false;
                    } else {
                        System.out.println("Still trying for the point.");
                    }
                }
            }

            // Ask the user if they want to play again
            System.out.println("Do you want to play again? (yes/no)");
            playAgain = scanner.nextLine();
        } while (playAgain.equalsIgnoreCase("yes"));

        scanner.close();
        System.out.println("Thanks for playing!");
    }
}

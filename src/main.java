import java.util.Scanner;
import java.util.Random;

public class main {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        
        while (playAgain) {
            int point = 0;
            int rollCount = 0;
            
            System.out.println("Welcome to the game of Craps!");
            
            // Initial roll
            int sum = rollDice(random);
            rollCount++;
            System.out.println("Roll #" + rollCount + ": " + sum);
            
            // Check if the game is over
            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You lose.");
                playAgain = askToPlayAgain(input);
                continue;
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You win.");
                playAgain = askToPlayAgain(input);
                continue;
            } else {
                point = sum;
                System.out.println("Point is " + point);
            }
            
            // Subsequent rolls
            while (true) {
                sum = rollDice(random);
                rollCount++;
                System.out.println("Roll #" + rollCount + ": " + sum);
                
                // Check if the game is over
                if (sum == 7) {
                    System.out.println("Got a 7. You lose.");
                    playAgain = askToPlayAgain(input);
                    break;
                } else if (sum == point) {
                    System.out.println("Made point! You win.");
                    playAgain = askToPlayAgain(input);
                    break;
                } else {
                    System.out.println("Trying for point...");
                }
            }
        }
        
        input.close();
    }
    
    private static int rollDice(Random random) {
        int die1 = random.nextInt(6) + 1;
        int die2 = random.nextInt(6) + 1;
        int sum = die1 + die2;
        System.out.println("Dice: " + die1 + ", " + die2 + " = " + sum);
        return sum;
    }
    
    private static boolean askToPlayAgain(Scanner input) {
        System.out.print("Do you want to play again? (y/n) ");
        String answer = input.next();
        return answer.equalsIgnoreCase("y");
    }
}

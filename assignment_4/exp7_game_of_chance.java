// 7. A popular game of chance is a die game know as craps, which is played in casinos and back alley throught the world .the rules of the game are straightforward: You roll two dice. Each die has six faces, which contain one,two,three,four,five and six spots, respectively .after the dice have come to rest ,the sum of the spots on the two upward faces is calculated .if the sum is 7 or 11 on the first throw ,you win .if the sum is 2,3 or 12 on the first throw(called "Craps"),you lose (i.e. the "house" wins). If the sum is 4,5,6,8,9,10 on the first throw, that sum becomes your "points" To win, you must continue rolling the die until you 'make your point'   (i.e. roll that same point value).you lose by rolling a 7 before making your point. Hint use ENUM,switch case.

import java.util.Random;

public class exp7_game_of_chance {
    // Enum to represent the state of the game
    enum Status {
        CONTINUE, WON, LOST
    }

    public static void main(String[] args) {
        Random random = new Random();
        
        int point = 0;
        Status gameStatus;
        
        int firstRoll = rollDice(random);
        
        switch (firstRoll) {
            case 7:
            case 11:
                gameStatus = Status.WON;
                break;
            case 2:
            case 3:
            case 12:
                gameStatus = Status.LOST;
                break;
            default:
                gameStatus = Status.CONTINUE;
                point = firstRoll;
                System.out.println("Point is set to: " + point);
                break;
        }

        // Continue rolling if the game hasn't been decided
        while (gameStatus == Status.CONTINUE) {
            int newRoll = rollDice(random);

            if (newRoll == point) {
                gameStatus = Status.WON;
            } else if (newRoll == 7) {
                gameStatus = Status.LOST;
            }
        }

        // Output result of the game
        if (gameStatus == Status.WON) {
            System.out.println("You win!");
        } else {
            System.out.println("You lose!");
        }
    }

    // Helper method to roll two dice and print the result
    public static int rollDice(Random random) {
        int die1 = 1 + random.nextInt(6);  // Roll first die (1-6)
        int die2 = 1 + random.nextInt(6);  // Roll second die (1-6)
        int sum = die1 + die2;

        System.out.println("You rolled " + die1 + " + " + die2 + " = " + sum);
        return sum;
    }
}
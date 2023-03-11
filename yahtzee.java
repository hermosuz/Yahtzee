/**
* This program plays and scores one hand of yahtzee
* CPSC 224-01, 2023
* HW 1.
* Proffesor Crandall
* Manny Uzoma
*/


import java.util.Scanner;
import java.util.Arrays;

public class yahtzee{
    public static int rollDie()
    {
        return (int)(Math.random()* 6 + 1);
    }

    public static int maxOfAKindFound(int[] hand){
        int maxCount = 0;
        int currentCount;
        for (int dieValue = 1; dieValue <=6; dieValue++)
        {
            currentCount = 0;
            for (int diePosition = 0; diePosition < 5; diePosition++)
            {
                if (hand[diePosition] == dieValue)
                    currentCount++;
            }
            if (currentCount > maxCount)
                maxCount = currentCount;
        }
        return maxCount;
    }

    public static int maxStraightFound(int[] hand){
        int maxLength = 1;
        int curLength = 1;
        for(int counter = 0; counter < 4; counter++){
            if (hand[counter] + 1 == hand[counter + 1] ) //jump of 1
                curLength++;
            else if (hand[counter] + 1 < hand[counter + 1]) //jump of >= 2
                curLength = 1;
            if (curLength > maxLength)
                maxLength = curLength;
        }
        return maxLength;
    }
    public static boolean fullHouseFound(int[] hand){
        boolean foundFH = false;
        boolean found3K = false;
        boolean found2K = false;
        int currentCount ;
        for (int dieValue = 1; dieValue <=6; dieValue++)
        {
            currentCount = 0;
            for (int diePosition = 0; diePosition < 5; diePosition++)
            {
                if (hand[diePosition] == dieValue)
                    currentCount++;
            }
            if (currentCount == 2)
                found2K = true;
            if (currentCount == 3)
                found3K = true;
        }
        if (found2K && found3K)
            foundFH = true;
        return foundFH;
    }
    public static int totalAllDice(int[] hand){
        int total = 0;
    for (int diePosition = 0; diePosition < 5; diePosition++)
    {
        total += hand[diePosition];
    }
    return total;
    }
    public static void sortArray(int[] array){
        Arrays.sort(array);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] hand = new int[5];
        int rollCount = 1;
    
        // Roll the dice
        for (int i = 0; i < 5; i++) {
            hand[i] = rollDie();
        }
    
        // Allow the player to re-roll the dice up to 2 times
        while (rollCount <= 3) {
            // Display the player's hand
            System.out.println("Your hand: " + Arrays.toString(hand));
    
            // Ask the player which dice they want to re-roll
            System.out.print("Enter the indices of the dice you want to re-roll (e.g. 1 3 5): ");
            String input = scanner.nextLine();
            String[] indices = input.split(" ");
    
            // Re-roll the selected dice
            for (String index : indices) {
                int i = Integer.parseInt(index) - 1;
                hand[i] = rollDie();
            }
    
            // Increment the roll count
            rollCount++;
    
            // If the player has already rolled 3 times, exit the loop
            if (rollCount > 3) {
                break;
            }
    
            // Ask the player if they want to re-roll again
            System.out.print("Do you want to re-roll again? (y/n) ");
            String answer = scanner.nextLine();
            if (answer.equals("n")) {
                break;
            }
        }
    
        // Display the player's final hand
        System.out.println("Final hand: " + Arrays.toString(hand));
    
        // Sort the player's hand
        sortArray(hand);
    
        // Calculate the score based on the player's hand
        int score = 0;
        int maxOfAKind = maxOfAKindFound(hand);
        int maxStraight = maxStraightFound(hand);
        boolean fullHouse = fullHouseFound(hand);
        int totalAllDice = totalAllDice(hand);
    
        // Check for Yahtzee
        if (maxOfAKind == 5) {
            score = 50;
            System.out.println("Yahtzee!");
        } else if (maxOfAKind == 4) {
            score = 40;
            System.out.println("Four of a kind!");
        } else if (fullHouse) {
            score = 25;
            System.out.println("Full house!");
        } else if (maxStraight == 5) {
            score = 40;
            System.out.println("Large straight!");
        } else if (maxStraight == 4) {
            score = 30;
            System.out.println("Small straight!");
        } else {
            score = totalAllDice;
            System.out.println("Chance!");
        }
    
        // Display the player's score
        System.out.println("Your score is " + score);
        scanner.close();
    }
    
}
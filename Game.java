import java.util.Scanner;

public class Game {
    private Hand hand;
    private Scorecard scorecard;
    private Scanner scanner;

    public Game() {
        hand = new Hand(5);
        scorecard = new Scorecard();
        scanner = new Scanner(System.in);
    }

    public void play() {
        String keep = "nnnnn";
        int turn = 1;
        while (turn <= 3) {
            hand.roll();
            System.out.print("Your roll was: ");
            for (Die d : hand.getDice()) {
                System.out.print(d.getValue() + " ");
            }
            if (turn < 3) {
                System.out.println("enter dice to keep (y or n)");
                keep = scanner.nextLine();
                for (int i = 0; i < keep.length(); i++) {
                    if (keep.charAt(i) != 'y') {
                        hand.roll(i);
                    }
                }
            }
            turn++;
        }
        System.out.println("Here is your sorted hand: " + hand);
        
        // Prints scores for upper section (1-6)
        for (int i = 1; i <= 6; i++) {
            System.out.println("Score " + scorecard.scoreUpper(i, hand) + " on the " + i + " line");
        }

        System.out.println("Score " + scorecard.scoreThreeOfAKind(hand) + " on the 3 of a Kind line");
       

        System.out.println("Enter 'y' to play again");
    }
}

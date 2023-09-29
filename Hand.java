import java.util.ArrayList;
import java.util.Collections;

public class Hand {
   private ArrayList<Die> dice;
   
    public Hand(int numDice) {
        dice = new ArrayList<>();
        for (int i = 0; i < numDice; i++) {
            dice.add(new Die());
        }
    }
    
    public void roll(){
        for (Die d : dice) {
            d.roll();
        }
    }
    
    public void roll(int index) {
        dice.get(index).roll();
    }
    
    public ArrayList<Die> getDice() {
        return dice;
    }
    
    public void sort() {
        Collections.sort(dice, (d1, d2) -> d1.getValue() - d2.getValue());
    }
    
    public String toString(){
        return dice.toString();
    }
}

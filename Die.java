/**
* Die class
* CPSC 224-01, 2023
* HW 1.
* Proffesor Crandall
* Manny Uzoma
*/

import java.util.Random;

public class Die {
    private int currentValue;
    private static Random rand = new Random();

    public Die() {
        roll();
    }

    public void roll() {
        currentValue = rand.nextInt(6) + 1;
    }

    public int getValue() {
        return currentValue;
    }

    public String toString() {
        return String.valueOf(currentValue);
    }

}
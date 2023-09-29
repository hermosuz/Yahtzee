public class Scorecard {
    
    public int scoreUpper(int dieValue, Hand hand) {
        int count = 0;
        for (Die d : hand.getDice()) {
            if (d.getValue() == dieValue) {
                count++;
            }
        }
        return count * dieValue;
    }

    public int scoreThreeOfAKind(Hand hand) {
        hand.sort();
        for (int i = 0; i < 3; i++) {
            if (hand.getDice().get(i).getValue() == hand.getDice().get(i + 1).getValue() &&
            hand.getDice().get(i + 1).getValue() == hand.getDice().get(i + 2).getValue()) {
                return hand.getDice().stream().mapToInt(Die::getValue).sum();
            }
        }
        return 0;
    }

}

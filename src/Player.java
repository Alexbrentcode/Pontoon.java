import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
    ArrayList<Card> currentHand = new ArrayList<>();
    public String name;
    ArrayList<Integer> test = new ArrayList<>();
    int score;



    public String toString() {
        return this.name;
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }


    public ArrayList<Card> getCards() {
        return currentHand;
    }

    public void dealToPlayer(Card card) {
        if (Deck.newDeck.size() != 0) {
            currentHand.add(card);
        }
    }

    //This method removes a card from a player’s hand.
    public void removeCard(Card card) {
        int x = currentHand.size();
        currentHand.remove(x - 1);
    }
    //The block below first uses the frequency method to check if there are any Aces in the hand. It then loops through
    //the hand adding each value to sum until it has added as many values as the hand size. We then use the freq count
    //to remove any excess ace 1's. We then loop through adding the sums to the AL and subtracting 10 to show both hand
    //values. The formula is (sum of base cards) - (Ace count * 1): - (Ace count * 10)
    //We then use the reverse method to flip this AL into the correct format.

    public ArrayList<Integer> getNumericalHandValue() {
        List<Integer> numericHand = new ArrayList<Integer>();
        ArrayList<Integer> allHandValues = new ArrayList<>();
        numericHand.clear();

        for(int z = 0; z < currentHand.size(); z++) {
            numericHand.addAll(currentHand.get(z).getNumericalValue());
        }
        int freq = Collections.frequency(numericHand, 11);
        int x;
        int sum = 0;
        for (x = 0; x < numericHand.size(); x++) {
            sum = sum + numericHand.get(x);

        }
        sum = sum - (freq);
        for (x = 0; x <= freq; x++) {
            allHandValues.add(sum);
            sum = sum - 10;
        }
        Collections.reverse(allHandValues);
        return allHandValues;
    }

    //This method returns the maximum numerical value of the player’s hand of cards. Ut works by first totalling the
    //sum of the hand, then if the sum is greater than 21, it will remove 10 from the hand value (simply changing
    //an Ace-11 to an Ace-1. This also checks each time if the hand value is then equal to or less than 21. If it is, it
    //will return this value as the best possible hand value. If the hand is over less than 21 then the hand is already
    //showing its bets possible value.

    public int getBestNumericalHandValue() {
        int len = getNumericalHandValue().size();
        int aceFreq = len - 1;
        int numericalVal = getNumericalHandValue().get(len-1);
        if (numericalVal > 21) {
            while (aceFreq > 0) {
                numericalVal = numericalVal - 10;
                aceFreq--;
                if (numericalVal <= 21) {
                    return numericalVal;
                }
            }
        }
        return numericalVal;
    }

    public int getHandSize() {
        return currentHand.size();
    }
}

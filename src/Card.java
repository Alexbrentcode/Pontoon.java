import java.util.ArrayList;
import java.util.*;

public class Card {

    Suit suit;
    Value value;

    public String toString()
    {
        return this.suit + " " + this.value;
    }

    public Card(Suit suit, Value val) {
        this.suit = suit;
        this.value = val;
    }


    public static enum Suit {CLUBS, HEARTS, DIAMONDS, SPADES}

    public static enum Value {ACE, TWO ,THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING,}

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public ArrayList<Integer>getNumericalValue() {
        ArrayList<Integer> numericalValues = new ArrayList<>();
        switch(value){
            case TWO:
                numericalValues.add(2);
            break;
            case THREE:
                numericalValues.add(3);
            break;
            case FOUR:
                numericalValues.add(4);
            break;
            case FIVE:
                numericalValues.add(5);
            break;
            case SIX:
                numericalValues.add(6);
            break;
            case SEVEN:
                numericalValues.add(7);
            break;
            case EIGHT:
                numericalValues.add(8);
            break;
            case NINE:
                numericalValues.add(9);
            break;
            case TEN:
            case JACK:
            case QUEEN:
            case KING:
                numericalValues.add(10);
                break;
            case ACE:
                numericalValues.add(1);
                numericalValues.add(11);
            break;
        }
    return numericalValues;
    }
}

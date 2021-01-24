import java.util.ArrayList;
import java.util.Arrays;

public class Deck {
    Card cardDealt;
    public static ArrayList<Card> cardDeck = new ArrayList<>();
    public static Deck newDeck =  new Deck();

    public Deck() {
        reset();
        shuffle();
    }

    public void reset() {
        cardDeck.clear();
        for(Card.Suit s : Card.Suit.values()) {
            for(Card.Value v : Card.Value.values()) {
                Card card = new Card(s, v);
                cardDeck.add(card);
            }
        }
    }

    //The below method uses the Fisher Yates algorithm to shuffle through the card Deck - specifically Durstenfeld's
    //implementation. In short, the turns the aL into an arr of the same size, then loops backwards through the array,
    //taking thee value at i and swapping it with a random index value - j. This cycles 51 times at stops after index 1,
    //Then the cardDeck aL is rewritten with the new shuffled cardDeck aL.
    public void shuffle() {
        if (cardDeck.size()  != 0){
            Card temp;
            Card[] cardArray = cardDeck.toArray(new Card[cardDeck.size()]);
            int j;
            int i = cardDeck.size();
            while (--i > 0) {
                j = (int) Math.floor(Math.random() * (i + 1));
                temp = cardArray[j];
                cardArray[j] = cardArray[i];
                cardArray[i] = temp;
            }
            cardDeck = new ArrayList<>(Arrays.asList(cardArray));
        }
    }

    public Card getCard(int i) {
        if (cardDeck.size() != 0) {
            Card c = cardDeck.get(i);
            return cardDeck.get(i);
        } else {
            return null;
        }
    }

    //This method uses the same Math.random functionality as shuffle. The method selects a random card at rand int j
    //and assigns it to cardDealt. That card is then removed from the cardDeck arrayList and the cardDealt is returned
    public Card dealRandomCard() {
        if (cardDeck.size() != 0) {
            int i = cardDeck.size();
            int j = (int) Math.floor(Math.random() * (i - 1));
            cardDealt = cardDeck.get(j);
            cardDeck.remove(j);
            return this.cardDealt;
        }
        else {
            return null;
        }
    }

    public int size() {
        return cardDeck.size();
    }
}

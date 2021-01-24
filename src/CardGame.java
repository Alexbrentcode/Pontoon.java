import java.util.ArrayList;

public abstract class CardGame {
    public ArrayList<Player> playerArrayList = new ArrayList<Player>();

    public CardGame(int nplayers) {
        for (int x = 0; x < nplayers; x++) {
            Player newPlayer = new Player("Player "+ x);
            playerArrayList.add(newPlayer);
        }
    }

    public abstract void dealInitialCards();

    public abstract int compareHands(Player hand1, Player hand2);

    public Deck getDeck() {
        return Deck.newDeck;
    }

    public Player getPlayer(int i) {
        return (playerArrayList.get(i));

    }
    public int getNumPlayers() {
        return playerArrayList.size();
    }

}

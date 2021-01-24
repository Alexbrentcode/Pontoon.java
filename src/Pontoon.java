public class Pontoon extends CardGame {

    public Pontoon(int nplayers) {
        super(nplayers);
    }

    public void dealInitialCards() {
        for (int x = 0; x < this.playerArrayList.size(); x++) {
            getPlayer(x).dealToPlayer(getDeck().dealRandomCard());
            getPlayer(x).dealToPlayer(getDeck().dealRandomCard());
        }
    }

    public int compareHands(Player hand1, Player hand2) {
        for (int x = 0; x < playerArrayList.size(); x++) {
            getPlayer(x).score = 0;
            if (getPlayer(x).getBestNumericalHandValue() == 21 && getPlayer(x).getHandSize() == 2) {
                getPlayer(x).score += 5;
            }else if (getPlayer(x).getBestNumericalHandValue() == 21 && getPlayer(x).getHandSize() > 2 && getPlayer(x).getHandSize() < 5) {
                getPlayer(x).score += 3;
            } else if (getPlayer(x).getHandSize() >= 5 && getPlayer(x).getBestNumericalHandValue() <= 21) {
                getPlayer(x).score += 4;
            } else if (getPlayer(x).getBestNumericalHandValue() < 21 && getPlayer(x).getHandSize() < 5) {
                getPlayer(x).score += 1;
            } else if (getPlayer(x).getBestNumericalHandValue() > 21) {
            }

            if (getPlayer(0).score == 1 && getPlayer(1).score == 1) {
                if (getPlayer(0).getBestNumericalHandValue() > getPlayer(1).getBestNumericalHandValue()) {
                    getPlayer(1).score = 0;
                } else if (getPlayer(0).getBestNumericalHandValue() < getPlayer(1).getBestNumericalHandValue()) {
                    getPlayer(0).score = 0;
                }
            }
        }

        if (getPlayer(0).score > getPlayer(1).score) {
            return -1;
        }
        if(getPlayer(0).score < getPlayer(1).score) {
            return 1;
        }
        return 0;
    }
}


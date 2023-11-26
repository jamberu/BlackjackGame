package player;

import deck.*;
import java.util.ArrayList;

public class Hand {
    private final ArrayList<Card> heldCards = new ArrayList<Card>();
    private int totalValue = 0;
    public String name;

    public Hand(String name) {
        this.name = name;
    }
    public void addCard(Card card) {
        heldCards.add(card);
        updateTotalValue(card);
    }
    public void updateTotalValue(Card card) {
        totalValue += card.getValue();
    }
    public int getTotalValue() {
        return this.totalValue;
    }

    public ArrayList<Card> getHeldCards() {
        return this.heldCards;
    }

}

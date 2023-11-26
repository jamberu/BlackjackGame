package deck;

public class Card {
    private String cardSuit = "";
    private int cardValue = 0;

    public Card(String cardSuit, int cardValue) {
        this.cardSuit = cardSuit;
        this.cardValue = cardValue;
    }

    public String getSuit() {
        return this.cardSuit;
    }

    public int getValue() {
        return this.cardValue;
    }

    public void setValue(int value) {
        this.cardValue = value;
    }
}

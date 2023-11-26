package deck;

import java.util.ArrayList;
import java.util.Random;

public class Pool {
    private final ArrayList<Card> poolCards = new ArrayList<Card>();
    private final String[] SUITS = {"♦️", "♣️", "♥️", "♠️"};
    private final String[][] VALUES = {
            {"1", "2", "3", "4", "5", "6", "7"},
            {"8", "9", "10"}
    };
    public Pool(int size) {
        for (int currentPos = 0; currentPos < size; currentPos++) {
            int valueIndex = new Random().nextInt(2);
            int trueValueIndex = 0;
            int suitIndex = new Random().nextInt(4);

            if (valueIndex == 0) {
                trueValueIndex = new Random().nextInt(6);
            }
            else {
                trueValueIndex = new Random().nextInt(3);
            }
            Card card = new Card(SUITS[suitIndex], Integer.parseInt(VALUES[valueIndex][trueValueIndex]));
            poolCards.add(card);
        }
    }

    public Card drawCard() {
        return poolCards.remove(0);
    }

    public void shufflePool() {
        Random random = new Random();

        for (int shuffleRound = 0; shuffleRound < 2; shuffleRound++) {
            for (int currentIndex = 0; currentIndex < poolCards.size(); currentIndex++) {
                int randomIndex = random.nextInt(poolCards.size());
                Card tempCard = poolCards.get(currentIndex);
                poolCards.set(currentIndex, poolCards.get(randomIndex));
                poolCards.set(randomIndex, tempCard);
            }
        }
    }
}

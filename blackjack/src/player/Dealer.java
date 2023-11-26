package player;

public class Dealer extends Hand {

    public Dealer(String name) {
        super(name);
    }

    public char move() {
        if (super.getTotalValue() < 17) {
            return 'H';
        }
        return 'S';
    }
}

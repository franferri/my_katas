package coup.coins;

public class Coins {

    static final int MAX_COINS = 50;
    private static final int MIN_COINS = 0;

    protected int coins;

    public int coins() {
        return coins;
    }

    public void deal(final int coins) {
        checkMinimums(coins);
        this.coins = this.coins - coins;
    }

    public void receive(final int coins) {
        checkMaximums(coins);
        this.coins = this.coins + coins;
    }

    private void checkMinimums(final int coins) {
        if (this.coins - coins < MIN_COINS) {
            throw new RuntimeException("Not enough coins");
        }
    }

    private void checkMaximums(final int coins) {
        if (this.coins + coins > MAX_COINS) {
            throw new RuntimeException("Too many coins in play");
        }
    }
}

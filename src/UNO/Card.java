package UNO;

import java.util.Random;
public abstract class Card
{
    final private static String[] colors = {"Yellow", "Red", "Green", "Blue"};

    private int color;
    private int number;

    // Creates a random Uno card where color is randomly assigned in the range [0,3] and
    // number is randomly assigned in the range [1, 9].
    public Card(Random r) {
        color = r.nextInt(4);
        number = r.nextInt(9) + 1;
    }

    public Card(int c, int n) {
        color = c;
        number = n;
    }

    // Returns a String representation of a card. (Example: Yellow 5)
    public String toString() {
        return colors[color] + " " + number;
    }

    // Returns true iff you can play other on this card.
    public boolean canPlay(Card other) {
        return this.color == other.color || this.number == other.number;
    }
}
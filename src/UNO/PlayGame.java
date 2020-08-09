package UNO;


import java.util.Scanner;
/**
 *
 * @author Ratinder Bhullar
 */
public class PlayGame extends Game{

    final private static int NUMCARDSHAND = 7;

    private GroupOfCards deck;
    private GroupOfCards discardPile;
    private GroupOfCards hand1;
    private GroupOfCards hand2;
    private Player name1;
    private Player name2;

    Scanner input = new Scanner(System.in);

    public PlayGame() {

        // Make the deck and shuffle it.
        deck = new GroupOfCards();
        deck.makeDeck();
        deck.shuffle();

        // Discard Pile
        discardPile = new GroupOfCards();

        // Create the two hands.
        hand1 = new GroupOfCards();
        hand2 = new GroupOfCards();

        // Deal them alternately.
        for (int i = 0; i < NUMCARDSHAND; i++) {
            hand1.addCard(deck.removeFromTop());
            hand2.addCard(deck.removeFromTop());
        }
    }
    
    @Override
    public void play() {
       
        System.out.println("Welcome to UNO!!! Let's Play");
        
        System.out.println("Enter name1 name");
       name1.setPlayerID(input.next());

        System.out.println("Enter player 2 name");
       name2.setPlayerID(input.next());

        System.out.println(name1 + ", here is your hand:\n" + hand1);
        System.out.println("What card would you like to discard? Please give the associated number.");
        int card = input.nextInt();
        discardPile.addCard(hand1.remove(card));

        int turn = 2;

        // The game ends if the deck or either player's hand is empty.
        while (deck.getNumCards() > 0 && hand1.getNumCards() > 0 && hand2.getNumCards() > 0) {

            playTurn(turn);

            // Flip the player's turn.
            if (turn == 1) {
                turn = 2;
            } else {
                turn = 1;
            }
        }

        declareWinner();

    }

    // Precondition: Can only be called at the end of the game!
    @Override
    public void declareWinner() {
        if (deck.getNumCards() == 0) {
            System.out.println("Sorry, the game has ended in a draw.");
        } else if (hand1.getNumCards() == 0) {
            System.out.println(name1 + ", you win =)");
        } else {
            System.out.println(name2 + ", you win =)");
        }
    }
    // Plays one turn for the player number indicated.
    public void playTurn(int player) {


        System.out.println("The card at the top of the discard pile is " + discardPile.getTopCard());

        if (player == 1) {

            // We have a card to play!
            if (hand1.canPlay(discardPile.getTopCard())) {
                System.out.println("\n" + name1 + ", here is your hand:\n" + hand1);

                System.out.println("What card would you like to discard? Please give the associated number.");
                int card = input.nextInt();

                // Only play this card if it's really valid!
                if (hand1.getCard(card).canPlay(discardPile.getTopCard())) {
                    discardPile.addCard(hand1.remove(card));
                } else {
                    System.out.println("Sorry that is not a valid card. You lost your opportunity to drop a card.");
                }

                // UNO =)
                if (hand1.getNumCards() == 1) {
                    System.out.println(name1 + " says UNO!!!!");
                }
            } // Add a card and show the result.
            else {
                System.out.println("Sorry, you can't play on this card. A card has been drawn for you.");
                hand1.addCard(deck.removeFromTop());
                System.out.println(name1 + ", here is your resulting hand:\n" + hand1);
            }
        } else {

            // We have a card to play!
            if (hand2.canPlay(discardPile.getTopCard())) {
                System.out.println("\n" + name2+ ", here is your hand:\n" + hand2);
                System.out.println("What card would you like to discard? Please give the associated number.");
                int card = input.nextInt();

                // Only play this card if it's really valid!
                if (hand2.getCard(card).canPlay(discardPile.getTopCard())) {
                    discardPile.addCard(hand2.remove(card));
                } else {
                    System.out.println("Sorry that is not a valid card. You lost your opportunity to drop a card.");
                }

                // UNO =)
                if (hand2.getNumCards() == 1) {
                    System.out.println(name2 + " says UNO!!!!");
                }
            } // Add a card and show the result.
            else {
                System.out.println("Sorry, you can't play on this card. A card has been drawn for you.");
                hand2.addCard(deck.removeFromTop());
                System.out.println(name2 + ", here is your resutling hand:\n" + hand2);
            }

        }
    }

    public static void main(String[] args) {
        
        Game play = new PlayGame();
        play.play();
    }
}

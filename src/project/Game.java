/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Ratinder Bhullar
 */
public abstract class Game {
    private final String gameName = "UNO";//the title of the game
    private ArrayList <Player> players;// the players of the game
    final private static int NUMCARDSHAND = 7;

    private GroupOfCards deck;
    private GroupOfCards discardPile;
    private GroupOfCards hand1;
    private GroupOfCards hand2;
    
    Scanner input = new Scanner(System.in);
    
    public Game(String givenName)
    {
        players = new ArrayList();
    }

    public Game() {

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
    /**
     * @return the gameName
     */
    public String getGameName() 
    {
        return gameName;
    }
    
     /**
     * @return the players of this game
     */
    public ArrayList <Player> getPlayers() 
    {
        return players;
    }

    /**
     * @param players the players of this game
     */
    public void setPlayers(ArrayList <Player> players) 
    {
        this.players = players;
    }
    
    /**
     * Play the game. This might be one method or many method calls depending
     * on your game.
     */
   
    /**
     * Play the game. This might be one method or many method calls depending
     * on your game.
     */
    public abstract void play(GroupOfCards deck,GroupOfCards hand1,
            GroupOfCards hand2, GroupOfCards discardPile) ;
    
    

    /**
     * When the game is over, use this method to declare and display a winning
     * player.
     */
    public abstract void declareWinner(GroupOfCards deck,GroupOfCards hand1);


    // Plays one turn for the player number indicated.
    public void playTurn(int player) {


        System.out.println("The card at the top of the discard pile is " + discardPile.getTopCard());

        if (player == 1) {

            // We have a card to play!
            if (hand1.canPlay(discardPile.getTopCard())) {
                System.out.println("\nPlayer 1, here is your hand:\n" + hand1);
                
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
                    System.out.println("Player One says UNO!!!!");
                }
            } // Add a card and show the result.
            else {
                System.out.println("Sorry, you can't play on this card. A card has been drawn for you.");
                hand1.addCard(deck.removeFromTop());
                System.out.println("Player 1, here is your resulting hand:\n" + hand1);
            }
        } else {

            // We have a card to play!
            if (hand2.canPlay(discardPile.getTopCard())) {
                System.out.println("\nPlayer 2, here is your hand:\n" + hand2);
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
                    System.out.println("Player Two says UNO!!!!");
                }
            } // Add a card and show the result.
            else {
                System.out.println("Sorry, you can't play on this card. A card has been drawn for you.");
                hand2.addCard(deck.removeFromTop());
                System.out.println("Player 2, here is your resutling hand:\n" + hand2);
            }

        }
    }
}

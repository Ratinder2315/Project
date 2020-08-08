/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.Scanner;

/**
 *
 * @author Ratinder Bhullar
 */
public abstract class Play extends Game {

    public void playGame(GroupOfCards deck, GroupOfCards hand1,
            GroupOfCards hand2, GroupOfCards discardPile) {

        Scanner stdin = new Scanner(System.in);

        System.out.println("Welcome to UNO!!! Let's Play");
        System.out.println("Player 1, here is your hand:\n" + hand1);
        System.out.println("What card would you like to discard? Please give the associated number.");
        int card = stdin.nextInt();
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

        declareWinner(deck, hand1);

    }

    // Precondition: Can only be called at the end of the game!
    public void declareWinner(GroupOfCards deck, GroupOfCards hand1) {
        if (deck.getNumCards() == 0) {
            System.out.println("Sorry, the game has ended in a draw.");
        } else if (hand1.getNumCards() == 0) {
            System.out.println("Player 1, you win =)");
        } else {
            System.out.println("Player 2, you win =)");
        }
    }

    public static void main(String[] args) {
        playGame();
    }
}

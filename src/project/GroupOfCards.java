/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author Ratinder Bhullar
 */
public class GroupOfCards {
    //The group of cards, stored in an ArrayList
    private ArrayList <Card> cards;
    final public static int MAXCARDS = 72;
    private int size;//the size of the grouping
    
    public GroupOfCards()
    {
        cards = new ArrayList<Card>();
    }
    
    /**
     * A method that will get the group of cards as an ArrayList
     * @return the group of cards.
     */
    public ArrayList<Card> showCards()
    {
        return cards;
    }
    
    public boolean addCard(Card c) {

        // Don't allow us to add this card if we're full.
        if (cards.size() == MAXCARDS) {
            return false;
        } 
        // It's okay to add the card.
        else {
            cards.add(c);
            return true;
        }
    }

    // If the collection is non-empty, this removes and returns the last card (top) from the collection. If the
    // collection is already empty, null is returned.
    public Card removeFromTop() {

        // This is how we indicate that there's no card to return.
        if (cards.isEmpty()) {
            return null;
        }

        // Remove and return the card.
        return cards.remove(cards.size() - 1);
    }

    // If the collection is non-empty, this removes and returns the card at location index. If the
    // collection is already empty, null is returned.
    public Card remove(int index) {

        // The invalid case here.
        if (index < 0 || index >= cards.size()) {
            return null;
        }

        // This is the card to remove.
        return cards.remove(index);
    }

    // This clears what is currently in the collection and fills it with a deck of Uno cards,
    // with two copies of each card.
    public void makeDeck() {

        // This clears our deck!
        cards.clear();

        // Making 2 copies of each card.
        for (int i = 0; i < 2; i++) // Go through each color.
        {
            for (int j = 0; j < 4; j++) // Go through each number.
            {
                for (int k = 1; k <= 9; k++) {
                    cards.add(new Card(j, k) {});
                }
            }
        }

    }
    
    public void shuffle()
    {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return cards.size();
    }

    /**
     * @param givenSize the max size for the group of cards
     */
    public void setSize(int givenSize) {
        size = MAXCARDS;
    }
    
    @Override
    public String toString() {

        // We're going to have to build this String, piece by piece.
        String answer = "";

        // Add one line at a time to this string, for each card.
        for (int i = 0; i < cards.size(); i++) {
            answer = answer + i + ". " + cards.get(i) + "\n";
        }

        // Now we have the String representation of the whole group.
        return answer;
    }
    
    // Returns the number of cards.
    public int getNumCards() {
        return cards.size();
    }

    // Returns the card at the top of this collection.
    public Card getTopCard() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.get(cards.size() - 1);
    }

    // Returns true iff there's any card in this collection that can be played
    // on top of c.
    public boolean canPlay(Card c) {

        // Try to find a card in our collection that can be played on c.
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).canPlay(c)) {
                return true;
            }
        }

        // If we get here, no card was found.
        return false;
    }

    // Returns the in position index.
    public Card getCard(int index) {
        if (index >= cards.size() || index < 0) {
            return null;
        }
        return cards.get(index);
    }
}

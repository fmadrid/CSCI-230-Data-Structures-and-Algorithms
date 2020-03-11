package LabSolutions.list_iterator;

import java.util.Iterator;
import LabSolutions.list_iterator.Card.Suit;
import net.datastructures.LinkedPositionalList;
import net.datastructures.Position;
import java.util.Iterator;
/**
 * A class that supports the arrangement of a hand of cards. Represents the sequence of cards using a single positional list ADT so that cards of the same suit are kept together.
 * Cards are pulled from the positional list in constant time.<br><br><b>Assignment Restrictions</b>: You may edit this file as much as you please as long as the following functions are
 * implemented: <i>addCard</i>, <i>play</i>, <i>iterator</i>, <i>suitIterator</i> and a <i>single</i> LinkedPositionalList is used.
 * @author YourName

 */
public final class CardHand implements Iterator<Card>{
	
	private LinkedPositionalList<Card> hand;
	
	private Position<Card> firstHeart;
	private Position<Card> firstClub;
	private Position<Card> firstDiamond;
	private Position<Card> firstSpade;
	
	/**
	 * Initializes the LinkedPositionalList hand with five new cards
	 * @param cards
	 */
	public CardHand(Card[] cards) {
		
		hand = new LinkedPositionalList<Card>();
		// Add each element from card array into hand
		for(Card c : cards) {
			addCard(c);
		}
	}
	
	/**
	 * @return - Adds the specified card to the hand.
	 */
	void addCard(Card c) {
		// Have we seen the suit before?
		switch(c.getSuit()) {
			case CLUB:
				if(firstClub == null) firstClub = hand.addFirst(c);
				else                  hand.addAfter(firstClub, c);
				break;
			case HEART:
				if(firstHeart == null) firstHeart = hand.addFirst(c);
				else                   hand.addAfter(firstHeart, c);
				break;
			case SPADE:
				if(firstSpade == null) firstSpade = hand.addFirst(c);
				else                   hand.addAfter(firstSpade, c);
				break;
			case DIAMOND:
				if(firstDiamond == null) firstDiamond = hand.addFirst(c);
				else                     hand.addAfter(firstDiamond, c);
				break;
			default:
				break;
		}
	}
	
	/**
	 * @return - Remove and returns a card of suit <i> from the player's hand; if there are no cards of suit <i>s</i>, then remove and return an arbitrary card from the hand.
	 */
	Card play(Suit s) {
		Card c = null;
		switch(s) {
		case CLUB:
			if(firstClub != null) {
				
				Position<Card> nextClub = null;
				if(hand.after(firstClub) != null)
					if(hand.after(firstClub).getElement().getSuit() == Card.Suit.CLUB)
						nextClub = hand.after(firstClub);
				
				c = hand.remove(firstClub);
				if(nextClub != null) firstClub = nextClub;
			}
			break;
		case DIAMOND:
			if(firstDiamond != null) c = hand.remove(firstDiamond);
			break;
		case HEART:
			if(firstHeart != null) c = hand.remove(firstHeart);
			break;
		case SPADE:
			if(firstSpade != null) c = hand.remove(firstSpade);
			break;
		default:
			break;
		
		}
		
		return c;
	}
	
	/**
	 * @return - An iterator for all cards currently in the hand
	 */
	Iterator<Card> iterator() {
		return null;
	}
	
	/**
	 * @return - An iterator for all cards of suit <i>s</i> that are currently in the hand.
	 */
	Iterator<Card> suitIterator(Suit s) {
		
		// Set an iterator to the first card of the specific suit
		// If they call next on this iterator
		// return the next only if the suit matches
		// otherwise, throw an error
		return null;
	}
	
	/**
	 * @return - Returns a string of the cards currently in the hand.
	 */
	@Override
	public String toString() {
		
		// Hint: The cards toString function is provided to you
		return "";
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Card next() {
		// TODO Auto-generated method stub
		return null;
	}
}

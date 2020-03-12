package LabSolutions.list_iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

import LabSolutions.list_iterator.Card.Suit;
import net.datastructures.LinkedPositionalList;
import net.datastructures.Position;

/**
 * A class that supports the arrangement of a hand of cards. Represents the sequence of cards using a single positional list ADT so that cards of the same suit are kept together.
 * Cards are pulled from the positional list in constant time.<br><br><b>Assignment Restrictions</b>: You may edit this file as much as you please as long as the following functions are
 * implemented: <i>addCard</i>, <i>play</i>, <i>iterator</i>, <i>suitIterator</i> and a <i>single</i> LinkedPositionalList is used.
 * @author YourName

 */
public final class CardHand implements Iterable<Position<Card>>{
	
	private LinkedPositionalList<Card> hand;
	
	/**
	 * Maintains the position of the cards with a suit of Heart
	 */
	private Position<Card> heartPosition;
	
	/**
	 * Maintains the position of the cards with a suit of Club
	 */
	private Position<Card> clubPosition;
	
	/**
	 * Maintains the position of the cards with a suit of Diamond
	 */
	private Position<Card> diamondPosition;
	
	/**
	 * Maintains the position of the cards with a suit of Spade
	 */
	private Position<Card> spadePosition;
	
	private class CardHandIterator implements Iterator<Position<Card>> {

		private Position<Card> cursor = hand.first();
		
		
		@Override
		public boolean hasNext() {
			return cursor != null;
		}

		@Override
		public Position<Card> next() throws NoSuchElementException{
			if(cursor == null) throw new NoSuchElementException("Nothing left!");
			
			Position<Card> recent = null;
			recent = cursor;
			cursor = hand.after(cursor);
			return recent;
		}
		
	}
	
	private class SuitIterator implements Iterator<Position<Card>> {

		private Position<Card> cursor = null;
		Suit s = null;
		public SuitIterator(Suit s) {
			switch(s) {
				case CLUB:    cursor = clubPosition;    break;
				case DIAMOND: cursor = diamondPosition; break;
				case HEART:   cursor = heartPosition;   break;
				case SPADE:   cursor = spadePosition;   break;
			}
			this.s = s;
		}
		
		@Override
		public boolean hasNext() {
			return cursor != null && cursor.getElement().getSuit() == s;
		}

		@Override
		public Position<Card> next() throws NoSuchElementException{
			if(cursor == null) throw new NoSuchElementException("Nothing left!");
			
			Position<Card> recent = null;
			recent = cursor;
			cursor = hand.after(cursor);
			return recent;
		}
		
	}
	
	/**
	 * @return - An iterator for all cards currently in the hand
	 */
	public Iterator<Position<Card>> iterator() {
		return new CardHandIterator();
	}
	
	/**
	 * @return - An iterator for all cards of suit <i>s</i> that are currently in the hand.
	 */
	public Iterator<Position<Card>> suitIterator(Suit s) {
		
		// Set an iterator to the first card of the specific suit
		// If they call next on this iterator
		// return the next only if the suit matches
		// otherwise, throw an error
		return new SuitIterator(s);
	}
	
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
				if(clubPosition == null) clubPosition = hand.addFirst(c);
				else                  hand.addAfter(clubPosition, c);
				break;
			case HEART:
				if(heartPosition == null) heartPosition = hand.addFirst(c);
				else                   hand.addAfter(heartPosition, c);
				break;
			case SPADE:
				if(spadePosition == null) spadePosition = hand.addFirst(c);
				else                   hand.addAfter(spadePosition, c);
				break;
			case DIAMOND:
				if(diamondPosition == null) diamondPosition = hand.addFirst(c);
				else                     hand.addAfter(diamondPosition, c);
				break;
			default:
				break;
		}
	}
	
	/**
	 * @return - Remove and returns a card of suit <i> from the player's hand; if there are no cards of suit <i>s</i>, then remove and return an arbitrary card from the hand.
	 */
	Card play(Suit s) {
		
		if(hand.isEmpty()) throw new NoSuchElementException("Hand is empty!");
		
		/**
		 * The card which will be played
		 */
		Position<Card> suitCard = null;
		
		// Attempt to get a card from the particular suit
		switch(s) {
			case CLUB: 		suitCard = clubPosition;    break;
			case DIAMOND:   suitCard = diamondPosition; break;
			case HEART:		suitCard = heartPosition;   break;
			case SPADE:		suitCard = spadePosition;   break;
		}
		
		// If we could not find a card of the particular suit, default to the first card in the hand
		if(suitCard == null) suitCard = hand.first();
		
		// Get a copy of the specific card to play (suitCard is guaranteed to be not null since hand is not empty)
		Card playedCard = suitCard.getElement();
		
		/**
		 * The card that follows the played card
		 */
		Position<Card> nextCard = null;
		
		// Set nextCard to null if either does not exist, the suit does not match
		if(suitCard != null && hand.after(suitCard) != null && hand.after(suitCard).getElement().getSuit() == suitCard.getElement().getSuit())
			nextCard = hand.after(suitCard);
		
		// Update the suitPosition pointer
		switch(suitCard.getElement().getSuit()) {
			case CLUB: 		clubPosition    = nextCard; break;
			case DIAMOND:   diamondPosition = nextCard; break;
			case HEART:		heartPosition   = nextCard; break;
			case SPADE:		spadePosition   = nextCard; break;
		}
		
		hand.remove(suitCard);
		return playedCard;
	}

	boolean isEmpty() {
		return hand.isEmpty();
	}
	
	/**
	 * @return - Returns a string of the cards currently in the hand.
	 */
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(hand.toString());
		
		sb.append("\n\t" + "Heart:   " + (heartPosition   == null ? "--None--" : heartPosition.getElement().toString()));
		sb.append("\n\t" + "Club:    " + (clubPosition    == null ? "--None--" : clubPosition.getElement().toString()));
		sb.append("\n\t" + "Diamond: " + (diamondPosition == null ? "--None--" : diamondPosition.getElement().toString()));
		sb.append("\n\t" + "Spade:   " + (spadePosition   == null ? "--None--" : spadePosition.getElement().toString()));
		
		return sb.toString();
	}

}

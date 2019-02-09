package blackjack;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Deck <T extends Card> {
    List<T> deck;
    private int indexOfNextAvailable;

    public void setDeck(List<T> deck){
        this.deck = deck;
    }

    public void shuffle(){
        Collections.shuffle(deck);
        indexOfNextAvailable = 0;
    }

    public List<T> dealHand(){
        List<T> dealtCards = new ArrayList<T>();
        dealtCards.add(deck.get(indexOfNextAvailable));
        dealtCards.add(deck.get(indexOfNextAvailable + 1));

        indexOfNextAvailable = indexOfNextAvailable + 2;

        return dealtCards;
    }

    public T dealCard(){
        indexOfNextAvailable++;
        return deck.get(indexOfNextAvailable-1);
    }
}
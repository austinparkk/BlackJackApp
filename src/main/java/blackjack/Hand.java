package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand <T extends Card> {
    protected List<T> hand;
    
    public int value(){
        int value = 0;
        for (T card: hand){
            value = value + card.value();
        }
        return value;
    }

    public void addCard(T card){
        hand.add(card);
    }
}
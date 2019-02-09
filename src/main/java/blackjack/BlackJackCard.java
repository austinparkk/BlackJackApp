package blackjack;

public class BlackJackCard extends Card {

    public BlackJackCard(Suit s, int v){
        super(s, v);
    }
    public int value(){
        if (super.value > 10 && super.value < 14){
            return 10;
        }

        return super.value;
    }
}
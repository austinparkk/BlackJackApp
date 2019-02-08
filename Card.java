public abstract class Card {
    private Suit suit;

    // value from 1 - 13;
    protected int value;

    public Card(Suit suit, int value){
        this.value = value;
        this.suit = suit; 
    }

    public Suit suit(){
        return suit;
    }

    public abstract int getValue();

}
public class BlackJackHand extends Hand <BlackJackCard> {

    public int score(){
        List<Integer> possibleScores = possibleScores();

        int maxUnder = Integer.MIN_VALUE;
        int minOver = Integer.MAX_VALUE;

        for (Integer score: possibleScores){
            if (score <= 21 && score > maxUnder){
                maxUnder = score;
            }
            if (score > 21 && score < minOver){
                minOver = score;
            }
        }

        return maxUnder == Integer.MIN_VALUE ? minOver : maxUnder;
    }

    private ArrayList<Integer> possibleScores(){
        ArrayList<Integer> possibleScores = new ArrayList<Integer>;
        int sumNonAce = 0;
        int numOfAces = 0;
        for (BlackJackCard card: hand){
            if (card.value() == 1){ // if ace
                numOfAces++;
            } else {
                sumNonAce = sumNonAce + card.value();
            }
        }

        if (numOfAces == 1){
            possibleScores.add(sumNonAce + 1);
            possibleScores.add(sumNonAce + 11);
        } else if (numOfAces > 1){ // if there is more than one Ace, only a max of one ace can be 11. 
            possibleScores.add(sumNonAce + 11 + (numOfAces - 1));
            possibleScores.add(sumNonAce + numOfAces);
        }

        return possibleScores;
    }

    public boolean is21(){
        return score() == 21;
    }

    public boolean isBust(){
        return score() > 21;
    }

    public boolean isBlackJack(){
        // check if one card is ace and one card is 10-13;
        if (!hand.size() == 2){
            return false;
        }

        boolean ace = false;
        boolean ten = false;
        for (BlackJackCard card: hand){
            if (card.value() == 1){
                ace = true;
            }

            if (card.value() == 10){
                ten = true;
            }
        }
        return ace && ten;
    }
}

import java.util.*;

public class Dealer implements GameParticipant {
    private ArrayList<Card> hand = new ArrayList<>();
    private int score = 0;

    @Override
    public void addCard(Card card) {
        hand.add(card);
        updateScore();
    }

    public boolean shouldHit() {
        return score < 17;
    }

    private void updateScore() {
        score = 0;
        int aceCount = 0;
        for (Card card : hand) {
            int cardValue = card.getCardValue();
            if (cardValue == 11) {
                aceCount++;
            }
            score += cardValue;
        }
        while (score > 21 && aceCount > 0) {
            score -= 10;
            aceCount--;
        }
    }

    public List<Card> getHand() {
        return new ArrayList<>(hand);
    }

    public List<Card> getHand(boolean hideFirstCard) {
        if (hideFirstCard && hand.size() > 0) {
            ArrayList<Card> handCopy = new ArrayList<>(hand);
            handCopy.set(0, new Card("BACK", ""));
            return handCopy;
        }
        return hand;
    }

    @Override
    public int getScore() {
        return score;
    }

    public void clearHand() {
        hand.clear();
        score = 0;
    }

    public String getHandAsString(boolean hideFirstCard) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hand.size(); i++) {
            if (hideFirstCard && i == 0) {
                sb.append("[Hidden Card], ");
            } else {
                sb.append(hand.get(i).toString());
                if (i < hand.size() - 1) {
                    sb.append(", ");
                }
            }
        }
        return sb.toString();
    }
}

import java.util.*;

public class Player implements GameParticipant {
    private ArrayList<Card> hand = new ArrayList<>();
    private int score = 0;

    @Override
    public void addCard(Card card) {
        hand.add(card);
        updateScore();
    }

    public void clearHand() {
        hand.clear();
        score = 0;
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

    @Override
    public int getScore() {
        return score;
    }

    public String getHandAsString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : hand) {
            sb.append(card.toString()).append(", ");
        }
        sb.setLength(sb.length() - 2);
        return sb.toString();
    }
}

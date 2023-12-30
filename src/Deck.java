import java.util.*;

public class Deck {

    private ArrayList<Card> deck;
    
    Deck() {
        deck = new ArrayList<>();
        buildDeck();
        shuffleDeck();
    }

    public void buildDeck() {
        String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] suits = {"C", "D", "H", "S"};

        for (String suit : suits) {
            for (String value : values) {
                deck.add(new Card(value, suit));
            }
        }
    }

    public int size() {
        return deck.size();
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public void printDeck() {
        System.out.println(deck); 
    }

    public Card dealCard() {
        if (!deck.isEmpty()) {
            return deck.remove(deck.size() - 1);
        } else {
            throw new IllegalStateException("No more cards in the deck.");
        }
    }
}

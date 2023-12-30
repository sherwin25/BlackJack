import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import javax.imageio.ImageIO;
import java.io.IOException;

public class BlackJack {
    private Deck deck;
    private Player player;
    private Dealer dealer;
    private boolean gameOver = false;
    private static final int cardWidth = 110; 
    private static final int cardHeight = 154; 

    public BlackJack() {
        deck = new Deck();
        player = new Player();
        dealer = new Dealer();
        deck.shuffleDeck();
        dealInitialCards();
    }

    public void dealInitialCards() {
        player.addCard(deck.dealCard());
        player.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());
    }

    public void playerHit() {
        player.addCard(deck.dealCard());
        if (player.getScore() > 21) {
            gameOver = true; 
        }
    }

    public void dealerTurn() {
        while (dealer.shouldHit()) {
            dealer.addCard(deck.dealCard());
        }
        gameOver = true;
    }

    public String determineOutcome() {
        if (player.getScore() > 21) {
            return "You busted. Dealer wins.";
        } else if (dealer.getScore() > 21) {
            return "Dealer busts. You win!";
        } else if (player.getScore() > dealer.getScore()) {
            return "You win!";
        } else if (player.getScore() < dealer.getScore()) {
            return "Dealer wins.";
        } else {
            return "It's a tie!";
        }
    }

    public List<Card> getDealerHand(boolean hideFirstCard) {
        List<Card> handCopy = new ArrayList<>(this.dealer.getHand());
        if (hideFirstCard && !handCopy.isEmpty()) {
            handCopy.set(0, new Card("BACK", "P")); // Use "P" for pattern. This will be ignored when "BACK" is the value.
        }
        return handCopy;
    }

    public void newGame() {
        if (deck.size() < 15) {
            deck = new Deck();
            deck.shuffleDeck();
        }

        player.clearHand();
        dealer.clearHand();
        dealInitialCards();
        gameOver = false;
    }

    public List<Card> getPlayerHand() {
        return player.getHand();
    }

    public int getDealerScore() {
        return dealer.getScore();
    }

    public int getPlayerScore() {
        return player.getScore();
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void hit() {
        if (!gameOver) {
            player.addCard(deck.dealCard());
            if (player.getScore() > 21) {
                gameOver = true; 
            }
        }
    }

    public void stay() {
        if (!gameOver) {
            while (dealer.shouldHit()) {
                dealer.addCard(deck.dealCard());
            }
            gameOver = true;
        }
    }

    public void draw(Graphics g, int width, int height) {
        List<Card> dealerHand = getDealerHand(!gameOver); // Hide the first card if the game isn't over
        for (int i = 0; i < dealerHand.size(); i++) {
            Card card = dealerHand.get(i);
            drawCard(g, card, i, false); // false since it's the dealer's hand
        }

        List<Card> playerHand = getPlayerHand();
        for (int i = 0; i < playerHand.size(); i++) {
            Card card = playerHand.get(i);
            drawCard(g, card, i, true);
        }

        if (gameOver) {
            String message = determineOutcome();
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.setColor(Color.WHITE);
            FontMetrics metrics = g.getFontMetrics();
            int x = (width - metrics.stringWidth(message)) / 2;
            int y = (height - metrics.getHeight()) / 2 + metrics.getAscent();
            g.drawString(message, x, y);
        }
    }

    private void drawCard(Graphics g, Card card, int cardIndex, boolean isPlayer) {
        int x = 20 + (cardIndex * (cardWidth + 5));
        int y = isPlayer ? 350 : 20;
        try {
            Image img;
            if ("BACK".equals(card.getValue())) { // Use the method getValue() to get the card value
                img = ImageIO.read(getClass().getResource("/cards/BACK.png"));
            } else {
                img = ImageIO.read(getClass().getResource(card.getImagePath()));
            }
            g.drawImage(img.getScaledInstance(cardWidth, cardHeight, Image.SCALE_SMOOTH), x, y, null);
        } catch (IOException e) {
            System.err.println("Error loading image for card " + card + ": " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.err.println("Error with image path: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

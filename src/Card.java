public class Card {
    String value;
    String suit;

    Card(String value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    public int getCardValue() {
        switch (value) {
            case "A":
                return 11; // Aces initially count as 11
            case "K":
            case "Q":
            case "J":
                return 10; // Face cards count as 10
            default:
                return Integer.parseInt(value); // Number cards count as their value
        }
    }

    public String getImagePath() {
        if ("BACK".equals(this.value)) {
            return "/cards/BACK.png";
        } else {
            return "/cards/" + this.value + "-" + this.suit + ".png";
        }
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value + "-" + suit;
    }
}

package club.banyuan;

public class Player {

    private String role;

    private Card[] cards;

    private int left;

    public Player(String role, Card[] cards) {
        this.role = role;
        this.cards = cards;
    }

    // get set

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Card[] getCards() {
        return cards;
    }
    public void setCards(Card[] cards) {
        this.cards = cards;
    }

    public int getLeft() {
        return left;
    }

    public void receiveCard(Card card) {
        cards[left++] = card;
    }
}

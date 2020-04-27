package club.banyuan;

public class Player {
    private String role;

    private Card[] cards;

    private int left;

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

    public void setLeft(int left) {
        this.left = left;
    }

    public int getLeft() {
        return left;
    }
}

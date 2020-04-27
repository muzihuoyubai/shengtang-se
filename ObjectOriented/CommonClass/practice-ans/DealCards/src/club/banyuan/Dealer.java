package club.banyuan;

public class Dealer {

    public static final int LORD_CARDS = 3;
    public static final int NORMAL_CARDS = 17;

    public void shuffleCards(Card[] cards) {
        // 洗牌
        for (int i = 0; i < cards.length ; i++ ) {
            int randIndex = (int)(Math.random() * cards.length);
            Card temp = cards[randIndex];
            cards[randIndex] = cards[i];
            cards[i] = temp;
        }
    }

    public void dealCards(Card[] cards, Player[] players) {
        for (int i = 0; i < Card.CARDS_TOTAL - LORD_CARDS; ) {
            for (int p = 0; p < players.length; p++, i++) {
                Player player = players[p];
                player.receiveCard(cards[i]);
            }
        }


        for (Player one : players) {
            if ("地主".equals(one.getRole())) {
                for (int i = 0; i < LORD_CARDS; i++) {
                    one.receiveCard(cards[Card.CARDS_TOTAL - LORD_CARDS - i]);
                }

            }
        }
    }
}
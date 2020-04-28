package club.banyuan;

public class Card {

    public static final String [] FACE_VAL = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    public static final String [] PATTERN_VAL = {"红桃", "黑桃", "梅花", "方块"};
    public static final int CARDS_TOTAL = 54;


    private String face;
    private String pattern;
    private String joker;

    public Card(String face, String pattern) {
        this.face = face;
        this.pattern = pattern;
    }

    public Card(String joker) {
        this.joker = joker;
    }

    // get set

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public void setJoker(String joker) {
        this.joker = joker;
    }

    public String getJoker() {
        return joker;
    }

    public String toString() {
        if (joker != null) {
            return joker;
        }
        return pattern + face;
    }

    // 创建牌组
    public static Card[] initCards() {
        Card[] cardArr = new Card[CARDS_TOTAL];

        int index = 0;
        for (int p = 0; p < PATTERN_VAL.length; p++) {
            for (int f = 0; f < FACE_VAL.length; f++) {
                Card card = new Card(FACE_VAL[f], PATTERN_VAL[p]);
                cardArr[index++] = card;
            }
        }

        cardArr[52] = new Card("大王");
        cardArr[53] = new Card("小王");
        return cardArr;
    }
}
package club.banyuan;

public class Card {
    private String face;
    private String pattern;
    private String joker;

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
}
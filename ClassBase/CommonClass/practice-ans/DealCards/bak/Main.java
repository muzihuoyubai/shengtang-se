package club.banyuan;

import java.util.Arrays;

public class Main {
// 每张牌有牌面(A,2,3,4,5,6,7,8,9,10,J,Q,K)
// 每张牌的花色(红桃、黑桃、梅花、方块)
// 大王、小王

    static String [] face_val = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    static String [] pattern_val = {"红桃", "黑桃", "梅花", "方块"};


    public static void main(String[] args) {

        Card[] cardArr = new Card[54];

        // 创建牌组
        int index = 0;
        // for (int index = 0; index < cardArr.length ; index ++ ) {
        for (int p = 0; p < pattern_val.length; p++) {
            for (int f = 0; f < face_val.length; f++) {
                Card card = new Card();
                card.setFace(face_val[f]);
                card.setPattern(pattern_val[p]);
                cardArr[index++] = card;
            }
        }
        // }
        Card bigJoker = new Card();
        bigJoker.setJoker("大王");

        Card smallJoker = new Card();
        smallJoker.setJoker("小王");

        cardArr[52] = bigJoker;
        cardArr[53] = smallJoker;
        System.out.println("=======牌组==========");
        System.out.println(Arrays.toString(cardArr));

        // 洗牌
        for (int i = 0; i < cardArr.length ; i++ ) {
            int randIndex = (int)(Math.random() * cardArr.length);
            Card temp = cardArr[randIndex];
            cardArr[randIndex] = cardArr[i];
            cardArr[i] = temp;
        }


        // System.out.println(Arrays.toString(cardArr));


        // 发牌
        Player lord = new Player();
        lord.setRole("地主");
        lord.setCards(new Card[20]);

        Player farmer1 = new Player();
        farmer1.setRole("农民");
        farmer1.setCards(new Card[17]);

        Player farmer2 = new Player();
        farmer2.setRole("农民");
        farmer2.setCards(new Card[17]);

        Player[] playerArr = new Player[3];
        playerArr[0] = lord;
        playerArr[1] = farmer1;
        playerArr[2] = farmer2;

        for (int i = 0; i < 51 ; ) {
            for (int p = 0; p < playerArr.length; p++, i++) {
                Player player = playerArr[p];
                player.getCards()[player.getLeft()] = cardArr[i];
                player.setLeft(player.getLeft() + 1);
            }
        }

        lord.getCards()[17] = cardArr[51];
        lord.getCards()[18] = cardArr[52];
        lord.getCards()[19] = cardArr[53];


        // 遍历数组
        for (String one : playerArr[0].getCards()) {
            System.out.println(one.toString());
        }

        System.out.println(Arrays.toString(playerArr[0].getCards()));
        System.out.println(Arrays.toString(playerArr[1].getCards()));
        System.out.println(Arrays.toString(playerArr[2].getCards()));

    }

}





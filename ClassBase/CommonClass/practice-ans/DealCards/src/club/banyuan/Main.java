package club.banyuan;

import java.util.Arrays;

public class Main {
// 每张牌有牌面(A,2,3,4,5,6,7,8,9,10,J,Q,K)
// 每张牌的花色(红桃、黑桃、梅花、方块)
// 大王、小王


    public static void main(String[] args) {

        Player[] playerArr = new Player[3];
        playerArr[0] = new Player("地主", new Card[Dealer.LORD_CARDS + Dealer.NORMAL_CARDS]);
        playerArr[1] = new Player("农民", new Card[Dealer.NORMAL_CARDS]);
        playerArr[2] = new Player("农民", new Card[Dealer.NORMAL_CARDS]);

        Card[] cards = Card.initCards();
        Dealer dealer = new Dealer();
        dealer.shuffleCards(cards);
        dealer.dealCards(cards, playerArr);

        System.out.println(Arrays.toString(playerArr[0].getCards()));
        System.out.println(Arrays.toString(playerArr[1].getCards()));
        System.out.println(Arrays.toString(playerArr[2].getCards()));

    }

}





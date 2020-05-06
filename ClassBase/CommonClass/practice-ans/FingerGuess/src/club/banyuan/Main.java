package club.banyuan;

import java.util.Scanner;

public class Main {

  // TODO
  // 1. 如果用户随意输入内容，不满足条件的，提示用户重新输入
  // 2. 用户输入多少人参与猜拳（2~5人）提示，输入0退出程序
  // 3. 用户猜拳界面，输入0，返回到上一级，重新开始选择参与人数
  // 4. 用户进入到猜拳界面，提示当前的人数的信息，例如"当前游戏3人猜拳"，每次猜拳下一轮开始时，显示本轮剩余玩家数量，
  public static void main(String[] args) {
    System.out.println("用户输入多少人参与猜拳（2~5人）");
    Scanner scanner = new Scanner(System.in);
    int playerCount = scanner.nextInt();

    Player[] players = Player.initPlayers(playerCount);

    while (true) {
      Rules.showFingers(players);
      String rlt = Rules.competeResult(players);

      if (Rules.isDraw(rlt)) {
        continue;
      } else {
        Rules.outPlayer(players, rlt);
      }
      if (Rules.isFinalWinner(players)) {
        break;
      }
    }
    Rules.printWinner(players);
  }

}

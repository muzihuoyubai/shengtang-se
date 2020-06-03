package tcp.duplex.refine;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Future;

public class ServerInput implements Runnable {

  private List<Socket> socketList;
  private List<Sender> senderList;

  public ServerInput(List<Socket> socketList, List<Sender> senderList) {
    this.socketList = socketList;
    this.senderList = senderList;
  }

  @Override
  public void run() {
    Scanner scanner = new Scanner(System.in);

    while (scanner.hasNext()) {
      String input = scanner.nextLine();
      if (input.trim().length() == 0) {
        // 过滤空行
        continue;
      }
      if ("quit".equals(input)) {
        System.out.println("退出");
        socketList.forEach(t -> {
          try {
            t.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        });
        senderList.forEach(t -> t.getFuture().cancel(true));
        break;
      }
      senderList.forEach(t -> t.setMessage(input.getBytes()));
    }
  }
}

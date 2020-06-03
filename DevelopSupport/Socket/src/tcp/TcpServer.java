package tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

  public static void main(String[] args) {
    try {
      System.out.println("启动服务端");
      ServerSocket serverSocket = new ServerSocket(10000);
      while (true){
        System.out.println("等待客户端连接");
        Socket socket = serverSocket.accept();
        String hostAddress = socket.getInetAddress().getHostAddress();
        System.out.println(hostAddress + " 客户端接入。。");

        InputStream inputStream = socket.getInputStream();
        byte[] bytes = inputStream.readAllBytes();
        System.out.println("来自客户端的消息:" + new String(bytes));

        // OutputStream outputStream = socket.getOutputStream();
        // outputStream.write("消息收到了!".getBytes());
        Thread.sleep(10000);
      }

    } catch (IOException  e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("服务器退出");
  }
}

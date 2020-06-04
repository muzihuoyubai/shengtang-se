package club.banyuan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class CipherClient {

  public static void main(String[] args) {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
        CipherClient.class.getResourceAsStream("/alice.code")));
    // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
    //     CipherClient.class.getResourceAsStream("/alice.code.decode")));

    try {
      Socket socket = new Socket("127.0.0.1", 10000);
      List<String> lines = new ArrayList<>();
      bufferedReader.lines().forEach(
          lines::add
      );

      BufferedWriter bufferedWriter = new BufferedWriter(
          new OutputStreamWriter(socket.getOutputStream()));

      // bufferedWriter.write("false");
      bufferedWriter.write("true");
      bufferedWriter.newLine();
      System.out.println("行数：" + lines.size());
      bufferedWriter.write(lines.size() + "");
      bufferedWriter.newLine();
      bufferedWriter.flush();
      for (String str : lines) {
        System.out.println("写入:" + str);
        bufferedWriter.write(str);
        bufferedWriter.newLine();
        bufferedWriter.flush();
      }

      BufferedReader socketReader = new BufferedReader(
          new InputStreamReader(socket.getInputStream()));

      for (int i = 0; i < lines.size(); i++) {
        System.out.println(socketReader.readLine());
      }

      System.out.println("程序退出");

    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}

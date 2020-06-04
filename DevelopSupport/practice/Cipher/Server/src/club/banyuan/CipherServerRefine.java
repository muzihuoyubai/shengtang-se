package club.banyuan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class CipherServerRefine {

  public static void main(String[] args) {

    try (ServerSocket serverSocket = new ServerSocket(10000)) {
      while (true) {
        System.out.println("等待服务器接入");
        Socket socket = serverSocket.accept();
        String hostAddress = socket.getInetAddress().getHostAddress();
        System.out.println(hostAddress + "接入服务器。。");

        BufferedReader bufferedReader = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));
        boolean isEncode = Boolean.parseBoolean(bufferedReader.readLine());
        System.out.println("加解密：" + isEncode);
        int length = Integer.parseInt(bufferedReader.readLine());
        System.out.println("长度：" + length);
        List<String> rlt = new ArrayList<>();
        // StringBuilder stringBuilder = new StringBuilder();
        while (length != 0) {
          String temp = bufferedReader.readLine();
          if (temp == null) {
            throw new RuntimeException("内容不合法");
          }
          StringBuilder stringBuilder = new StringBuilder();
          if (isEncode) {
            for (char c : temp.toCharArray()) {
              stringBuilder.append(CipherUtil.caesarEncode(c));
            }
          } else {
            for (char c : temp.toCharArray()) {
              stringBuilder.append(CipherUtil.caesarDecode(c));
            }
          }
          // stringBuilder.append(System.lineSeparator());
          rlt.add(stringBuilder.toString());
          length--;
        }

        System.out.println("读取结束，准备写入");
        BufferedWriter bufferedWriter = new BufferedWriter(
            new OutputStreamWriter(socket.getOutputStream()));

        // bufferedWriter.write(stringBuilder.toString());
        // bufferedWriter.flush();
        for (String s : rlt) {
          bufferedWriter.write(s);
          bufferedWriter.newLine();
          bufferedWriter.flush();
        }

        // byte[] head = new byte[5];
        // int count = inputStream.read(head);
        // if (count < head.length) {
        //   throw new RuntimeException("head 不合法");
        // }

        // byte[] lengthHead = Arrays.copyOfRange(head, 1, head.length);
        // int remain = CipherUtil.parse(lengthHead);
        //
        // byte[] buf = new byte[1024];
        // StringBuilder stringBuilder = new StringBuilder();
        // while (remain != 0) {
        //   int read = inputStream.read(buf, 0, Math.min(remain, buf.length));
        //
        //   stringBuilder.append()
        //   remain -= read;
        // }
      }


    } catch (IOException e) {
      e.printStackTrace();
    }


  }
}

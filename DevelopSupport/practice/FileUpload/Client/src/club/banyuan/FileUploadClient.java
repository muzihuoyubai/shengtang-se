package club.banyuan;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class FileUploadClient {

  public static void main(String[] args) {
    InputStream resourceAsStream = FileUploadClient.class.getResourceAsStream("/alice.code");
    try {
      Socket socket = new Socket("127.0.0.1", 10000);

      OutputStream outputStream = socket.getOutputStream();
      byte[] bytes = "alice.code".getBytes();
      outputStream.write(BytesUtil.parse(bytes.length));
      outputStream.write(bytes);
      System.out.println("文件长度：" + resourceAsStream.available());
      outputStream.write(BytesUtil.parse(resourceAsStream.available()));
      byte[] buf = new byte[1024];
      int count = resourceAsStream.read(buf);
      while (count != -1) {
        outputStream.write(buf, 0, count);
        count = resourceAsStream.read(buf);
      }

      System.out.println("程序退出");

    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}

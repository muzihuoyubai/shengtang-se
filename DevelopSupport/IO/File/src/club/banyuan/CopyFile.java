package club.banyuan;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {

  public static void main(String[] args) {
    String sourceFilePath = "";
    String targetFilePath = "";

    File sourceFile = new File(sourceFilePath);
    File targetFile = new File(targetFilePath);

    try (
        FileInputStream fileInputStream = new FileInputStream(sourceFile);
        FileOutputStream fileOutputStream = new FileOutputStream(targetFile)
    ) {
      // fileInputStream = 2000
      // byte[] temp = new byte[1024];
      // int count = fileInputStream.read(temp);
      // // fileInputStream = 2000 -1024 = 976
      //
      // fileOutputStream.write(temp);
      // fileOutputStream.flush();
      //
      // // fileInputStream = 976
      // count = fileInputStream.read(temp);
      // // count = 976
      // // fileInputStream = 0
      // fileOutputStream.write(temp, 0, count);
      // fileOutputStream.flush();

      // byte[] bytes = fileInputStream.readAllBytes();
      // fileOutputStream.write(bytes);
      // 开始复制。。。
      // 1%
      // 10%
      // 18%
      // 33%
      // 80%
      // 100%
      // 复制完成
      byte[] temp = new byte[1024];
      int count;
      do {
        count = fileInputStream.read(temp);
        if (count != -1) {
          fileOutputStream.write(temp, 0, count);
        }
      } while (count != -1);

      while ((count = fileInputStream.read(temp)) != -1) {
        fileOutputStream.write(temp, 0, count);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}

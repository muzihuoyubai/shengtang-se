package club.banyuan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class EncodeDemo {

  public static void main(String[] args) throws Exception {
    String str = "你好";
    FileOutputStream fileOutputStream = new FileOutputStream(new File("encodefile.txt"));
    fileOutputStream.write(str.getBytes("GBK"));
    fileOutputStream.close();

    FileInputStream inputStream = new FileInputStream(new File("encodefile.txt"));
    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,
        "GBK")
    );
    System.out.println(reader.readLine());

    for (byte aByte : str.getBytes(StandardCharsets.UTF_8)) {
      System.out.printf("%x", aByte);
    }
    System.out.println();

    for (byte aByte : str.getBytes("GBK")) {
      System.out.printf("%x", aByte);
    }
  }
}

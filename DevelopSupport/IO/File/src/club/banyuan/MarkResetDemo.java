package club.banyuan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 当调用mark(readlimit)方法在流当中设置一个标记后，接下来最多只能读readlimit个字节，
 * 否则标记就可能失效。标记失效意味着调用reset方法后会产生一个异常。
 * <p>
 * 当用户调用mark(readlimit)方法设置标记后，
 * 如果readlimit小于缓存buf的大小，则只有读取超过buf.size大小字节后，mark标记才会失效；
 * 如果readlimit大于缓存buf的大小，则只有读取超过readlimit大小字节后，mark标记才会失效.
 * 也就是说只有读取的字节数 > Math.max(readlimit,buf,size)后，mark标记才会失效。
 * 这只是BufferedInputSteam类的算法。无法确保其它输入流也是如此算法。所以为确保mark标记的有效，最好将读取的字节数限定在readlimit以内
 */
public class MarkResetDemo {

  public static void main(String[] args) throws Exception {
    String str = "1234567890";
    FileOutputStream fileOutputStream = new FileOutputStream(new File("encodefile.txt"));
    fileOutputStream.write(str.getBytes());
    fileOutputStream.close();

    FileInputStream inputStream = new FileInputStream(new File("encodefile.txt"));
    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream)
    );
    System.out.printf("%c", reader.read());
    reader.mark(6);
    System.out.printf("%c", reader.read());
    System.out.printf("%c", reader.read());
    System.out.printf("%c", reader.read());
    System.out.printf("%c", reader.read());
    System.out.printf("%c", reader.read());
    System.out.printf("%c", reader.read());
    System.out.printf("%c", reader.read());
    reader.reset();
    System.out.printf("%c", reader.read());
  }
}

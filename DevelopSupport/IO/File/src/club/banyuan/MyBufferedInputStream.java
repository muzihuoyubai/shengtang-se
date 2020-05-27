package club.banyuan;

import java.io.IOException;
import java.io.InputStream;

public class MyBufferedInputStream extends InputStream {

  private byte[] buf = new byte[1024 * 4];

  /**
   * 记录缓冲区还有多少数据
   */
  private int count = 0;

  /**
   * 缓冲区读取到的数据位置
   */
  private int pos = 0;

  private InputStream inputStream;

  public MyBufferedInputStream(InputStream inputStream) {
    this.inputStream = inputStream;
  }

  @Override
  public int read() throws IOException {
    try {
      if (count > 0) {
        count--;
        return buf[pos++] & 0xFF;
      } else {
        // 0~255 -1
        count = inputStream.read(buf);
        pos = 0;
        if (count > 0) {
          count--;
          return buf[pos++] & 0xFF;
        } else {
          return -1;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  @Override
  public int read(byte[] b) throws IOException {
    int rlt;
    if (count == 0 && inputStream.available() == 0) {
      return -1;
    }
    if (b.length > buf.length) {
      System.arraycopy(buf, pos, b, 0, count);
      byte[] temp = new byte[b.length - buf.length];
      int readCount = inputStream.read(temp);
      if (readCount > 0) {
        System.arraycopy(temp, 0, b, count, readCount);
        rlt = count + readCount;
      } else {
        rlt = count;
      }
      count = 0;
      pos = 0;
      return rlt;
    } else {
      System.arraycopy(buf, pos, b, 0, Math.min(count, b.length));
      if (b.length > count) {
        int readCount = inputStream.read(buf);
        if (readCount > 0) {
          System.arraycopy(buf, 0, b, count, Math.min(readCount, b.length - count));
          rlt = Math.min(count, b.length) + Math.min(readCount, b.length - count);
          pos = b.length - count;
          count = readCount - (b.length - count);
        } else {
          rlt = Math.min(count, b.length);
          count = 0;
          pos = 0;
        }
      } else {
        count = count - b.length;
        pos += b.length;
        rlt = b.length;
      }
    }
    return rlt;
  }

  // 0x00 ~ 0xFF
  // 0xFF => 0xFFFFFFFF

  //                            00000000
  // 00000000 00000000 00000000 00000000
  //                            10101110  原始值
  // 11111111 11111111 11111111 10101110  实际值
  //&00000000 00000000 00000000 11111111
  // 00000000 00000000 00000000 10101110  希望的
  public static void main(String[] args) {
    byte b = (byte) 0x01;
    System.out.println(b);
    System.out.println((int) b);

    byte b1 = (byte) 0xFE;
    System.out.println(b1);
    System.out.println((int) b1);
  }
}

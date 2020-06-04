package club.banyuan;

/**
 * 使用凯撒密码对英文的文本文件进行加密。
 * 凯撒密码是一种替换加密的技术，用于加密英文文本。
 * 将字母表上向后（或向前）按照一个固定数目进行偏移。使用偏移后的字母替换原始字母实现加密。
 * 例如，当偏移量是3的时候，所有的字母A将被替换成D，B变成E，以此类推。
 */

public class BytesUtil {
  public static int parse(byte[] bytes) {
    int rlt = 0;
    for (byte aByte : bytes) {
      rlt <<= 8;
      rlt |= (0xFF & aByte);
    }
    return rlt;
  }

  public static byte[] parse(int target) {
    byte[] bytes = new byte[4];
    for (int i = bytes.length - 1; i >= 0; i--) {
      bytes[i] = (byte) (target & 0xFF);
      target >>= 8;
    }

    return bytes;
  }


}



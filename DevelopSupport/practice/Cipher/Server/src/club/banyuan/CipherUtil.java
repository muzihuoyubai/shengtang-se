package club.banyuan;

/**
 * 使用凯撒密码对英文的文本文件进行加密。
 * 凯撒密码是一种替换加密的技术，用于加密英文文本。
 * 将字母表上向后（或向前）按照一个固定数目进行偏移。使用偏移后的字母替换原始字母实现加密。
 * 例如，当偏移量是3的时候，所有的字母A将被替换成D，B变成E，以此类推。
 */

public class CipherUtil {

  public static final int FIRST_UPPER = 65;
  public static final int FIRST_LOWER = 97;
  public static final int NUM_CHARS = 26;
  public static final int OFFSET = 3;

  /**
   * 通过字母表偏移量对字母进行加密
   *
   * @param ch
   * @return
   */
  public static char caesarEncode(char ch) {

    if (Character.isUpperCase(ch)) {
      return (char) ((ch - FIRST_UPPER + OFFSET) % NUM_CHARS + FIRST_UPPER);
    } else if (Character.isLowerCase(ch)) {
      return (char) ((ch - FIRST_LOWER + OFFSET) % NUM_CHARS + FIRST_LOWER);
    } else {
      return ch;
    }
  }

  public static char caesarDecode(char ch) {
    if (Character.isUpperCase(ch)) {
      return (char) ((ch - CipherUtil.FIRST_UPPER + CipherUtil.NUM_CHARS - CipherUtil.OFFSET)
          % CipherUtil.NUM_CHARS
          + CipherUtil.FIRST_UPPER);
    } else if (Character.isLowerCase(ch)) {
      return (char) ((ch - CipherUtil.FIRST_LOWER + CipherUtil.NUM_CHARS - CipherUtil.OFFSET)
          % CipherUtil.NUM_CHARS
          + CipherUtil.FIRST_LOWER);
    } else {
      return ch;
    }
  }

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



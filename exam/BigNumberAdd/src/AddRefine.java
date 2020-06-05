// import java.util.Math;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.junit.Assert;
import org.junit.Test;

public class AddRefine {

  public static String add(String digital1, String digital2) {
    // 从末尾开始起逐个char 相加，判断是否有进位，如果进位，下一次相加结果再加1
    // 先把短的前面补齐0，之后再相加
    if (digital1.length() > digital2.length()) {
      int interval = digital1.length() - digital2.length();
      for (int i = 0; i < interval; i++) {
        digital2 = "0" + digital2;
      }
    } else {
      int interval = digital2.length() - digital1.length();
      for (int i = 0; i < interval; i++) {
        digital1 = "0" + digital1;
      }
    }

    int length = digital1.length();
    boolean isIncrease = false;
    String rlt = "";

    for (int i = 0; i < length; i++) {
      int one = digital1.charAt(digital1.length() - 1 - i) - '0';
      int two = digital2.charAt(digital2.length() - 1 - i) - '0';
      int sum = one + two;
      if (isIncrease) {
        sum++;
      }

      if (sum >= 10) {
        isIncrease = true;
        sum %= 10;
      } else {
        isIncrease = false;
      }
      rlt = sum + rlt;
    }

    if (isIncrease) {
      rlt = "1" + rlt;
    }
    return rlt;
  }

  // public static void main(String[] args) {
  //   System.out.println(add("92345", "54321"));
  // }

  @Test
  public void test() {
    System.out.println(2.0 - 1.1);
    BigDecimal bigDecimal = new BigDecimal("2.0");
    BigDecimal bigDecimal1 = new BigDecimal("1.1");

    System.out.println(bigDecimal.subtract(bigDecimal1));


    //
    //
    // String one = "9999999999999999999";
    // String two = "9999999999999999999";
    //
    // Assert.assertEquals(add(one, two), bigIntegerAdd(one, two));
    //
    // one = "9999999999999";
    // two = "9999999999999999999";
    // Assert.assertEquals(add(one, two), bigIntegerAdd(one, two));
    //
    // two = "9999999999999";
    // one = "9999999999999999999";
    // Assert.assertEquals(add(one, two), bigIntegerAdd(one, two));
    //
    // one = "19999999999999";
    // two = "9999999999999999999";
    // Assert.assertEquals(add(one, two), bigIntegerAdd(one, two));

  }

  private String bigIntegerAdd(String one, String two) {
    BigInteger bigInteger = new BigInteger(one);
    BigInteger bigInteger1 = new BigInteger(two);
    return bigInteger.add(bigInteger1).toString();
  }
}













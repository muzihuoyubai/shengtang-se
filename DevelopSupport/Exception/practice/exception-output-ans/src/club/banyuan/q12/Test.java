package club.banyuan.q12;

public class Test {

  private static String result = "";

  public static void main(String[] args) {
    test(1); // 0.
    result += "*";  //5. 1245*
    test(0); // 6.
    System.out.println(result);
  }

  public static void test(int i) {
    result += "1"; // 1. 1   // 7. 1245*1
    try {
      if (i == 0) {
        throw new RuntimeException(""); // 8.
      }
      result += "2"; // 2. 12
    } catch (Exception e) {
      result += "3"; // 9. 1245*13
      return;
    } finally {
      result += "4"; // 3. 124 // 10.1245*134
    }
    result += "5"; // 4. 1245
  }
}
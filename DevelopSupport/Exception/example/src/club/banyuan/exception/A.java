package club.banyuan.exception;

public class A {

  static void test1() throws Exception {

  }

  static void test2() {
    try {
      test1();
    } catch (Exception e) {
      e.printStackTrace();
      // throw  new RuntimeException();
    }
  }
}

package club.banyuan.exception;

public class Demo {

  public static void main(String[] args) {

    System.out.println("main 1");
    try {

      // throw new IllegalArgumentException();
      testException();
      return;
      // System.out.println("main 3");
    } catch (NullPointerException e) {
      System.out.println("catch ");
      return ;
    } catch (IllegalArgumentException e) {
      System.out.println("catch illegal");
    }
    System.out.println("main 2");


  }

  static void testException() {
    // System.out.println("test 1");
    throw new IllegalArgumentException("IllegalArgumentException");
    // System.out.println(2);
  }
}

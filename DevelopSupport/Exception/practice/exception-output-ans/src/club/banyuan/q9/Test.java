package club.banyuan.q9;

public class Test {

  public int myMethod() {

    try {
      System.out.println(1);
      throw new Exception();
      // return 1;
    } catch (Exception e) {
      System.out.println(2);
      throw new RuntimeException("test");
      // return 2;
    } finally {
      System.out.println(3);
      return 3; // 如果finally中有return，返回值以final的为准
      // 如果finally中有return，则catch中抛出的异常将会被吃掉，最终不会被抛出
    }
  }

  public static void main(String[] args) {
    Test test = new Test();
    int rlt = test.myMethod();
    System.out.println("rlt=" + rlt);
  }
}

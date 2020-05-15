package club.banyuan.q2;

class Test extends Exception {

}

class Main {

  public static void main(String args[]) {
    try {
      throw new Test();
    } catch (Test t) {
      System.out.println("Got the Test Exception");
      // finally中的代码在catch语句执行完成之后执行。
      // 如果try语句中没有抛出异常，则finally中的代码在try语句执行之后执行
    } finally {
      System.out.println("Inside finally block ");
    }
  }
}
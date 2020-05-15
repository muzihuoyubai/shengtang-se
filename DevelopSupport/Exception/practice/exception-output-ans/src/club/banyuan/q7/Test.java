package club.banyuan.q7;

class Test {

  String str = "a";

  void A() {
    try {
      str += "b"; // 执行顺序1. ab
      B();  // 执行顺序2.
    } catch (Exception e) {
      str += "c"; // 执行顺序8. abdec
    }
  }

  void B() throws Exception {
    try {
      str += "d"; // 执行顺序3. abd
      C();  // 执行顺序4.
    } catch (Exception e) {
      throw new Exception(); // 执行顺序6.
      // 抛出异常后，之后的代码不会再执行
    } finally {
      // note. 如果catch语句中抛出了异常，finally中的代码还是会执行，执行完成之后方法结束，异常被抛出。
      str += "e"; // 执行顺序7. abde
    }

    str += "f"; // 不执行，因为catch语句中抛出了异常，后续的语句，除了finally中的代码，其他的代码都不执行了

  }

  void C() throws Exception {
    throw new Exception(); // 执行顺序5.
  }

  void display() {
    System.out.println(str);
  }

  public static void main(String[] args) {
    Test object = new Test();
    object.A();
    object.display(); // abdec
  }

}
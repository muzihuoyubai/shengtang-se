package club.banyuan.q17;

class A {

  void methodA1(int i) {
    System.out.println(i++ + i);
  } // 10 + 11

  void methodA2(int i) {
    System.out.println(--i - i--);
  } // 9 - 9
}

class B {

  // 匿名的方式创建了一个A类的子类对象。并且重写了父类A中的两个方法。
  A a = new A() {
    void methodA1(int i) {
      System.out.println(++i + i++);
    } // 11 + 11

    void methodA2(int i) {
      System.out.println(i-- - i);
    } // 10 - 9
  };
}

public class MainClass {

  public static void main(String[] args) {
    A a = new A();

    a.methodA1(10);

    a.methodA2(10);

    B b = new B();

    b.a.methodA1(10);

    b.a.methodA2(10);
  }
}
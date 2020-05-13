package club.banyuan.q9;

class A {

  String s = "AAA";

  void methodA() {
    System.out.println(s);
  }

  static class B {

    // 编译报错，静态内部类中无法直接调用外部类的非静态方法，因为没有外部类对象的引用，因此内部类静态的类在创建对象后，未必有外部类的对象被创建出来
    // 可以使用new A().methodA() 调用外部类的方法。
    void methodB() {
      // methodA();
    }
  }
}
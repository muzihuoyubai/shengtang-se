package club.banyuan.q12;

class A {

  void methodOne() {
    // 方法中定义的类，是局部的内部类。作用域仅限于方法的代码块中。无法方法外部的类使用。
    class B {

      void methodTwo() {
        System.out.println("Method Two");
      }
    }
  }

  // 这里找不到class B
  // void methodThree()
  // {
  //     new B().methodTwo();
  // }
}
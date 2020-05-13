package club.banyuan.q4;

class A {

  class B {
    // 编译报错，非静态的内部类中不允许定义静态的成员和方法。
    //static void methodB()
    // {
    //     System.out.println("Method B");
    // }
  }
}
package club.banyuan.q14;

class A {

  class B {

    {
      System.out.println(1);
    }
    // 内静态内部类中，不允许出现静态域的内容
    // static {
    //   System.out.println(2);
    // }
  }
}
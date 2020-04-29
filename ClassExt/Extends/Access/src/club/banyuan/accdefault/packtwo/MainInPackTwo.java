package club.banyuan.accdefault.packtwo;

import club.banyuan.accdefault.packone.SonInPackOne;

public class MainInPackTwo {

  public static void main(String[] args) {
    SonInPackOne sonInPackOne = new SonInPackOne();
    // 不同包下的类不能访问子类继承的 默认权限 的成员和方法
    // System.out.println(sonInPackOne.fatherField); // 编译报错
    // System.out.println(sonInPackOne.fatherMethod()); // 编译报错

    SonInPackTwo sonInPackTwo = new SonInPackTwo();
    // 不同包下的类不能访问 子类继承的 默认权限 的成员和方法，就算和当前子类同包也不行
    // 因为子类和父类不同包，子类自己也不能访问这些成员和方法
    // System.out.println(sonInPackTwo.fatherField); // 编译报错
    // System.out.println(sonInPackTwo.fatherMethod()); // 编译报错
  }
}

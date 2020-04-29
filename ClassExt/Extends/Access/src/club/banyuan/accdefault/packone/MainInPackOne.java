package club.banyuan.accdefault.packone;

import club.banyuan.accdefault.packtwo.SonInPackTwo;

public class MainInPackOne {

  public static void main(String[] args) {
    SonInPackOne sonInPackOne = new SonInPackOne();

    // 同包下的类可以访问子类继承的 默认权限 的成员和方法
    System.out.println(sonInPackOne.fatherField);
    System.out.println(sonInPackOne.fatherMethod());

    SonInPackTwo sonInPackTwo = new SonInPackTwo();
    // 子类和父类不同包，那么就算当前类和父类同包，也不能透过子类访问父类方法
    // System.out.println(sonInPackTwo.fatherField); // 编译报错
    // System.out.println(sonInPackTwo.fatherMethod()); // 编译报错
  }
}

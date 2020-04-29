package club.banyuan.accprotected.packone;

import club.banyuan.accprotected.packtwo.SonInPackTwo;

public class MainInPackOne {

  public static void main(String[] args) {
    FatherInPackOne fatherInPackOne = new FatherInPackOne();
    SonInPackOne sonInPackOne = new SonInPackOne();
    SonInPackTwo sonInPackTwo = new SonInPackTwo();

    // 同包下的类可以访问 默认权限 的属性和方法
    System.out.println(fatherInPackOne.fatherField);
    System.out.println(fatherInPackOne.fatherMethod());

    // 同包下的类可以访问子类继承的 默认权限 的属性和方法
    System.out.println(sonInPackOne.fatherField);
    System.out.println(sonInPackOne.fatherMethod());
    System.out.println(sonInPackOne.sonMethod());

    // 子类和父类不同包，那么就算当前类和父类同包，也不能透过子类访问父类方法
    // System.out.println(sonInPackTwo.fatherField); // 编译报错
    // System.out.println(sonInPackTwo.fatherMethod()); // 编译报错
  }
}

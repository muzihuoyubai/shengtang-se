package club.banyuan.accprotected.packtwo;

import club.banyuan.accprotected.packone.SonInPackOne;
import club.banyuan.accprotected.packone.FatherInPackOne;

public class MainInPackTwo {

  public static void main(String[] args) {
    FatherInPackOne fatherInPackOne = new FatherInPackOne();
    SonInPackOne sonInPackOne = new SonInPackOne();
    SonInPackTwo sonInPackTwo = new SonInPackTwo();

    // 不同包下的类不能访问 默认权限 的属性和方法
    // System.out.println(fatherInPackOne.fatherField); // 编译报错
    // System.out.println(fatherInPackOne.fatherMethod()); // 编译报错

    // 不同包下的类不能访问子类继承的 默认权限 的属性和方法
    // System.out.println(sonInPackOne.fatherField); // 编译报错
    // System.out.println(sonInPackOne.fatherMethod()); // 编译报错

    // 虽然不能直接访问 默认权限 方法，可以通过子类的public方法间接访问
    System.out.println(sonInPackOne.sonMethod());

    // 不同包下的类不能访问 子类继承的 默认权限 的属性和方法，就算和当前子类同包也不行
    // 因为子类和父类不同包，子类自己也不能访问这些属性和方法
    // System.out.println(sonInPackTwo.fatherField); // 编译报错
    // System.out.println(sonInPackTwo.fatherMethod()); // 编译报错
  }
}

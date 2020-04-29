package club.banyuan.accprotected.packtwo;

import club.banyuan.accprotected.packone.FatherInPackOne;
import club.banyuan.accprotected.packone.SonInPackOne;

public class MainInPackTwo {

  public static void main(String[] args) {
    FatherInPackOne fatherInPackOne = new FatherInPackOne();

    // 不同包下的类不能访问 protected 的成员和方法
    // 编译报错
    // System.out.println(fatherInPackOne.fatherField);
    // System.out.println(fatherInPackOne.fatherMethod());

    SonInPackOne sonInPackOne = new SonInPackOne();
    // 不同包下的类不能访问 子类继承的protected 的成员和方法
    // 编译报错
    // System.out.println(sonInPackOne.fatherField);
    // System.out.println(sonInPackOne.fatherMethod());

    SonInPackTwo sonInPackTwo = new SonInPackTwo();
    // 不同包下的类不能访问 子类继承的protected 的成员和方法，就算和当前子类同包和不行
    // 编译报错
    // System.out.println(sonInPackTwo.fatherField);
    // System.out.println(sonInPackTwo.fatherMethod());
  }
}

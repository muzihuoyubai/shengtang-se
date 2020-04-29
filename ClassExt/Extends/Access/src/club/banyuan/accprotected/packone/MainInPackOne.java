package club.banyuan.accprotected.packone;

import club.banyuan.accprotected.packtwo.SonInPackTwo;

public class MainInPackOne {

  public static void main(String[] args) {
    FatherInPackOne fatherInPackOne = new FatherInPackOne();

    // 同包下的类可以访问 protected 的成员和方法
    System.out.println(fatherInPackOne.fatherField);
    System.out.println(fatherInPackOne.fatherMethod());

    SonInPackOne sonInPackOne = new SonInPackOne();
    // 同包下的类可以访问子类继承的 protected 的成员和方法
    System.out.println(sonInPackOne.fatherField);
    System.out.println(sonInPackOne.fatherMethod());

    // 和父类同包下的类可以访问不同包子类继承的当前包下的父类的 protected 的成员和方法
    SonInPackTwo sonInPackTwo = new SonInPackTwo();
    System.out.println(sonInPackTwo.fatherField);
    System.out.println(sonInPackTwo.fatherMethod());
  }
}

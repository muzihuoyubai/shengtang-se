package club.banyuan.accdefault.packtwo;

import club.banyuan.accdefault.packone.FatherInPackOne;

public class SonInPackTwo extends FatherInPackOne {

  // 子类和父类不同包，无法访问这些成员和方法
  public String getFiled() {
    // 编译报错
    // return "get father filed" + fatherField;
    return "can not get Filed";
  }

  public String callMethod() {
    // 编译报错
    // return "call father method " + fatherMethod();
    return "can not call method";
  }
}

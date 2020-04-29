package club.banyuan.accprotected.packtwo;

import club.banyuan.accprotected.packone.FatherInPackOne;

public class SonInPackTwo extends FatherInPackOne {

  // 子类和父类不同包，可以使用父类中定义的 protected 的成员和方法
  public String getFiled() {
    return "get father filed" + fatherField;
  }

  public String callMethod() {
    return "call father method " + fatherMethod();
  }
}

package club.banyuan.accprotected.packone;

public class SonInPackOne extends FatherInPackOne {

  // 子类和父类同包，可以使用父类中定义的 protected 的成员和方法
  public String getFiled() {
    return "get father filed" + fatherField;
  }

  public String callMethod() {
    return "call father method " + fatherMethod();
  }
}

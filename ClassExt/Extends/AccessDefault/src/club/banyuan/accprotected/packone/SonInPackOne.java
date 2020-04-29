package club.banyuan.accprotected.packone;

public class SonInPackOne extends FatherInPackOne {

  public String sonMethod() {
    System.out.println("sonMethod");
    // 子类和父类同包，可以调用父类 默认权限 的方法
    return fatherMethod();
  }
}

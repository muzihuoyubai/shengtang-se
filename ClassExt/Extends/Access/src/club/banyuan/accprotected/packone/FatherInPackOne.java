package club.banyuan.accprotected.packone;

public class FatherInPackOne {

  // protected 限定只有同包的类或子类才可以访问
  protected String fatherField = "fatherField";

  protected String fatherMethod() {
    return "fatherMethod";
  }
}

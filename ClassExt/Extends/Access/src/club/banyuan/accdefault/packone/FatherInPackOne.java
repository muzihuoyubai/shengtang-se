package club.banyuan.accdefault.packone;

public class FatherInPackOne {

  // 默认限定只有同包的类才可以访问
  String fatherField = "fatherField";

  String fatherMethod() {
    return "fatherMethod";
  }
}

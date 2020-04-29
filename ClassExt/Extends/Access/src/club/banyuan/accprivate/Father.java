package club.banyuan.accprivate;

public class Father {

  // 私有成员，外部不可访问，子类也不能用
  private String fatherField = "fatherField";

  // 私有方法，外部不可访问，子类也不能用
  private String fatherMethod() {
    return "fatherMethod";
  }

  // 提供外部方法用来访问私有成员，将成员隐藏起来
  public String getFatherField() {
    return fatherField;
  }
}

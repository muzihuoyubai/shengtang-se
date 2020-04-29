package club.banyuan.method;

public class Son extends Father {

  @Override
  public String fatherMethod() {
    return "override in son";
  }

  public String sonMethod() {
    // 调用的是子类的方法
    return fatherMethod(); // override in son
  }

  // 调用父类方法
  public String callFatherMethod() {
    return super.fatherMethod(); // father method
  }
}

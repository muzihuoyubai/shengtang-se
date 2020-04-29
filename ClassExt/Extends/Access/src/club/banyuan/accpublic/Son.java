package club.banyuan.accpublic;

public class Son extends Father {

  // 子类内部可以直接使用父类中定义的public成员变量
  public String getFiled() {
    return "get father filed" + fatherField;
  }

  // 子类内部可以直接使用调用父类中定义的public方法
  public String callMethod() {
    return "call father method " + fatherMethod();
  }
}

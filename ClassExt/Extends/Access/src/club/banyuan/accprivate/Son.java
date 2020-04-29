package club.banyuan.accprivate;

public class Son extends Father {

  public String getFiled() {
    // 编译报错，无法访问父类中定义的私有成员
    // return "get father filed" + fatherField;
    // 可以通过父类提供的方法来使用这个成员变量
    return "get father filed：" + getFatherField();
  }

  public String callMethod() {
    // 编译报错，无法访问父类中定义的私有方法
    // return "call father method " + fatherMethod();
    return "call father method：" + getFatherField();
  }
}

package club.banyuan.constructor.specify;

public class Father {

  private String fatherField;

  // 父类中没有提供默认的构造方法
  public Father(String prop) {
    System.out.println("Father(String prop)");
    this.fatherField = prop;
  }
}

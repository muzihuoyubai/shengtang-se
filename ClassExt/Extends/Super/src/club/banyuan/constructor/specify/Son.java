package club.banyuan.constructor.specify;

public class Son extends Father {

  // 父类中没有提供默认的构造方法，如果子类不指定构造方法，则编译报错
  public Son() {
    // 调用构造方法的语句必须在构造函数的第一句
    // System.out.println("Son()");  // 编译报错
    super("default");
    // 调用改了父类的构造方法就不能再调用其他重载的构造方法了
    // this("default"); // 编译报错
    // System.out.println("Son()");
  }

  public Son(String prop) {
    super(prop);
  }
}

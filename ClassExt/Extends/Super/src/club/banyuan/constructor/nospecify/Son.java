package club.banyuan.constructor.nospecify;

public class Son extends Father {

  // 必须保证父类中存在一个无参的构造方法。
  public Son() {
    System.out.println("Son()");
  }
}

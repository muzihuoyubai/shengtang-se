package club.banyuan.constructor.nospecify;

public class Main {

  public static void main(String[] args) {
    // 先打印Father()，说明默认调用了Father的构造方法
    // 然后打印Son()，说明调用完父类的构造方法，再调子类的构造方法
    new Son();
  }
}

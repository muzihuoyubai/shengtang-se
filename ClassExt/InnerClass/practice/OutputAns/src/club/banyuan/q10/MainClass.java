package club.banyuan.q10;

abstract class A {

  // 2. 子类对象创建之前，先调用父类的构造代码块
  {
    System.out.println(1);
  }

  // 1. 父类被加载，先执行父类的静态域的初始化动作
  static {
    System.out.println(2);
  }
}

public class MainClass {
  public static void main(String[] args) {
    // 创建了一个A的子类，并且是内部类（MainClass的内部类）
    A a = new A() {
      // 3. 子类的构造代码块在父类构造代码块调用之后被调用
      {
        System.out.println(3);
      }
    };
  }
}
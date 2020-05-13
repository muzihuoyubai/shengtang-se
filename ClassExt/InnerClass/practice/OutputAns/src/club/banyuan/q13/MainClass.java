package club.banyuan.q13;

class X {

  {
    System.out.println(1);
  }

  static {
    System.out.println(2);
  }

  public X() {
    new Y();
  }

  static class Y {

    {
      System.out.println(3);
    }

    static {
      System.out.println(4);
    }
  }
}

public class MainClass {

  public static void main(String[] args) {
    // X 先被加载，静态代码块执行，输出2， x对象创建，构造代码块执行，输出1
    X x = new X();
    // 然后执行 X构造方法中的new Y() 语句。
    // 该语句将Y 类加载。先执行Y中静态代码块的内容，输出4, 然后执行Y中构造代码块，输出3

    // 然后此new 语句执行，执行Y中的构造代码块，输出3
    X.Y y = new X.Y();
  }
}
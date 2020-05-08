package club.banyuan.q11;

interface One {

  String s = "FINAL";

  String methodONE();
  // default String methodONE() {
  //   System.out.println("Two methodOne");
  //   return "";
  // }
}

interface Two {

  String methodONE();
  // default String methodONE() {
  //   System.out.println("Two methodOne");
  //   return "";
  // }
}

abstract class Three {

  String s = "NOT FINAL";

  public abstract String methodONE();
  // public String methodONE() {
  //   System.out.println("three methodOne");
  //   return s;
  // }
}

// one two 两个接口，都有相同方法的默认实现，则子类必须被强制要求重写该方法
// one two three 都有相同方法的实现，如果three的方法访问权限是public的，则子类可以不需要重写方法，并且子类对象调用的是父类中的方法实现
// 如果three的方法访问权限不是public的，则必须要求子类重写该方法，并且重写后的方法访问权限一定是public

class Four extends Three implements One, Two {

  public String methodONE() {
    String s = super.s + One.s;

    return s;
  }
}

public class MainClass {

  public static void main(String[] args) {
    Four four = new Four();

    System.out.println(four.methodONE());

    One one = four;
    System.out.println(one.s);

    Three three = (Three) one;
    System.out.println(three.s);

    System.out.println(four instanceof One);
    System.out.println(four instanceof Two);
    System.out.println(four instanceof Three);

    // 编译报错，因为歧义，不知道是想要访问One.s还是Three.s
    // System.out.println(four.s);
  }
}

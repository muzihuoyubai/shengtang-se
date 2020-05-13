package club.banyuan.q11;

class A {

  static String s = "AAA";

  class B {

    String s = "BBB";
    // 这里s指代的是BBB，如果想要指代A的s，则需要使用A.s
    void methodB() {
      System.out.println(s);
      // System.out.println(this.s); 这个和s是一回事
      // System.out.println(A.this.s); // 这个可以编译通过，但是不推荐

    }
  }
}

public class MainClass {

  public static void main(String[] args) {
    A a = new A();

    System.out.println(a.s); // AAA 可以替换成A.s

    A.B b = a.new B();

    System.out.println(b.s); // BBB

    b.methodB(); // BBB
  }
}
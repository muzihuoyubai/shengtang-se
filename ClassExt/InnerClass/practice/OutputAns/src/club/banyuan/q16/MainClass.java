package club.banyuan.q16;

class P {

  String s = "PPP";

  {
    System.out.println(s);
  }

  // 如果想要在外部类使用内部类定义的成员变量，需要通过内部类对象来进行使用
  String methodP() {
    class Q {

      String s = P.this.s + "QQQ"; // s = PPPPQQQ

      {
        System.out.println(s); // PPPQQQ
      }
    }

    return new Q().s + s; // PPPQQQ + PPP
  }
}

public class MainClass {

  public static void main(String[] args) {
    P p = new P();

    System.out.println(p.methodP()); // PPPQQPPP
  }
}
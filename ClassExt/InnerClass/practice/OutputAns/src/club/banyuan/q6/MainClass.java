package club.banyuan.q6;

class X {

  static int x = 3131;

  static class Y {

    static int y = x++; // y= 3131 x = 3132

    static class Z {

      static int z = y++; // z = 3131 y = 3132
    }
  }
}

public class MainClass {

  public static void main(String[] args) {
    System.out.println(X.x); // 3131
    System.out.println(X.Y.y); // 3131
    System.out.println(X.Y.Z.z); // 3131

    System.out.println(X.x); // 3132
    System.out.println(X.Y.y); // 3132
    System.out.println(X.Y.Z.z); // 3131
  }
}
package club.banyuan.q3;

class Outer {

  String s1 = "Java";
  String s2 = "2";

  public static void main(String[] args) {
    Outer outer = new Outer();
  }

  Outer() {
    Inner inner = new Inner();
  }

  class Inner {

    String s1 = "Certification";
    String s2 = "Exam";

    Inner() {
      System.out.println(Outer.this.s1);
      System.out.println(this.s1);
      // s2 指代的是内部类的s2，如果访问外部类中定义的s2，则需要Outer.this.s2
      System.out.println(s2);
    }
  }
}
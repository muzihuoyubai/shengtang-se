package club.banyuan.q1;

class Outer {

  public static void main(String[] args) {
    // 编译不通过，需要 new Outer().new Inner()
    // 在静态域中使用内部类的时候，并没有外部类对象被创建出来
    // new Outer().new Inner();
    // new Inner();
  }

  public void test() {
    // 在非静态的方法内部是可以这样创建内部类，因为test被调用的时候，存在一个外部类对象
    new Inner();
  }

  class Inner {

    Inner() {
    }
  }
}
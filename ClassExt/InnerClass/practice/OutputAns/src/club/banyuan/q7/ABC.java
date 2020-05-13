package club.banyuan.q7;

class ABC {

  // 外部类可以直接访问内部类私有域，内部类也可以直接访问外部类私有域
  // 封装对于内部类和外部类之间没有效果。
  public void test() {
    System.out.println(new XYZ().privateI);
  }

  class XYZ {

    private int privateI = 111;
    int i;
  }
}

class Other {

  // XYZ 的i成员依赖于 XYZ的实例，XYZ的实例依赖于ABC的实例，因此需要依次创建出实例进行访问
  public static void main(String[] args) {
    System.out.println(new ABC().new XYZ().i);
  }
}
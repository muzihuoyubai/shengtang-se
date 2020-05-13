package club.banyuan.q8;

// 类A被加载的时候，如果没有调用new B或new C，内部类不会被自动加载。
class A {

  {
    new B();
  }

  static class B {

    // static {
    //   System.out.println("B");
    // }
    {
      // 循环引用，new B的时候new 了A，new A的时候，又去new B 出现循环调用
      new A().new C();
      // 对于new A().new C() 的new A() 是不能省略的。B类的构造代码块被调用的时候，未必创建了A的对象。创建C的对象的时候，必须使用A的对象。
      // 可以将Class B的static移除，这样B创建的时候也必须依赖于A的对象。或者将Class C的前面加上static，这样C的对象的创建就不依赖A对象了
      // new C();
    }
  }

  class C {

    {
      System.out.println("SUCCESS");
    }
  }
}

public class MainClass {

  public static void main(String[] args) {
    new A();
  }
}
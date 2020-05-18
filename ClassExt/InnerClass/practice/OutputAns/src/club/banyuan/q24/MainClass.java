package club.banyuan.q24;

class A {

  abstract class B {

    abstract void method();
  }

  {
    // 在A对象被创建时，执行此构造代码块中的代码，这里的代码创建了一个B的子类，调用其中重写的方法
    new B() {

      @Override
      void method() {
        System.out.println("BBB"); // 这里的代码会被执行
      }
    }.method();
  }
}

public class MainClass {

  public static void main(String[] args) {
    new A();
  }
}
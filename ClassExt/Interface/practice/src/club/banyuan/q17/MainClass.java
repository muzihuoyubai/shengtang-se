package club.banyuan.q17;

class A {

}

class B extends A {

}

class C extends B {

}

interface ABC {

  void method(A a);
}

interface PQR {

  void method(B b);
}

class M implements ABC, PQR {

  public void method(A a) {
    System.out.println(2);
  }

  public void method(B b) {
    System.out.println(3);
  }

  public void methodOverload(ABC abc) {
    System.out.println("abc");
  }

  public void methodOverload(PQR pqr) {
    System.out.println("pqr");
  }
}

public class MainClass {

  public static void main(String[] args) {
    M m = new M();

    m.method(new A());

    m.method(new B());

    m.method(new C());

    // 如果重载的方法中两个方法的入参存在父子关系，那么当传入子类对象或子类对象的子类对象后
    // 调用和传入对象关系较近的子类入参的方法

    // 如果重载方法中两个方法的入参是两个接口类型，如果这两个接口类型没有父子关系
    // 那么在调用重载方法时传入同时实现了这两个接口的类的对象，则会编译报错。除非两个接口存在父子关系，则会调用子类接口对应的重载方法
    // m.methodOverload(new M());
  }
}
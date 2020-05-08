package club.banyuan.q9;

interface ABC {

  void methodOne();
}

interface PQR extends ABC {

  // 这样做也是允许的，可以在接口的default方法中调用抽象方法
  default void methodDefault() {
    methodTwo();
  }

  void methodTwo();
}

// XYZ中具备两个抽象方法 methodOne 和 methodTwo
// 允许重写抽象方法，也可以允许不重写，如果不重写，就需要继承的子类重写。
// 但是抽象类中的方法是可以调用这些抽象方法的。
abstract class XYZ implements PQR {

  public void methodOne() {
    // this = abc
    this.methodTwo();
  }
}

class MNO extends XYZ {

  // 可以在这里重写methodOne方法避免死循环
  // @Override
  // public void methodOne() {
  //
  // }

  // this = abc
  public void methodTwo() {
    this.methodOne();
  }
}

public class MainClass {

  public static void main(String[] args) {
    ABC abc = new MNO();
    // 会出现递归调用导致死循环
    abc.methodOne();

    // 这样调用也会出现死循环
    PQR pqr = new MNO();
    pqr.methodTwo();
  }
}
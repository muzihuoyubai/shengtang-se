package club.banyuan.q8;

class Test {

  int count = 0;

  void A() throws Exception { // 这里的exception可以省略，因为没有向外部抛出该异常
    try {
      count++; // 执行顺序1. count=1
      try {
        count++; // 执行顺序2. count=2
        try {
          count++; // 执行顺序3. count=3
          throw new Exception();
        } catch (Exception ex) {
          count++; // 执行顺序4. count=4
          throw new Exception();
        }
      } catch (Exception ex) {
        count++; // 执行顺序5. count=5
      }
    } catch (Exception ex) {
      count++; // 这里代码不会执行。因为try中包裹的代码块并没有异常抛出，内部抛出的异常已经被catch处理了
    }
  }

  void display() {
    System.out.println(count);
  }

  public static void main(String[] args) throws Exception {
    Test obj = new Test();
    obj.A();
    obj.display(); // 5
  }
}
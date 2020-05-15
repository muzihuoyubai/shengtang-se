package club.banyuan.q5;

class Test {

  public static void main(String[] args) {
    try {
      int a = 0;
      System.out.println("a = " + a);
      int b = 20 / a;
      // 在try代码块中，抛出异常之后的语句不会被执行，将跳转到对应的catch语句块中继续执行
      System.out.println("b = " + b);
    } catch (ArithmeticException e) {
      System.out.println("Divide by zero error");
    } finally {
      System.out.println("inside the finally block");
    }
  }
}
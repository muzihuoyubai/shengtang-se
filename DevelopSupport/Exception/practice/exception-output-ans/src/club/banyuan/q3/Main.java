package club.banyuan.q3;

class Main {

  public static void main(String args[]) {
    int x = 0;
    int y = 10;
    int z = y / x; // 抛出ArithmeticException 异常，这个异常是非受查异常
  }
}
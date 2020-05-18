package club.banyuan.q30;

public class Outer {

  private int data = 10;

  class Inner {

    private int data = 20;

    private int getData() {
      return data;
    }

    public void main(String[] args) {
      Inner inner = new Inner();
      System.out.println(inner.getData());
    }
  }

  private int getData() {
    return data;
  }

  public static void main(String[] args) {
    Outer outer = new Outer();
    Outer.Inner inner = outer.new Inner();
    System.out.printf("%d", outer.getData()); // 10
    inner.main(args); // 20
  }
} 
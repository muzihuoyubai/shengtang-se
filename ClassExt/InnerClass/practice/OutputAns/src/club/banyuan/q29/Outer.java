package club.banyuan.q29;

interface Anonymous {

  public int getValue();
}

public class Outer {

  private int data = 15;

  public static void main(String[] args) {
    Anonymous inner = new Anonymous() {
      int data = 5;

      public int getValue() {
        return data;
      }

      // 匿名内部类中自定义的方法，无法被引用匿名内部类的变量进行调用
      public int getData() {
        return data;
      }
    };
    Outer outer = new Outer();
    // inner的数据类型是 Anonymous，这里面没有定义getData() 方法，因此调用这个方法编译报错
    // System.out.println(inner.getValue() + inner.getData() + outer.data);
  }
} 

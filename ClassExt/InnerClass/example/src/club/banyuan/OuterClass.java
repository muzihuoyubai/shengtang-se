package club.banyuan;

import java.util.HashMap;
import java.util.Map;

public class OuterClass implements OuterInterface {

  private int a;

  public int getA() {
    return a;
  }

  public void setA(int a) {
    this.a = a;
  }

  private int outMethod() {
    System.out.println(this);
    return a;
  }

  @Override
  public void outerMethod() {

  }

  public class InnerClass implements OuterInterface.InnerInterface {

    private int a;

    public void innerMethod() {

      System.out.println(this);
      System.out.println(OuterClass.this);
      // System.out.println(a);
    }

  }

  public static void main(String[] args) {
    OuterInterface.InnerInterface innerInterface = new OuterClass().new InnerClass();
    OuterClass.InnerInterface inner = new OuterClass().new InnerClass();
    // HashMap.Entry
    // Map.Entry

  }

}

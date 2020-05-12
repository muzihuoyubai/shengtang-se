package club.banyuan;

public class OuterClass {

  private int a;
  private int outMethod(){
    System.out.println(this);
    return a;
  }

  public class InnerClass {
    private int a;
    public void innerMethod(){

      System.out.println(this);
      System.out.println(OuterClass.this);
      // System.out.println(a);
    }

  }
  public static void main(String[] args) {
    new OuterClass().new InnerClass().innerMethod();
  }

}

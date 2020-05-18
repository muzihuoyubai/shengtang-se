package club.banyuan.q31;

interface OuterInterface {

  public void InnerMethod();

  public interface InnerInterface {

    public void InnerMethod();
  }
}

public class Outer implements OuterInterface.InnerInterface, OuterInterface {

  public void InnerMethod() {
    System.out.println(100);
  }


  public static void main(String[] args) {
    Outer obj = new Outer();
    obj.InnerMethod();
  }
} 
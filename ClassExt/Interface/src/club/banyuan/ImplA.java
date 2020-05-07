package club.banyuan;

public class ImplA implements InterB, InterC {

  public static void main(String[] args) {

    System.out.println(ImplA.a);
    System.out.println(new ImplA().a);
    System.out.println(InterB.a);
    System.out.println(InterC.a);
    System.out.println(InterA.a);
  }

  @Override
  public void interA() {

  }
}

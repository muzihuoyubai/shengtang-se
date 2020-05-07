package club.banyuan;

public interface InterA {

  int a = 0;
  // void interA();

  default void interA() {
    System.out.println("InterA default");
  }
}

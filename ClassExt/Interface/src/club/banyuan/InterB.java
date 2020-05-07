package club.banyuan;

public interface InterB extends InterA {

  default void interA() {
    System.out.println("InterB impl");
  }

}

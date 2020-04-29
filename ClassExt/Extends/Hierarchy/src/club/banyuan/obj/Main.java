package club.banyuan.obj;

public class Main {

  public static void main(String[] args) {
    Object o1 = new Object();
    Object o2 = new Object();
    System.out.println(o1 == o2);
    System.out.println(o1.toString());
    System.out.println(o2.toString());
    System.out.println(o1.equals(o2));
    System.out.println(o1.hashCode());
    System.out.println(o2.hashCode());
  }
}

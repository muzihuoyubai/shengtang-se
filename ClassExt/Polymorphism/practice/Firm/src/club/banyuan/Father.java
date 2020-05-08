package club.banyuan;

public class Father extends GrandFather {

  public static void grandFatherStaticMethod() {
    System.out.println("father static method");
  }

  private int grandFatherProp;

  public int getGrandFatherProp() {
    return super.grandFatherProp;
  }
  // TODO do something

}

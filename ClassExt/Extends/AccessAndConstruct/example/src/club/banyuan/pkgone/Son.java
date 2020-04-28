package club.banyuan.pkgone;

public class Son extends Father{

  public void sonMethod() {
    // System.out.println(fatherPrivate);
    // System.out.println(fatherDefault);
    // System.out.println(fatherProtected);
    // System.out.println(fatherPublic);

    System.out.println(toString());
    // hashCode();
    equals(null);
  }

  public static void main(String[] args) {
    Son son = new Son();
    son.sonMethod();
  }

  public Son() {
    this("fatherName");
    System.out.println("子类构造方法");
  }

  public Son(String name) {
    // super("fatherName","lastName");
    this(1123);
    System.out.println("子类name构造方法");
  }

  public Son(int age) {
    super();
    // super("fatherName","lastName");
  }
}

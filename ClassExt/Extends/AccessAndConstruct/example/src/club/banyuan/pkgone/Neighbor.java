package club.banyuan.pkgone;

public class Neighbor {

  public void neighborMethod() {
    // Father father = new Father("father");
    // System.out.println(father.fatherDefault);
    // System.out.println(father.fatherProtected);
    // System.out.println(father.fatherPublic);

    Son son = new Son();
    // System.out.println(son.fatherDefault);
    // System.out.println(son.fatherProtected);
    // System.out.println(son.fatherPublic);
  }

  public static void main(String[] args) {
    Son son = new Son(1234);
  }
}

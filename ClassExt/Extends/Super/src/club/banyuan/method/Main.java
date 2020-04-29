package club.banyuan.method;

public class Main {

  public static void main(String[] args) {
    Son son = new Son();
    System.out.println(son.fatherMethod());
    System.out.println(son.sonMethod());
    System.out.println(son.callFatherMethod());
  }
}

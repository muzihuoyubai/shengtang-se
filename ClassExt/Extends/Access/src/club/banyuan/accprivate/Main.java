package club.banyuan.accprivate;

public class Main {

  public static void main(String[] args) {
    Son son = new Son();

    // 编译报错
    // System.out.println(son.fatherField);

    // 编译报错
    // System.out.println(son.fatherMethod());

    System.out.println(son.getFiled());
    System.out.println(son.callMethod());
  }
}

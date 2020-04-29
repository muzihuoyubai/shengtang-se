package club.banyuan.accpublic;

public class Main {

  public static void main(String[] args) {
    Son son = new Son();

    // 通过子类对象访问父类中定义的成员
    System.out.println(son.fatherField);

    // 通过子类对象访问父类中定义的方法
    System.out.println(son.fatherMethod());

    System.out.println(son.getFiled());
    System.out.println(son.callMethod());
  }
}

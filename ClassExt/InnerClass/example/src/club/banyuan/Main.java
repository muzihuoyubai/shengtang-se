package club.banyuan;

import club.banyuan.pkgone.OuterClass;
// import club.banyuan.pkgone.OuterClass.InnerClass;

public class Main {

  public static void main(String[] args) {
    OuterClass outerClass = new OuterClass();
    outerClass.doSomething();
    // InnerClass innerClass = outerClass.new InnerClass();
    // System.out.println(innerClass);
  }
}

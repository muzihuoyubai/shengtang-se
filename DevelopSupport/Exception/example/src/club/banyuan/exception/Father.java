package club.banyuan.exception;

public class Father {

  // 子类中重写的父类方法中异常，子类方法抛出的异常必须是父类方法中异常类或者是其中的子类
  // 或者子类中可以不抛出异常
  public void fatherMethod() throws RuntimeException {
    System.out.println("fatherMethod");
  }

  public static void main(String[] args) {
    Father father = new Son();
    father.fatherMethod();
  }
}

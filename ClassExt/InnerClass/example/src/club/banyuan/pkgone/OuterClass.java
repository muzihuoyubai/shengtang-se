package club.banyuan.pkgone;

// 1. 内部类如何访问外部类的私有成员变量 =》内部类的方法中可以直接使用外部类中定义的私有成员变量
// 2. 内部类是否可以调用外部类的私有方法 =》可以，直接通过方法名即可调用
// 3. 如果外部类方法和内部类方法重名，内部类内部如何调用外部类定义的方法 =》 通过外部类名.this即可访问到外部类的对象，通过该对象即可使用外部类的成员变量和方法。
// 4. 内部类定义的成员变量是否可以使用外部类定义的成员变量进行赋值 =》 可以，如果内部类成员变量和外部类成员变量名相同，则使用外部类名.this.变量名的方式获取外部类中定义的成员变量的值。如果不同名，可以直接使用外部类的成员变量名进行赋值
// 5. 外部类是否可以直接使用内部类中定义的成员变量和方法 => 不能直接调用，需要创建内部类的对象才能使用。
// 6. 内部类对象的构造方法和构造代码块什么时候被触发（外部类new的时候是否会调用）
// 7. 外部类的静态方法（静态方法调用的时候，并未有外部类被创建）中，是否可以通过new内部类对象的方式调用内部类定义的方法
// =》不允许直接new内部类，需要先new 外部类对象再new内部类对象，之后再调用内部类定义的方法
// 8. 非静态内部类中，是否可以定义静态的方法。
// 内部类中不允许有静态的方法或静态成员变量

import club.banyuan.Constant;
import club.banyuan.Constant.Database;

public class OuterClass {
 static String outerClassField = "outerClassField";

  public static int doSomething() {
    InnerClass innerClass = new InnerClass();
    innerClass.innerClassDoSomething();
    return 1;
  }

  public static class InnerClass {
    // String field  = outerClassField;
    static String test;
    public void innerClassDoSomething() {
      System.out.println(doSomething());
      System.out.println(outerClassField);
      System.out.println("innerClassDoSomething");
    }

    public  static void test(){

    }

    // public String getOuterClassField() {
    //   return outerClassField;
    // }

  }

  public static void main(String[] args) {
    OuterClass outerClass = new OuterClass();
    OuterClass.InnerClass.test();
    InnerClass innerClass = new InnerClass();

    new OuterClass.InnerClass().innerClassDoSomething();
    // new OuterClass().new InnerClass();


  }


}

class Main {

  public static void main(String[] args) {
    OuterClass outerClass = new OuterClass();
    // OuterClass.InnerClass innerClass = outerClass.new InnerClass();
    // System.out.println(innerClass);
    // System.out.println(Database.URL_KEY);


  }
}

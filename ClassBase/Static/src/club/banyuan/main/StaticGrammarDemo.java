package club.banyuan.main;

public class StaticGrammarDemo {

  public static int staticInt = 5;

  public static void staticMethod() {
    System.out.println("static method called");
  }

  public static void main(String[] args) {
    // 使用类名访问静态成员
    System.out.println(StaticGrammarDemo.staticInt);  // 5

    // 使用类名访问静态方法
    StaticGrammarDemo.staticMethod(); // static method called
    StaticGrammarDemo grammarDemo = new StaticGrammarDemo();

    // 使用对象访问静态成员，不推荐
    System.out.println(grammarDemo.staticInt); // 5

    // 使用对象访问静态方法，不推荐
    grammarDemo.staticMethod(); // static method called
  }
}

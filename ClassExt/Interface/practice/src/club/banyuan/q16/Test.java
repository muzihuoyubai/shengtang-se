package club.banyuan.q16;

class Father {

}

class Son extends Father {

}

class GrandSon extends Son{

}

public class Test {

  public void testOverload(Son son) {
    System.out.println("son");
  }

  public void testOverload(Father father) {
    System.out.println("father");
  }

  public static void main(String[] args) {
    Test test = new Test();
    Son son = new Son();
    GrandSon grandSon = new GrandSon();
    test.testOverload(son);
    test.testOverload(grandSon);
  }
}

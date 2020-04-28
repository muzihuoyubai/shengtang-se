package demo;

public class ObjConstructDemo {

  {
    System.out.println("initial block 1");
  }

  static {
    System.out.println("static initial block 1");
  }

  private static int staticVariable = staticVariableInit();


  public ObjConstructDemo() {
    this(12);
    System.out.println("constructor ObjConstructDemo");
  }

  public ObjConstructDemo(int variable) {
    this.variable = variable;
  }

  // initial block
  {
    System.out.println("initial block 2");
  }

  static {
    System.out.println("static initial block 2");
  }

  public static void staticMethod() {
    System.out.println("staticMethod");
  }

  public int variableInit() {
    System.out.println("variableInit");
    return 1;
  }

  public static int staticVariableInit() {
    System.out.println("staticVariableInit");
    return 2;
  }


  private int variable = variableInit();
}

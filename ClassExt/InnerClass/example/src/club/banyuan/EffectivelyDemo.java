package club.banyuan;

public class EffectivelyDemo {

  private int a = 15;

  SomeInterface test() {

    int b = 20;
    OuterClass outerClass = new OuterClass();
    outerClass.setA(33);

    SomeInterface someInterface = new SomeInterface() {
      @Override
      public void method() {
        // outerClass = new OuterClass();
        outerClass.setA(50);
        System.out.println(b);
      }

      @Override
      public OuterClass methodClass() {
        return outerClass;
      }

      @Override
      public void otherMethod() {

        EffectivelyDemo.this.a = 35;
        System.out.println(a);
      }
    };
    someInterface.method();
    someInterface.otherMethod();
    return someInterface;
  }

  public static void main(String[] args) {
    EffectivelyDemo effectivelyDemo = new EffectivelyDemo();
    System.out.println(effectivelyDemo.a);
    SomeInterface test = effectivelyDemo.test();
    System.out.println(effectivelyDemo.a);

    OuterClass outerClass = test.methodClass();

  }


}

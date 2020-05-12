package club.banyuan;

// import club.banyuan.pkgone.OuterClass;
// import club.banyuan.pkgone.OuterClass.InnerClass;

public class Main {

  public static void main(String[] args) {
    // OuterClass outerClass = new OuterClass();
    // outerClass.doSomething();
    // InnerClass innerClass = outerClass.new InnerClass();
    // System.out.println(innerClass);

    // SomeInterface someInterface = new SomeInterfaceImpl();
    // someInterface.method();
    // someInterface.otherMethod();
    //
    // SomeInterface someInterfaceOther = new SomeInterfaceOtherImpl();
    // someInterfaceOther.method();
    // someInterfaceOther.otherMethod();
    //
    // process(someInterface);
    // process(someInterfaceOther);

    SomeInterface someInterface = new SomeInterface() {
      @Override
      public void method() {
        System.out.println("anonymous method");
      }

      @Override
      public OuterClass methodClass() {
        return null;
      }

      @Override
      public void otherMethod() {
        System.out.println("anonymous other method");
      }
    };

    SomeInterface someInterface123 = new SomeInterface() {
      @Override
      public void method() {
        System.out.println("anonymous method");
      }

      @Override
      public OuterClass methodClass() {
        return null;
      }

      @Override
      public void otherMethod() {
        System.out.println("anonymous other method");
      }
    };
    System.out.println(someInterface);
    System.out.println(someInterface123);

    someInterface = null;
    // process(someInterface);
  }

  static void process(SomeInterface someInterface) {
    if (System.currentTimeMillis() % 2 == 0) {
      someInterface.otherMethod();
    } else {
      someInterface.method();
    }
  }

  static void process() {
    int  a = 0;
    new SomeInterface() {

      @Override
      public void method() {
        System.out.println(a);
      }

      @Override
      public OuterClass methodClass() {
        return null;
      }

      @Override
      public void otherMethod() {

      }
    }.otherMethod();
  }
}

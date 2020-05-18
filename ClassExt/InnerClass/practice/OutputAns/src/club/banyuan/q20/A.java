package club.banyuan.q20;

class A {

  {
    System.out.println("A");
  }

  class B extends A {

    void test() {
      System.out.println(super.hashCode());
      System.out.println(A.this.hashCode());

    }

    class C extends B {

      class D extends C {

      }
    }
  }

  public static void main(String[] args) {
    new A().new B().test();
  }
}
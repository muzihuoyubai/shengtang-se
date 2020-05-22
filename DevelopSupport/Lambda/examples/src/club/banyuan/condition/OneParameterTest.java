package club.banyuan.condition;

public class OneParameterTest {

  public static void test(){

  }

  void test(OneParameter oneParameter) {
    oneParameter.oneParam(1234);
  }


  public static void main(String[] args) {
    new OneParameterTest().test(Integer::intValue);
    new OneParameterTest().test(System.out::println);
    new OneParameterTest().test(t-> OneParameterTest.test());


  }

  public void nonStaticMethod(){
    new OneParameterTest().test(this::equals);

    new OneParameterTest().test(new OneParameter() {
      @Override
      public void oneParam(Integer integer) {
        this.equals(integer);
      }
    });
  }
}

package club.banyuan.condition;

public class TwoParameterTest {

  void test(TwoParameter twoParameter) {
    twoParameter.twoParam(1234, "1234");
  }


  void receiveTwoParam(Integer integer, String string) {

  }

  public static void main(String[] args) {

    new TwoParameterTest().test((integer, string) -> {
      System.out.println(integer);
      System.out.println(string);
    });

    // 调用第一个参数的方法，传递了第二个参数作为调用的方法参数
    new TwoParameterTest().test(Integer::equals);

    // 调用第二个参数的方法，传递了第一个参数作为调用的方法参数
    new TwoParameterTest().test((integer, string) -> string.equals(integer));
    TwoParameterTest twoParameterTest = new TwoParameterTest();
    new TwoParameterTest().test(twoParameterTest::receiveTwoParam);

  }
}

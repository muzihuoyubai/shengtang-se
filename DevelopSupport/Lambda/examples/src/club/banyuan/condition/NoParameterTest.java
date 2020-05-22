package club.banyuan.condition;

public class NoParameterTest {

  void test(NoParameter noParameter) {
    noParameter.noParam();
  }


  public static void main(String[] args) {
    new NoParameterTest().test(() -> System.out.println("123"));
  }

}

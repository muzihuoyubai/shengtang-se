package club.banyuan.condition;

public class TwoParameterGenericTest {

  <T, R> void test(TwoParameterGeneric<T, R> twoParameterGeneric) {
    T t = (T) new Object();
    R r = (R) new Object();
    twoParameterGeneric.twoParam(t, r);
  }

  public static void main(String[] args) {
    new TwoParameterGenericTest().test((t, r) -> {
      
    });
  }
}

package club.banyuan.q6;

class Test {

  public static void main(String[] args) {
    try {
      int a[] = {1, 2, 3, 4};
      for (int i = 1; i <= 4; i++) {
        // 在抛出异常之前的代码正常执行，抛出异常之后，后续代码将跳转到catch继续执行
        System.out.println("a[" + i + "]=" + a[i] + "n");
      }
    } catch (Exception e) {
      System.out.println("error = " + e);
    }
    // 编译报错，辈分小的异常在catch的排序，应该放到上面，辈分大的放到下面。同辈分的先后无所谓。
    // catch (ArrayIndexOutOfBoundsException e) {
    //   System.out.println("ArrayIndexOutOfBoundsException");
    // }
  }
}
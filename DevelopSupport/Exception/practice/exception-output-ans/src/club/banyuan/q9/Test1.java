package club.banyuan.q9;

public class Test1 {

  public String myMethod() {
    String str = "";
    try {
      str += "try";
      return str; // 最终会返回try字符串，而不是finally修改之后的字符串
    } finally {
      str += "finally";
      System.out.println("code in finally: " + str);
      // return str; // 如果这里有return语句，将返回tryfinally字符串
    }
  }

  public static void main(String[] args) {
    Test1 test = new Test1();
    String rlt = test.myMethod();
    System.out.println("rlt=" + rlt);
  }
}

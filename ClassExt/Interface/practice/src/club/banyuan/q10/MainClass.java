package club.banyuan.q10;

interface X {

  // final的变量值无法被修改
  char c = 'A';

  char methodX();
}

class Y implements X {

  {
    System.out.println(c);
  }

  public char methodX() {
    // 局部变量的值被修改，对接口中定义的c没有任何影响
    char c = this.c;
    return ++c;
  }
}

public class MainClass {

  public static void main(String[] args) {
    Y y = new Y(); // A

    System.out.println(y.methodX()); // B

    System.out.println(y.c); // A

    System.out.println(X.c); // A
  }
}
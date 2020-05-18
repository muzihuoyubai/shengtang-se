package club.banyuan.q22;

class OuterClass {

  static class InnerClass {

    int i;
  }
}

class Main {

  public static void main(String[] args) {
    System.out.println(new OuterClass.InnerClass().i);
  }
}
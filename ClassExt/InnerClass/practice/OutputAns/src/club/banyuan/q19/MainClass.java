package club.banyuan.q19;

class One {

  {
    System.out.println("ONE"); // 2
  }

  class Two {

    {
      System.out.println("TWO"); // 3
    }
  }

  static {
    System.out.println("THREE"); // 1
  }

  static class Three {

    {
      System.out.println("FOUR"); // 5
    }

    static {
      System.out.println("FIVE"); // 4
    }
  }
}

public class MainClass {

  public static void main(String[] args) {
    One one = new One();

    One.Two two = one.new Two();

    One.Three three = new One.Three();
  }
}
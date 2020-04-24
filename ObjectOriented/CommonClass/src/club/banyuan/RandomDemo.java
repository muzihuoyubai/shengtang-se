package club.banyuan;

import java.util.Random;

public class RandomDemo {

  public static void main(String[] args) {
    Random random1 = new Random(10);
    Random random2 = new Random(10);
    System.out.println(random1.nextInt()); // -1157793070
    System.out.println(random2.nextInt()); // -1157793070
    System.out.println(random1.nextInt()); // 1913984760
    System.out.println(random2.nextInt()); // 1913984760
    System.out.println(random1.nextInt(10)); // 3
    System.out.println(random2.nextInt(10)); // 3

  }
}

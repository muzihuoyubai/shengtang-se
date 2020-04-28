package club.banyuan.main;

/**
 * @author www.banyuan.club
 **/
public class MainDemo {

  public static void main(String[] args) {
    // java club.banyuan.main.MainDemo a b c d
    for (int i = 0; i < args.length; i++) {
      System.out.printf("第%d个参数:%s\n", i, args[i]);
    }
  }
}

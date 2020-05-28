package club.banyuan.use.thread;

public class Demo {

  public static void main(String[] args) {
    Thread threadA = new Thread(() -> {
      for (int i = 0; i < 1000; i++) {
        System.out.println("ThreadA:" + i);
      }
    });
    Thread threadB = new Thread(() -> {
      for (int i = 0; i < 1000; i++) {
        System.out.println("ThreadB:" + i);
      }
    });

    threadA.start();
    threadB.start();
  }
}

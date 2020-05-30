package club.banyuan;

public class ReverseHelloMultithreaded {

  public static void doReverseHello() {
    helloThread(1);
  }

  public static void helloThread(int num) {
    if (num <= 50) {
      Thread thread = new Thread(() -> helloThread(num + 1), num + "");
      thread.start();
      try {
        thread.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Hello from thread " + thread.getName());
    }
  }
}

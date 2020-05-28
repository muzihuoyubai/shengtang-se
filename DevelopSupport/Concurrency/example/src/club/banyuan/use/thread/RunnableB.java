package club.banyuan.use.thread;

public class RunnableB implements Runnable {

  @Override
  public void run() {
    for (int i = 0; i < 1000; i++) {
      System.out.println("ThreadB:" + i);
    }
  }
}

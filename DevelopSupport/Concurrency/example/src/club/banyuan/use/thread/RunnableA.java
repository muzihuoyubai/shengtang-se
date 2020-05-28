package club.banyuan.use.thread;

public class RunnableA implements Runnable {

  @Override
  public void run() {
    // new ThreadA().run();
    for (int i = 0; i < 1000; i++) {
      System.out.println("ThreadA:" + i);
    }
  }
}

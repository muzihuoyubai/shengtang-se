package club.banyuan.use.thread;

public class ThreadB extends Thread {

  @Override
  public void run() {
    for (int i = 0; i < 1000; i++) {
      System.out.println("threadB: " + i);
    }
  }
}

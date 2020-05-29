package club.banyuan.deadlock;

public class TwoForOne implements Runnable {

  @Override
  public void run() {
    // synchronized (TestThread.class) {
      synchronized (TestThread.lock2) {
        System.out.println("Two For One lock2");

        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        synchronized (TestThread.lock1) {
          System.out.println("Two For One lock1");
        }
      // }
    }
  }
}

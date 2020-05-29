package club.banyuan.lock;

public class WaitDemo extends Thread {

  public static Object lock = new Object();

  public static void main(String[] args) throws InterruptedException {
    WaitDemo waitDemo = new WaitDemo();
    waitDemo.start();

    new WaitDemo().start();
    Thread.sleep(1000);
    new WaitDemo().start();
  }

  @Override
  public void run() {
    synchronized (lock) {
      try {
        System.out.println(getName() + "执行");
        lock.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

  }
}

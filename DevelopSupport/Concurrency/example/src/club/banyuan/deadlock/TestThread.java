package club.banyuan.deadlock;

public class TestThread {

  public static final Object lock1 = new Object();
  public static final Object lock2 = new Object();

  public static void main(String[] args) {
    Thread thread1 = new Thread(new OneForTwo());
    Thread thread2 = new Thread(new TwoForOne());
    thread1.start();
    thread2.start();
    System.out.println("启动线程结束...");
    System.out.println(thread1.getState());
    System.out.println(thread2.getState());
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(thread1.getState());
    System.out.println(thread2.getState());
  }

}

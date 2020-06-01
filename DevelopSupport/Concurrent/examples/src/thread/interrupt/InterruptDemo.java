package thread.interrupt;

/**
 * 线程的中断状态是由 Thread对象 调用interrupt()方法传入到线程中的
 * true为中断，false为未中断
 * 中断状态会使抛出InterruptedException异常的方法，例如sleep，join，wait等抛出InterruptedException异常
 * <p>
 * Thread 类或是其子类内部可以调用 interrupted() 方法获取当前线程的中断状态，此方法是静态方法，因此可以通过Thread.interrupted()进行调用，获取当前正在执行的线程的中断状态。
 * 使用该方法获取到中断状态后，中断状态会被重置为false
 * <p>
 * 可以调用子类对象的 isInterrupted()方法获取中断状态，该方法不会重置中断状态为false
 * <p>
 * 当catch InterruptedException异常后，中断状态会被重置为false，可以使用Thread.currentThread().interrupt(); 将中断状态修改为true
 */
public class InterruptDemo {

  // public static void main(String[] args) {
  //   Thread thread = new Thread(() -> {
  //     try {
  //       System.out.println("线程开始");
  //       // Thread.sleep(1000);
  //       Thread inner = new Thread(() -> {
  //         try {
  //           System.out.println("inner start");
  //           Thread.sleep(10000);
  //           System.out.println("inner test");
  //         } catch (InterruptedException e) {
  //           System.out.println("inner test");
  //           e.printStackTrace();
  //         }
  //       });
  //       inner.start();
  //       inner.join();
  //       System.out.println("睡眠执行完毕");
  //     } catch (InterruptedException e) {
  //       System.out.println("睡眠被打断");
  //       e.printStackTrace();
  //     }
  //     System.out.println("线程退出");
  //   });
  //   thread.start();
  //   thread.interrupt();
  // }

  public static void main(String[] args) {
    DemoThread thread = new DemoThread();
    thread.start();
    // try {
    //   Thread.sleep(200);
    // } catch (InterruptedException e) {
    //   e.printStackTrace();
    // }
    thread.interrupt();
  }
}

class DemoThread extends Thread {

  @Override
  public void run() {
    try {
      System.out.println("线程开始");
      System.out.println("1 inter:" + interrupted());
      System.out.println("1 inter:" + interrupted());
      System.out.println("1 inter:" + interrupted());
      System.out.println("1:" + isInterrupted());
      Thread.sleep(1000);
      System.out.println("睡眠执行完毕");
      System.out.println("2:" + isInterrupted());
      System.out.println("2 inter:" + interrupted());
    } catch (InterruptedException e) {
      System.out.println("3:" + isInterrupted());
      System.out.println("3 inter:" + interrupted());
      // Thread.currentThread().interrupt();
      System.out.println("3 inter':" + interrupted());
      System.out.println("3':" + isInterrupted());
      System.out.println("睡眠被打断");
      e.printStackTrace();
    }
    System.out.println("4:" + isInterrupted());
    System.out.println("4 inter:" + interrupted());
    System.out.println("线程退出");
  }
}

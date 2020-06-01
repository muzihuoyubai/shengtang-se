package thread.pool.fixed.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Demo {

  public static void main(String[] args) {
    // ExecutorService executorService = Executors.newFixedThreadPool(4);
    int i = 0;
    //
    // executorService.submit(getRunnable(i));
    // executorService.submit(getRunnable(i + 1));
    // executorService.submit(getRunnable(i + 2));
    // executorService.submit(getRunnable(i + 3));
    // executorService.submit(getRunnable(i + 4));

    ExecutorService executorService1 = Executors.newSingleThreadExecutor();
    executorService1.submit(getRunnable(i));
    executorService1.submit(getRunnable(i + 1));
    executorService1.submit(getRunnable(i + 2));
    executorService1.submit(getRunnable(i + 3));
    executorService1.submit(getRunnable(i + 4));

    // 线程池的排队线程还是会被执行
    // executorService1.shutdown();

    // 传入interrupt到线程中，未启动的线程不再启动
    executorService1.shutdownNow();


  }

  public static Runnable getRunnable(int i) {
    return () -> {
      System.out.println("线程:" + (i + 1));
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("线程:" + (i + 1) + "结束");
    };
  }
}

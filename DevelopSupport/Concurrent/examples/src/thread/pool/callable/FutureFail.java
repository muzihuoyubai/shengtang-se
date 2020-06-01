package thread.pool.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureFail {

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newSingleThreadExecutor();

    Future<Integer> futureCallable = executorService.submit(new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        // throw new Exception("出问题啦！");
        return Integer.parseInt("futureRunnable");
        // return 123;
      }
    });

    Runnable task = new Runnable() {
      @Override
      public void run() {
        Integer.parseInt("futureRunnable");
      }
    };
    Future<?> futureRunnable = executorService.submit(task);
    try {
      System.out.println(futureCallable.get());
    } catch (InterruptedException | ExecutionException e) {
      System.out.println(e.getMessage());
    }

    try {
      System.out.println(futureRunnable.get());
    } catch (InterruptedException | ExecutionException e) {
      System.out.println(e.getMessage());
    }

    executorService.shutdown();

    Thread thread = new Thread(task);
    thread.start();
    try {
      thread.join();
    } catch (InterruptedException e) {
      System.out.println(e.getMessage());
    }
  }
}

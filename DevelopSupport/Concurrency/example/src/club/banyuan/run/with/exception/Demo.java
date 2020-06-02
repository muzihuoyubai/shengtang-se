package club.banyuan.run.with.exception;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Demo {

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    Future<?> future = executorService.submit((Runnable) () -> {
      throw new RuntimeException("线程异常");
    });

    try {
     future.get();
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
      System.out.println(e.getCause());
    }

    Thread thread = new Thread((Runnable) () -> {
      throw new RuntimeException("线程异常");
    });
    thread.start();
    try {
      thread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    executorService.shutdown();

  }
}

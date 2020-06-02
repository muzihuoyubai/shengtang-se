package club.banyuan;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ReverseHelloMultithreaded {

  public static void doReverseHello() {
    helloThread(1);
  }

  public static void helloThread(int num) {

    ExecutorService executorService = Executors.newFixedThreadPool(50);

    if (num <= 50) {
      Future<String> submit = executorService.submit(() -> {
        helloThread(num + 1);
        return num + "";
      });
      try {
        System.out.println("Hello from thread " + submit.get());
      } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
      }
      executorService.shutdown();
    }
  }
}

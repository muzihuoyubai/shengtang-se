package club.banyuan;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class SharedCounter {

  static int counter = 0;


  public static void reset() {
    counter = 0;
  }

  public static int increment(int numThreads, int numIncrementsPerThread)
      throws InterruptedException {

    ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

    for (int i = 0; i < numThreads; i++) {
      executorService.submit(() -> {
        synchronized (SharedCounter.class) {
          counter += numIncrementsPerThread;
        }
      });
    }
    executorService.shutdown();
    executorService.awaitTermination(1, TimeUnit.SECONDS);
    return counter;
  }
}

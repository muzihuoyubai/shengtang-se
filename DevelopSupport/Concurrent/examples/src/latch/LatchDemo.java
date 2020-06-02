package latch;

import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LatchDemo {

  private static Map<Integer, Integer> map = new ConcurrentHashMap<>();
  public static CountDownLatch countDownLatch = new CountDownLatch(5);
  public static CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newCachedThreadPool();
    List<Future<Long>> futures = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      Callable<Long> worker = new Worker(map, i);
      futures.add(executorService.submit(worker));
    }

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    long totalTime = 0;
    for (Future<Long> future : futures) {
      try {
        totalTime += future.get();
      } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
      }
    }
    System.out.println(map);
    System.out.println(map.size());
    System.out.println("Total time:" + totalTime);

    executorService.shutdown();
  }

}

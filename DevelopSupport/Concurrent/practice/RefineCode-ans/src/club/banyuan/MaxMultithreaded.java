package club.banyuan;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MaxThread extends Thread {

  private int lo, hi;
  private int[] arr;
  private double ans = 0;

  public MaxThread(int[] arr, int lo, int hi) {
    this.lo = lo;
    this.hi = hi;
    this.arr = arr;
  }

  @Override
  public void run() {
    ans = Math.sin(arr[lo]);
    for (int i = lo; i < hi; i++) {
      double sin = Math.sin(arr[i]);
      if (ans < sin) {
        ans = sin;
      }
    }
  }

  public double getAns() {
    return ans;
  }
}

class MaxCallable implements Callable<Double> {

  private int lo, hi;
  private int[] arr;

  public MaxCallable(int[] arr, int lo, int hi) {
    this.lo = lo;
    this.hi = hi;
    this.arr = arr;
  }

  @Override
  public Double call() throws Exception {
    double ans = Double.NEGATIVE_INFINITY;
    for (int i = lo; i < hi; i++) {
      double sin = Math.sin(arr[i]);
      if (ans < sin) {
        ans = sin;
      }
    }
    return ans;
  }
}

public class MaxMultithreaded {

  /**
   * 计算数组元素的sin值之后，返回最大值。
   *
   * @param arr 目标数组
   * @return sin(数组元素)的最大值
   * @throws InterruptedException 不应该出现此异常
   */
  public static double max(int[] arr, int numThreads) throws InterruptedException {
    int len = arr.length;
    double ans = Double.NEGATIVE_INFINITY;

    ExecutorService executorService = Executors.newFixedThreadPool(20);

    // 创建并启动线程。
    List<Future<Double>> ts = new ArrayList<>();
    for (int i = 0; i < numThreads; i++) {
      Future<Double> submit = executorService
          .submit(new MaxCallable(arr, (i * len) / numThreads, ((i + 1) * len / numThreads)));
      ts.add(submit);
    }
    try {
      // 等待线程完成并计算它们的结果。
      for (int i = 0; i < numThreads; i++) {
        Double rlt = ts.get(i).get();
        if (ans < rlt) {
          ans = rlt;
        }
      }
    } catch (ExecutionException e) {
      e.printStackTrace();
    }
    executorService.shutdown();
    return ans;
  }
}

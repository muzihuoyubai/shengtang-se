package collection;

import java.util.Map;
import java.util.concurrent.Callable;

public class Worker extends Thread implements Callable<Long> {

  private Map<Integer, Integer> map;
  private int code;

  public Worker(Map<Integer, Integer> map, int code) {
    this.map = map;
    this.code = code;
  }

  public Worker(Map<Integer, Integer> map) {
    this.map = map;
  }

  @Override
  public void run() {
    int interval = 100;
    for (int i = code * interval; i < (code + 1) * interval; i++) {
      // try {
      // Thread.sleep(20);
      // } catch (InterruptedException e) {
      //   e.printStackTrace();
      // }
      map.put(i, i);
    }
  }

  @Override
  public Long call() throws Exception {
    long startTime = System.currentTimeMillis();
    run();
    return System.currentTimeMillis() - startTime;
  }
}

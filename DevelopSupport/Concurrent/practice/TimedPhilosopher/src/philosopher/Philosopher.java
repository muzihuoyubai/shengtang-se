package philosopher;

import java.util.Random;

// 运行一分钟之后，哲学家线程退出
// 统计哲学家一共吃了多少次饭，多少次吃饭成功，一共进行了多少次思考
public class Philosopher extends AbstractPhilosopher {

  private Chopsticks[] chopsticks;
  private int code;
  private int eatTimes;
  private int thinkTimes;
  private int eatSuccessTimes;

  public Philosopher(int code, Chopsticks[] chopsticks) {
    this.code = code;
    this.setName("哲学家" + code + "");
    this.chopsticks = chopsticks;
    setLeft(chopsticks[code - 1]);
    setRight(chopsticks[code % 5]);
  }

  @Override
  public boolean eat() throws InterruptedException {
    eatTimes++;
    if (super.eat()) {
      eatSuccessTimes++;
      return true;
    } else {
      return false;
    }
  }

  @Override
  public void thinking() throws InterruptedException {
    thinkTimes++;
    super.thinking();
  }

  @Override
  public void run() {
    // long finishTimeInterval = 60 * 1000;
    Random random = new Random();
    // long startTime = System.currentTimeMillis();
    while (!interrupted()) {
      try {
        if (random.nextBoolean()) {
          eat();
        } else {
          thinking();
        }
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        // System.out.println(isInterrupted());
        // e.printStackTrace();
      }
      // if (System.currentTimeMillis() - startTime >= finishTimeInterval) {
      //   return;
      // }
    }

  }

  public void results() {
    System.out.println(
        getName() + ":一共吃饭" + eatTimes + "次,成功" + eatSuccessTimes + "次,思考" + thinkTimes + "次");
  }
}

package thread.pool.philosopher;

import java.util.Random;

// 运行一分钟之后，哲学家线程退出
// 统计哲学家一共吃了多少次饭，多少次吃饭成功，一共进行了多少次思考
public class Philosopher extends AbstractPhilosopher {

  private Chopsticks[] chopsticks;
  private int code;

  public Philosopher(int code, Chopsticks[] chopsticks) {
    this.code = code;
    this.setName("哲学家" + code + "");
    this.chopsticks = chopsticks;
    setLeft(chopsticks[code - 1]);
    setRight(chopsticks[code % 5]);
  }

  @Override
  public void run() {
    Random random = new Random();

    while (true) {
      if (random.nextBoolean()) {
        eat();
      } else {
        thinking();
      }
    }

  }
}

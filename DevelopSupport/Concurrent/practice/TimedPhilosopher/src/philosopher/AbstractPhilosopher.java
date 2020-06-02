package philosopher;

public class AbstractPhilosopher extends Thread {

  private Chopsticks left;
  private Chopsticks right;

  public boolean eat() throws InterruptedException {
    System.out.println(Thread.currentThread() == this);
    System.out.println(Thread.currentThread());
    System.out.println(this);
    if (!left.take(500)) {
      System.out.println("没拿到筷子，不吃了");
      return false;
    }
    Thread.sleep(200);
    if (!right.take(500)) {
      System.out.println("没拿到筷子，不吃了");
      left.put();
      return false;
    }
    System.out.println(getName() + ",吃饭");
    Thread.sleep(1000);
    left.put();
    right.put();
    System.out.println(getName() + ",吃饭结束");
    return true;
  }

  public void thinking() throws InterruptedException {
    System.out.println(getName() + ",思考");
    Thread.sleep(200);
    System.out.println(getName() + ",思考结束");
  }

  public Chopsticks getLeft() {
    return left;
  }

  public void setLeft(Chopsticks left) {
    this.left = left;
  }

  public Chopsticks getRight() {
    return right;
  }

  public void setRight(Chopsticks right) {
    this.right = right;
  }
}

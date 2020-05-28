package club.banyuan.use.thread;

public class RunnableDemo {

  public static void main(String[] args) {
    Thread threadA = new Thread(new RunnableA());
    threadA.start();

    Thread threadB = new Thread(new RunnableB());
    threadB.start();
  }
}

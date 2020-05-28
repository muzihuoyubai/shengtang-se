package club.banyuan.use.thread;

public class ThreadDemo {

  public static void main(String[] args) {
    ThreadA threadA = new ThreadA();
    // 如果是调用run方法，就不会开启线程，而是仅仅按照调用方法的方式执行run中的代码
    threadA.start();
    ThreadB threadB = new ThreadB();
    threadB.start();
  }
}

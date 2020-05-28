package club.banyuan.main.wait.thread;

public class Demo {

  public static void main(String[] args) {
    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        new Thread(() -> {
          for (int i = 0; i < 100000; i++) {
            System.out.println(i);
          }

        }).start();
      }
    };

    Thread thread = new Thread(runnable);
    thread.start();

    System.out.println("end");

  }
}

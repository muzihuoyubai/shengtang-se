package club.banyuan.queue;

public class Main {

  public static void main(String[] args) {
    Queue queue = new ArrayQueue();

    System.out.println(queue.isEmpty());
    for (int i = 0; i < 9; i++) {
      queue.add(i);
    }

    System.out.println(queue.delete());
    System.out.println(queue.delete());
    System.out.println(queue.delete());
    System.out.println(queue.isEmpty());
    queue.add(11);
    queue.add(12);
    queue.add(13);
    queue.add(14);
    System.out.println(queue.delete());
  }
}

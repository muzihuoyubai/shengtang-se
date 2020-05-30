import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CellularPhone extends Thread {

  private volatile boolean callInProgress = false;
  private volatile boolean keepGoing = true;
  private final Lock lock = new ReentrantLock();
  private final Queue<String> queue = new LinkedList<>();

  public CellularPhone(String name) {
    super(name);
  }

  /**
   * 假设控制台是手机的窗口。
   *
   * @param message 要显示的消息
   */
  private void display(String message) {
    System.out.println(message);
  }

  /**
   * 接听电话。在终端显示消息。
   *
   * @param name               调用方的名称
   * @param callDisplayMessage 呼叫正在进行时显示的消息
   * @returns 如果调用被接受，则为true
   */
  public boolean startCall(String name, String callDisplayMessage) {
    boolean locked = lock.tryLock();
    if (!locked) {
      return false;
    }
    callInProgress = true;
    display("<" + name + ">: Call (" + callDisplayMessage + ") begins");
    return true;
  }

  /**
   * 挂断电话。在此方法完成后，电话能够接听其他电话。
   *
   * @param name               调用方的名称
   * @param callDisplayMessage 要显示的消息
   */
  public void endCall(String name, String callDisplayMessage) {
    // 这里也可以使用 tryLock 尝试获取锁，如果获取到向下执行，否则抛异常
    // 但是这样的话，unlock需要做两次，一次是这里的tryLock，还有一次是startCall里面的lock需要释放
    if (!callInProgress) {
      throw new IllegalStateException("没有打电话，就要挂掉电话");
    }
    display("   <" + name + ">: Call (" + callDisplayMessage + ") ends");
    callInProgress = false;
    lock.unlock();
  }

  /**
   * 显示手机正在等待做某事
   */
  private void displayWaiting() {
    display("<" + this.getName() + ">: Waiting...");
  }

  /**
   * 停止电话接听程序
   */
  public void stopPhone() {
    keepGoing = false;
  }

  /**
   * 运行模拟器
   */
  public void run() {
    // 循环直到stopPhone被调用
    while (keepGoing) {
      // 如果没有电话
      if (!callInProgress) {
        // 保证在显示消息的时候没有电话进来
        lock.lock();
        displayMessage();
        displayWaiting();
        lock.unlock();
        // 假装手机在做别的事情
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  synchronized public void addMessage(String msg) {
    System.out.println("received msg");
    queue.offer(msg);
  }

  private void displayMessage() {
    while (!queue.isEmpty()) {
      System.out.println("<Phone>: Message:" + queue.poll());
    }
  }
}

package tcp.duplex;

import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Sender implements Runnable {

  private OutputStream outputStream;
  private volatile byte[] message;
  // private CyclicBarrier cyclicBarrier = new CyclicBarrier(2);


  public Sender(OutputStream outputStream) {
    this.outputStream = outputStream;
  }

  public synchronized void setMessage(byte[] message) {
    // this.message = message;
    // try {
    // cyclicBarrier.await();
    // } catch (InterruptedException | BrokenBarrierException e) {
    //   e.printStackTrace();
    // }
    this.message = message;
    notify();
  }

  @Override
  public void run() {
    // while (!Thread.currentThread().isInterrupted()) {
    //   try {
    //     cyclicBarrier.await();
    //     outputStream.write(message);
    //   } catch (IOException | InterruptedException | BrokenBarrierException e) {
    //     Thread.currentThread().interrupt();
    //     System.out.println("停止发送消息");
    //   }
    // }

    while (!Thread.currentThread().isInterrupted()) {
      try {
        synchronized (this) {
          wait();
          outputStream.write(message);
          System.out.println("发送消息");
        }
      } catch (IOException | InterruptedException e) {
        Thread.currentThread().interrupt();
        System.out.println("停止发送消息");
      }
    }

  }
}

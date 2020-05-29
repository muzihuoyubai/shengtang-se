package club.banyuan.lock;

public class Factory extends Thread {

  private Shop shop;

  public Factory(String name, Shop shop) {
    super(name);
    this.shop = shop;
  }

  @Override
  public void run() {
    while (true) {
      try {
        sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      shop.store(this);
    }
  }
}

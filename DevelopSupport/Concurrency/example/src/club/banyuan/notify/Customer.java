package club.banyuan.notify;

public class Customer extends Thread {

  private final Shop shop;

  public Customer(String name, Shop shop) {
    super(name);
    this.shop = shop;
  }

  @Override
  public void run() {
    while (true) {
      try {
        sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      shop.buy(this);
    }

  }
}

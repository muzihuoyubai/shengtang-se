package club.banyuan.sync.instance;

public class Customer implements Runnable {

  private String name;
  private final Shop shop;
  private Object lock = new Object();

  public Customer(String name, Shop shop) {
    this.name = name;
    this.shop = shop;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  // read - update
  public void buy() {
    shop.buy(this);
  }

  @Override
  public void run() {
    for (int i = 0; i < 50; i++) {
      buy();
      // 提示可以进行线程切换。这里可以让每次购买商品的用户切换的较频繁
      // Thread.yield();
    }
  }
}

package club.banyuan.sync.staticmethod;

public class Customer implements Runnable {

  private String name;

  public Customer(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  // read - update
  public void buy() {
    Shop.buy(this);
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

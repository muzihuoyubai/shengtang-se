package club.banyuan.share.resource;

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

  public void buy() {
    synchronized (shop) {
      System.out.println(name + "购买一件商品");
      int inventory = shop.getInventory();
      try {
        Thread.sleep((long) (Math.random() * 500));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      shop.setInventory(inventory - 1);
    }
  }

  @Override
  public void run() {
    for (int i = 0; i < 50; i++) {
      buy();
    }
  }
}

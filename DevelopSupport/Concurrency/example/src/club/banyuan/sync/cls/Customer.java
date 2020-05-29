package club.banyuan.sync.cls;

public class Customer implements Runnable {

  private String name;
  private final Shop shop;

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
    synchronized (Customer.class) {
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

  synchronized public void sitDown() {
    System.out.println(name + "坐下休息一会");
    try {
      Thread.sleep(300);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(name + "休息结束");
  }

  synchronized public static void sitDown(String name) {
    System.out.println(name + "坐下休息一会");
    try {
      Thread.sleep(300);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(name + "休息结束");
  }

  @Override
  public void run() {
    for (int i = 0; i < 50; i++) {
      buy();
      Thread.yield();
      sitDown();
      sitDown(this.getName());
    }
  }
}

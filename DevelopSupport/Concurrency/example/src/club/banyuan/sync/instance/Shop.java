package club.banyuan.sync.instance;

public class Shop {

  private Integer inventory;

  public Shop(Integer inventory) {
    this.inventory = inventory;
  }

  public Integer getInventory() {
    return inventory;
  }

  public void setInventory(Integer inventory) {
    this.inventory = inventory;
    System.out.println("商店库存:" + inventory);
  }


  // synchronized 修饰实例方法 等同于 synchronized (this)
  synchronized public void buy(Customer customer) {
    synchronized (this) {
      System.out.println(customer.getName() + "购买一件商品");
      int inventory = getInventory();
      try {
        Thread.sleep((long) (Math.random() * 500));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      setInventory(inventory - 1);
    }
  }
}

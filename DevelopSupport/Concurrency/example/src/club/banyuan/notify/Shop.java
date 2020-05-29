package club.banyuan.notify;

public class Shop {

  private static final Shop shop = new Shop();

  private int inventory = 10;
  private static final int MAX_STORE = 100;

  private Shop() {
  }

  public static Shop getInstance() {
    return shop;
  }

  public int getInventory() {
    return inventory;
  }

  public void setInventory(int inventory) {
    this.inventory = inventory;
  }


  synchronized public void buy(Customer customer) {
    if (inventory > 0) {
      System.out.println(customer.getName() + "购买了一件商品");
      inventory--;
      System.out.println("库存：" + inventory);
      notifyAll();
    } else {
      while (inventory <= 0) {
        System.out.println("商品不足！");
        try {
          wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  synchronized public void store(Factory factory) {
    if (inventory < MAX_STORE) {
      System.out.println(factory.getName() + "存入了一件商品");
      inventory++;
      System.out.println("库存：" + inventory);
      notifyAll();
    } else {
      while (inventory >= MAX_STORE) {
        System.out.println("库存已达到上线");
        try {
          this.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

}

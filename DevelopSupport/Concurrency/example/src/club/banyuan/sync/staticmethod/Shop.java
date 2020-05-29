package club.banyuan.sync.staticmethod;

public class Shop {

  private static Integer inventory = 100;

  public Shop(Integer inventory) {
    Shop.inventory = inventory;
  }

  public static Integer getInventory() {
    return inventory;
  }

  public static void setInventory(Integer inventory) {
    Shop.inventory = inventory;
    System.out.println("商店库存:" + inventory);
  }

  synchronized public static void buy(Customer customer) {
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

package club.banyuan.singleton;

public class Shop {

  private static final Shop shop = new Shop();

  private int inventory;

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
}

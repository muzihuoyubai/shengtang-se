package club.banyuan.singleton;

/**
 * 单例模式
 * 延迟加载
 */
public class OtherShop {

  private static OtherShop shop;

  private int inventory;

  private OtherShop() {
  }

  // synchronized public static OtherShop getInstance() {
  //   if (shop == null) {
  //     shop = new OtherShop();
  //   }
  //   return shop;
  // }

  public static OtherShop getInstance() {
    if (shop == null) {
      synchronized (OtherShop.class) {
        if (shop == null) {
          shop = new OtherShop();
        }
      }
    }
    return shop;
  }

  public int getInventory() {
    return inventory;
  }

  public void setInventory(int inventory) {
    this.inventory = inventory;
  }
}

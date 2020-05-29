package club.banyuan.sync.cls;

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
}

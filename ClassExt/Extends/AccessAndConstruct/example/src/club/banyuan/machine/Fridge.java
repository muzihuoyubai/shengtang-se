package club.banyuan.machine;

import club.banyuan.animal.Elephant;
import club.banyuan.animal.Lion;
import club.banyuan.animal.Tiger;

public class Fridge {

  private int heightInCM;
  private Elephant storage;
  private Lion lionStore;
  private Tiger tigerStore;

  public Fridge(int heightInCM) {
    System.out.printf("创建一个冰箱，高度%d厘米\n", heightInCM);
    this.heightInCM = heightInCM;
  }

  public Lion getLionStore() {
    return lionStore;
  }

  public void setLionStore(Lion lionStore) {
    this.lionStore = lionStore;
  }

  public Tiger getTigerStore() {
    return tigerStore;
  }

  public void setTigerStore(Tiger tigerStore) {
    this.tigerStore = tigerStore;
  }

  public Elephant getStorage() {
    return this.storage;
  }

  public void setStorage(Elephant storage) {
    this.storage = storage;
  }

  public int getHeightInCM() {
    return heightInCM;
  }

  public void setHeightInCM(int heightInCM) {
    this.heightInCM = heightInCM;
  }
}
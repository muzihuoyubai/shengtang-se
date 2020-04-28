package club.banyuan.machine;

import club.banyuan.animal.Elephant;
import club.banyuan.animal.Lion;

public class Fridge {

  public int heightInCM;
  public Elephant storage;
  public Lion storageLion;

  public void store(Elephant elephant) {
    if (storage != null || storageLion != null) {
      System.out.println("冰箱已经满了！");
      return;
    }
    storage = elephant;
  }

  public void store(Lion lion) {
    if (storage != null || storageLion != null) {
      System.out.println("冰箱已经满了！");
      return;
    }
    storageLion = lion;
  }

  public Elephant remove() {
    Elephant rlt = storage;
    storage = null;
    return rlt;
  }

}
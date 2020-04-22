package club.banyuan.machine;

import club.banyuan.animal.Elephant;

public class Fridge {

  public int heightInCM;
  public Elephant storage;

  public void store(Elephant elephant) {
    storage = elephant;
  }
}
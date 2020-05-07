package club.banyuan.main;

import club.banyuan.animal.Animal;
import club.banyuan.animal.Elephant;
import club.banyuan.animal.Lion;
import club.banyuan.machine.Fridge;
import club.banyuan.machine.Fridgeable;


public class Main {


  static void putInElephant(Elephant elephant, Fridge fridge) {
    System.out.printf("把%d厘米高的大象装进%d厘米高的冰箱\n", elephant.getHeightInCM(), fridge.getHeightInCM());
    if (elephant.getHeightInCM() < fridge.getHeightInCM() && fridge.setAnimal(elephant)) {
      // 使用对象方法
      elephant.elephantMethod();
      Animal fridgeElephant = fridge.getAnimal();
      System.out.printf("冰箱里面的大象高度是%d厘米\n", fridgeElephant.getHeightInCM());
    } else {
      System.out.println("冰箱装不下!");
    }
  }

  public static void main(String[] args) {
    // Elephant elephant = new Elephant(300);
    Fridge fridge = new Fridge(500);
    Elephant elephant = new Elephant();
    System.out.println(Fridgeable.FROZEN_TIME_SEC);

    Fridgeable.isFrozen();

    // elephant.frozen();
    elephant.setHeightInCM(300);

    putInElephant(elephant, fridge);
    fridge.clear();
    Lion lion = new Lion();
    lion.setHeightInCM(200);
    fridge.setAnimal(lion);

    fridge.clear();

    // Fridgeable tiger = new Tiger();
    // fridge.setFridgeable(tiger);

    // fridge.setObj(new String[3]);
    // fridge.setObj("1234");

  }
}
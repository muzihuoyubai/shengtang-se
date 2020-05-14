package club.banyuan.main;

import club.banyuan.animal.Animal;
import club.banyuan.animal.AnimalType;
import club.banyuan.animal.Elephant;
import club.banyuan.animal.Lion;
import club.banyuan.animal.Tiger;
import club.banyuan.machine.Fridge;


public class Main {

  static void putInAnimal(Animal animal, Fridge fridge) {
    System.out
        .printf("把%d厘米高的%s装进%d厘米高的冰箱\n", animal.getHeightInCM(), animal.getAnimalType().toString(),
            fridge.getHeightInCM());
    try {
      if (animal.getHeightInCM() < fridge.getHeightInCM() && fridge.setAnimal(animal)) {
        Animal fridgeElephant = fridge.getAnimal();
        System.out.printf("冰箱里面的%s高度是%d厘米\n", animal.getAnimalType().toString(),
            fridgeElephant.getHeightInCM());
      } else {
        System.out.println("冰箱装不下!");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public static void main(String[] args) {
    Elephant elephant = new Elephant(300);
    Fridge fridge = new Fridge(500);
    elephant.setHeightInCM(300);
    putInAnimal(elephant, fridge);
    fridge.clear();

    Lion lion = new Lion();
    lion.setHeightInCM(200);
    putInAnimal(lion, fridge);
    fridge.clear();

    Tiger tiger = new Tiger(300);
    putInAnimal(tiger, fridge);

    System.out.println("12345678");
  }
}
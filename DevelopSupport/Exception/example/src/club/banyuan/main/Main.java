package club.banyuan.main;

import club.banyuan.animal.Animal;
import club.banyuan.animal.AnimalType;
import club.banyuan.animal.Elephant;
import club.banyuan.animal.Lion;
import club.banyuan.animal.Tiger;
import club.banyuan.machine.Fridge;
import club.banyuan.machine.FridgeFullException;
import club.banyuan.machine.GateException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


public class Main {

  static void putInAnimal(Animal animal, Fridge fridge) {
    System.out
        .printf("把%d厘米高的%s装进%d厘米高的冰箱\n", animal.getHeightInCM(), animal.getAnimalType().toString(),
            fridge.getHeightInCM());

    // try-resource中必须放置Closeable或者AutoCloseable的实现类对象。这样在try代码块结束，或者抛出异常后，调用括号内变量的close方法，用来自动关闭资源。
    // try-resource是为了简化finally的写法，finally的执行顺序是catch语句执行之后被执行。但是try括号内的资源close是在catch语句执行之前被执行
    try (fridge) {
      fridge.openGate();
      if (animal.getHeightInCM() < fridge.getHeightInCM()) {
        fridge.setAnimal(animal);
        Animal fridgeElephant = fridge.getAnimal();
        System.out.printf("冰箱里面的%s高度是%d厘米\n", animal.getAnimalType().toString(),
            fridgeElephant.getHeightInCM());
      } else {
        System.out.println("冰箱装不下!");
      }
    } catch (IllegalArgumentException e) {
      System.out.println("关不到冰箱中，把" + animal.getAnimalType() + "放生了");
    } catch (FridgeFullException e) {
      System.out.println(e.getMessage());
      fridge.clear();
      System.out.println("清空冰箱之后再放一次");
      putInAnimal(animal, fridge);
    } catch (GateException e) {
      System.out.println(e.getMessage());
      System.out.println("找人去修门");
    }

    // finally {
    //   if (fridge.isGateOpen()) {
    //     closeFridgeGateAnyWay(fridge);
    //   }
    // }

  }

  private static void closeFridgeGateAnyWay(Fridge fridge) {
    while (true) {
      try {
        fridge.closeGate();
        System.out.println("终于关门成功了");
        break;
      } catch (GateException gateException) {
        System.out.println("关门失败，在关一次");
      }
    }
  }

  public static void main(String[] args) {
    Elephant elephant = new Elephant(300);
    Fridge fridge = new Fridge(500);
    elephant.setHeightInCM(300);

    putInAnimal(elephant, fridge);

    // fridge.clear();

    Lion lion = new Lion();
    lion.setHeightInCM(200);
    putInAnimal(lion, fridge);
    fridge.clear();

    Tiger tiger = new Tiger(300);
    putInAnimal(tiger, fridge);

  }
}
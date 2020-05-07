package club.banyuan.animal;

import club.banyuan.machine.Fridgeable;

public class Lion extends Animal implements Fridgeable {

  @Override
  public void frozen() {
    System.out.println("Lion frozen");
  }

  public void lionMethod() {
    System.out.println("Lion method");
  }

  // @Override
  public void touch() {
    System.out.println("died！");
  }

  @Override
  public String getAnimalType() {
    return "狮子";
  }

  // @Override
  // public void frozen() {
  //   System.out.println("lion frozen");
  // }
}

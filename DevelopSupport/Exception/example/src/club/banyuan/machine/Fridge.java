package club.banyuan.machine;

import club.banyuan.animal.Animal;

public class Fridge implements AutoCloseable {

  private int heightInCM;
  private Animal animal;
  private final Gate gate = new Gate();

  public Fridge(int heightInCM) {

    System.out.printf("创建一个冰箱，高度%d厘米\n", heightInCM);
    this.heightInCM = heightInCM;
  }

  public Animal getAnimal() {
    return animal;
  }

  public void setAnimal(Animal animal) {
    if (this.animal == null) {
      if (animal instanceof Fridgeable) {
        this.animal = animal;
        ((Fridgeable) animal).frozen();
      } else {
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(
            "不支持的动物类型" + animal.getAnimalType());
        throw illegalArgumentException;
      }
    } else {
      throw new FridgeFullException("冰箱已经满了");
    }
  }

  public void clear() {
    this.animal = null;
  }

  public int getHeightInCM() {
    return heightInCM;
  }

  public void setHeightInCM(int heightInCM) {
    this.heightInCM = heightInCM;
  }

  public void openGate() throws GateException {
    gate.openGate();
  }

  public void closeGate() throws GateException {
    gate.closeGate();
  }

  public boolean isGateOpen() {
    return gate.isGateOpen();
  }

  @Override
  public void close() throws Exception {
    if (isGateOpen()) {
      closeFridgeGateAnyWay();
    }
  }

  private void closeFridgeGateAnyWay() {
    while (true) {
      try {
        closeGate();
        System.out.println("终于关门成功了");
        break;
      } catch (GateException gateException) {
        System.out.println("关门失败，在关一次");
      }
    }
  }

  public static void main(String[] args) {
    try (Fridge fridge = new Fridge(123)) {

      throw new RuntimeException();

    } catch (RuntimeException e) {
      // 并不是在这里调用，只是用来说明问题
      // try {
      //   fridge.close();
      // } catch (Exception e1) {
      //   e.addSuppressed(e1);
      // }

      // 其他语句
    } catch (Exception e) {
      e.printStackTrace();
    }
    ;
  }
}
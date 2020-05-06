package club.banyuan.animal;

public class Tiger extends Animal {

  public Tiger() {
  }

  public Tiger(int heightInCM) {
    super(heightInCM);
  }

  @Override
  public void frozen() {
    System.out.println("Tiger frozen");
  }

  public void tigerMethod() {
    System.out.println("Tiger method");
  }
}

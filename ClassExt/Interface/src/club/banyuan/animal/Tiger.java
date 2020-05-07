package club.banyuan.animal;

public class Tiger extends Animal implements Felidae {

  public Tiger() {
  }

  public Tiger(int heightInCM) {
    super(heightInCM);
  }

  @Override
  public String getAnimalType() {
    return "老虎";
  }

  public void tigerMethod() {
    System.out.println("Tiger method");
  }

  @Override
  public void touch() {
    System.out.println("so died!");
  }
}

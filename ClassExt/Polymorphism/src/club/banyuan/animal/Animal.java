package club.banyuan.animal;

public abstract class Animal {

  private int heightInCM;

  public Animal() {
    // ((Elephant)this).elephantMethod();
    System.out.println("Animal()");
  }

  public Animal(int heightInCM) {
    this.heightInCM = heightInCM;
    System.out.println("animal constructor");
  }

  public int getHeightInCM() {
    return heightInCM;
  }

  public void setHeightInCM(int heightInCM) {
    this.heightInCM = heightInCM;
  }

  public abstract void frozen();


  public static void main(String[] args) {
    Elephant elephant = new Elephant();
  }
}

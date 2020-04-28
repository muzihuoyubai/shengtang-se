package club.banyuan.animal;

public class Tiger extends Animal {

  public void tigerMethod(){
    System.out.println(getHeightInCM());
  }

  public static void main(String[] args) {
    Tiger tiger = new Tiger();
    tiger.tigerMethod();
  }
}

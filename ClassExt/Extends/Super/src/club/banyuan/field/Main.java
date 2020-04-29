package club.banyuan.field;

public class Main {

  public static void main(String[] args) {
    Son son = new Son();

    // 输出从父类继承过来的成员值
    System.out.println(son.fatherField);

    // 输出子类自定义的成员值，父类的成员值因为变量命名相同进而无法从外部访问
    System.out.println(son.fatherFieldOverride);
    son.accessFatherField();
  }
}

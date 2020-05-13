package club.banyuan.q15;

class ABC {

  int i = 10101; // 执行顺序 0

  {
    i--; // 执行顺序 1  10100
  }

  public ABC() {
    this(12);
    --i;  // 执行顺序 4 10098
  }

  public ABC(int a){
    a = 15; // 执行顺序 3
  }

  {
    i--; // 执行顺序 2 10099
  }

  class XYZ {

    int i = this.i; // i = 0

    {
      i++; // i = 1
    }

    public XYZ() {
      ++i;
    } // i = 2
  }
}

public class MainClass {

  public static void main(String[] args) {
    ABC abc = new ABC();

    System.out.println(abc.i); // 10098

    ABC.XYZ xyz = abc.new XYZ();

    System.out.println(xyz.i); // 2

    // 和上面的内容没有变化，创建了两个独立的内部类的对象。
    ABC.XYZ xyz1 = new ABC().new XYZ();

    System.out.println(xyz1.i); // 2
  }
}
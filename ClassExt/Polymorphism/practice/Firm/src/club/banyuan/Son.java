package club.banyuan;

public class Son extends Father{

  public static void main(String[] args) {
    new Son().grandFatherMethod();

    GrandFather grandFather = new Son();

    grandFather.grandFatherMethod();

    new Son().grandFatherStaticMethod();
  }
}

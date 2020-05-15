package club.banyuan.q10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Test {

  static void test() {
    try {
      File file = new File("filename.txt");
      Scanner sc = new Scanner(file); // 抛出FileNotFoundException
      throw new IOException(); // 因为上面抛出异常，所以这里的代码不会执行
    } catch (FileNotFoundException e) {
      System.out.println("FileNotFoundException called!!!");
    } catch (IOException e) {
      System.out.println("IOException called!!!");
    }
  }

  public static void main(String[] args) {
    test();
  }
}

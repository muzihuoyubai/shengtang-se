package club.banyuan.q11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Test {

  static void test() {
    try {

      File file = new File("filename.txt");
      Scanner sc = new Scanner(file); // 这里抛出的fileNotFoundException是IOException的子类
      throw new IOException(); // 这里的代码没有执行
    } catch (IOException e) {
      System.out.println("IOException called!!!");
    }
  }

  public static void main(String[] args) {
    test();
  }
}

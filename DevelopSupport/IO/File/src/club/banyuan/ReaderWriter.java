package club.banyuan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ReaderWriter {


  public static void main(String[] args) throws IOException {
    String sourceFilePath = "/Users/liyi/Desktop/test.txt";

    FileWriter fileWriter = new FileWriter(sourceFilePath);
    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    // fileWriter.write("test123456");
    bufferedWriter.write("第一行");
    bufferedWriter.newLine();
    bufferedWriter.write("第二行");
    // fileWriter.flush();
    // fileWriter.close();
    bufferedWriter.close();

    FileReader fileReader = new FileReader(sourceFilePath);
    char[] temp = new char[1024];
    int count = fileReader.read(temp);
    System.out.println(new String(temp, 0, count));

    BufferedReader reader = new BufferedReader(fileReader);
    System.out.println(reader.readLine());

    reader.close();

    FileInputStream fileInputStream = new FileInputStream(sourceFilePath);
    // 字节流转字符流
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
  }
}

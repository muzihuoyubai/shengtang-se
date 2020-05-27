package club.banyuan;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileWithBuffer {

  public static void main(String[] args) {
    String sourceFilePath = "/Users/liyi/Desktop/WIN.mp3";
    String targetFilePath = "/Users/liyi/Desktop/WIN_copy.mp3";
    String targetBufferFile = "/Users/liyi/Desktop/WIN_copy_buf.mp3";

    // String sourceFilePath = "/Users/liyi/Desktop/README.md";
    // String targetFilePath = "/Users/liyi/Desktop/README_copy.md";
    // String targetBufferFile = "/Users/liyi/Desktop/README_copy_buf.md";


    File sourceFile = new File(sourceFilePath);
    File targetFile = new File(targetFilePath);
    File targetFileWithBuffer = new File(targetBufferFile);

    copyNormal(sourceFile, targetFile);
    copyWithBuffer(sourceFile, targetFileWithBuffer);

    // readWithBuffer(sourceFile, targetFileWithBuffer);
    // readNormal(sourceFile, targetFile);


  }

  private static void readNormal(File sourceFile, File targetFile) {
    try (
        FileInputStream fileInputStream = new FileInputStream(sourceFile);
        MyBufferedInputStream bufferedInputStream = new MyBufferedInputStream(fileInputStream);
        FileOutputStream fileOutputStream = new FileOutputStream(targetFile)
    ) {
      long start = System.currentTimeMillis();
      int count;
      while ((count = fileInputStream.read()) >= 0 ) {
        // System.out.println(fileInputStream.read());
        fileOutputStream.write(count);
      }
      long end = System.currentTimeMillis();
      System.out.println("复制时间：" + (end - start) + "毫秒");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void copyNormal(File sourceFile, File targetFile) {
    try (
        FileInputStream fileInputStream = new FileInputStream(sourceFile);
        MyBufferedInputStream bufferedInputStream = new MyBufferedInputStream(fileInputStream);
        FileOutputStream fileOutputStream = new FileOutputStream(targetFile)
    ) {
      long start = System.currentTimeMillis();
      byte[] temp = new byte[1024];
      int count;
      while ((count = fileInputStream.read(temp)) != -1) {
        fileOutputStream.write(temp, 0, count);
      }
      long end = System.currentTimeMillis();
      System.out.println("复制时间：" + (end - start) + "毫秒");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void copyWithBuffer(File sourceFile, File targetFile) {
    try (
        FileInputStream fileInputStream = new FileInputStream(sourceFile);
        MyBufferedInputStream bufferedInputStream = new MyBufferedInputStream(fileInputStream);
        FileOutputStream fileOutputStream = new FileOutputStream(targetFile)
    ) {
      long start = System.currentTimeMillis();
      byte[] temp = new byte[1024];
      int count;
      while ((count = bufferedInputStream.read(temp)) != -1) {
        fileOutputStream.write(temp, 0, count);
      }
      long end = System.currentTimeMillis();
      System.out.println("复制时间：" + (end - start) + "毫秒");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void readWithBuffer(File sourceFile, File targetFile) {
    try (
        FileInputStream fileInputStream = new FileInputStream(sourceFile);
        MyBufferedInputStream bufferedInputStream = new MyBufferedInputStream(fileInputStream);
        FileOutputStream fileOutputStream = new FileOutputStream(targetFile)
    ) {
      long start = System.currentTimeMillis();
      int count;
      // 0xFFFFFFFF
      while ((count = bufferedInputStream.read()) != -1) {
        fileOutputStream.write(count);
      }
      long end = System.currentTimeMillis();
      System.out.println("复制时间：" + (end - start) + "毫秒");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

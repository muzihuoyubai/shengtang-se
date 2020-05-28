package club.banyuan.machine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Properties;

public class VmsStorageUtil {

  private static Properties properties;

  static {
    loadProperties();
  }

  private static void loadProperties() {
    // 加 / 表示类路径的根路径
    InputStream is = VmsStorageUtil.class.getResourceAsStream("/vms.properties");
    properties = new Properties();
    try {
      properties.load(is);
    } catch (IOException e) {
      throw new VendingMachineException("读取文件失败");
    }
  }

  public static int getPassword() {
    if (properties == null) {
      loadProperties();
    }
    try {
      return Integer.parseInt(properties.getProperty("password"));
    } catch (NumberFormatException e) {
      throw new VendingMachineException("属性错误");
    }
  }

  public static String getStoreFileName() {
    if (properties == null) {
      loadProperties();
    }
    try {
      return properties.getProperty("filename");
    } catch (NumberFormatException e) {
      throw new VendingMachineException("属性错误");
    }
  }

  public static void save(Serializable obj) {
    // 获取类路径(classpath)
    String classPath = VmsStorageUtil.class.getClassLoader().getResource("").getPath();
    File storageFile = new File(classPath, getStoreFileName());
    try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
        new FileOutputStream(storageFile))) {
      objectOutputStream.writeObject(obj);
    } catch (IOException e) {
      throw new VendingMachineException("保存失败", e);
    }
  }

  public static <T> T load() {
    // 获取类路径(classpath)
    String classPath = VmsStorageUtil.class.getClassLoader().getResource("").getPath();
    File storageFile = new File(classPath, getStoreFileName());
    try (ObjectInputStream inputStream = new ObjectInputStream(
        new FileInputStream(storageFile))) {
      return (T) inputStream.readObject();
    } catch (IOException | ClassNotFoundException e) {
      throw new VendingMachineException("保存失败", e);
    }
  }

  public static void main(String[] args) {
    System.out.println(VmsStorageUtil.class.getClassLoader().getResource("").getPath());
    System.out.println(getPassword());
  }
}

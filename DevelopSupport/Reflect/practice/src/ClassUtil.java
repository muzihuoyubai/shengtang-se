import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class ClassUtil {

  public static void main(String[] args) {
    printInfo(0);
  }

  /**
   * 接收一个对象，输出对象类的所有方法和成员，分别按照名称升序排列
   *
   * @param object
   */
  public static void printInfo(Object object) {
    Class<?> aClass = object.getClass();
    Field[] declaredFields = aClass.getDeclaredFields();

    Arrays.sort(declaredFields,
        Comparator.comparing(o -> o.getName().toLowerCase()));
    // Arrays.sort(declaredFields, Comparator.comparing(Field::getName));

    for (Field declaredField : declaredFields) {
      System.out.println(declaredField);
    }

    Method[] declaredMethods = aClass.getDeclaredMethods();
    Arrays.sort(declaredMethods, Comparator.comparing(o -> o.getName().toLowerCase()));
    for (Method declaredMethod : declaredMethods) {
      System.out.println(declaredMethod);
    }
  }
}

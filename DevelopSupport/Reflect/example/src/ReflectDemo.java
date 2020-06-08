import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectDemo {

  private static String targetName = "Elephant";

  public void test() {
    System.out.println("hello");
  }

  public static void main(String[] args)
      throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, ClassNotFoundException, IOException {
    Class<ReflectDemo> reflectDemoClass = ReflectDemo.class;

    Method method = reflectDemoClass.getMethod("test");
    method.invoke(new ReflectDemo());

    new ReflectDemo().test();
    Properties properties = new Properties();
    properties.load(ReflectDemo.class.getResourceAsStream("/app.properties"));

    Class<?> aClass = Class.forName(properties.getProperty("target"));
    Animal o = (Animal) aClass.getDeclaredConstructor().newInstance();
    o.test();

  }
}

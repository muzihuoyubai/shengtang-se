import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class User implements Serializable {

  private String name;
  private String gender;

  public User(String name, String gender) {
    this.name = name;
    this.gender = gender;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  @Override
  public String toString() {
    return "User{" +
        "name='" + name + '\'' +
        ", gender='" + gender + '\'' +
        '}';
  }

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    User user = new User("张三", "男");

    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
    objectOutputStream.writeObject(user);

    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
        byteArrayOutputStream.toByteArray());
    ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
    User origin = (User) objectInputStream.readObject();
    System.out.println(origin);

    // FileInputStream
    // FileOutputStream

    // socket.getOutputStream
    // socket.getInputStream

    // ByteArrayInputStream
    // ByteArrayOutputStream

  }
}

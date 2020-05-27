package club.banyuan;

import java.io.Serializable;

public class Person implements Serializable {

  private String name;
  private int age;
  // 让对象序列化忽略此字段
  private transient String password;

  private Person son;

  public Person getSon() {
    return son;
  }

  public void setSon(Person son) {
    this.son = son;
  }

  public Person(String name, int age, String password) {
    this.name = name;
    this.age = age;
    this.password = password;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", password='" + password + '\'' +
        '}';
  }
}

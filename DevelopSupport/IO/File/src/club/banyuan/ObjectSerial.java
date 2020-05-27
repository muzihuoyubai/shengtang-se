package club.banyuan;

import com.alibaba.fastjson.JSONObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectSerial {

  public static void main(String[] args) throws IOException, ClassNotFoundException {

    File file = new File("/Users/liyi/Desktop/Objectfile.txt");

    ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
    Person lisi = new Person("李四", 30, "123456");
    System.out.println(lisi);
    objectOutputStream.writeObject(lisi);
    objectOutputStream.writeObject(new Person("王五",30));
    objectOutputStream.writeObject(new Person("赵六",30));

    objectOutputStream.close();

    ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
    Object object = objectInputStream.readObject();
    Person lisiCopy = (Person) object;
    System.out.println(lisi == lisiCopy);
    System.out.println(lisiCopy);
    System.out.println(objectInputStream.readObject());
    System.out.println(objectInputStream.readObject());
    objectInputStream.close();


  }
}

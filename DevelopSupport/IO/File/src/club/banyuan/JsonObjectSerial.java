package club.banyuan;

import com.alibaba.fastjson.JSONObject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class JsonObjectSerial {

  public static void main(String[] args) throws IOException, ClassNotFoundException {

    File file = new File("/Users/liyi/Desktop/Objectfile.txt");

    FileWriter fileWriter = new FileWriter(file);
    Person lisi = new Person("李四", 30, "123456");
    System.out.println(lisi);
    fileWriter.write(JSONObject.toJSONString(lisi));
    fileWriter.flush();
    fileWriter.close();

    BufferedReader reader = new BufferedReader(new FileReader(file));
    Person person = JSONObject.parseObject(reader.readLine(), Person.class);
    person.setSon(new Person("太子",12,"1234321"));
    System.out.println(person);
    System.out.println(JSONObject.toJSONString(person));


  }
}

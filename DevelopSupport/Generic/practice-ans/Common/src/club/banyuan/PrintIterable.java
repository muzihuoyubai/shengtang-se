package club.banyuan;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PrintIterable {

  public static <T> void printIterable(Iterable<T> iterable) {
    Iterator<T> iterator = iterable.iterator();
    StringBuilder stringBuilder = new StringBuilder();
    while (iterator.hasNext()) {
      stringBuilder.append(iterator.next().toString());
      stringBuilder.append(",");
    }
    stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
    System.out.println(stringBuilder.toString());
  }

  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("abcd");
    list.add("efgh");
    list.add("ijkl");
    printIterable(list);
  }
}

package club.banyuan;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapDemo {

  public static void main(String[] args) {
    Map<String, Integer> map = new HashMap<>();
    map.put("123", 123);
    for (Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
      stringIntegerEntry.getKey();
      stringIntegerEntry.getValue();
    }

    for (String key : map.keySet()) {
      Integer value = map.get(key);
    }

    for (Integer value : map.values()) {
      System.out.println(value);
    }


  }
}

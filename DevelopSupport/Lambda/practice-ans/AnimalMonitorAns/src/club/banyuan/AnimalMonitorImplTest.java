package club.banyuan;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.Test;

public class AnimalMonitorImplTest {

  @org.junit.Test
  public void printList() {
    AnimalMonitor animalMonitor = new AnimalMonitorImpl();
    animalMonitor.printList();
  }

  @org.junit.Test
  public void printSightingsOf() {
    AnimalMonitor animalMonitor = new AnimalMonitorImpl();
    animalMonitor.printSightingsOf("山地大猩猩");
  }

  @Test
  public void streamToCollection() {
    List<Sighting> sightings = new SightingFiller().getSightings();
    String animal = "山地大猩猩";
    List<Sighting> collect = sightings.stream()
        .filter(abc -> abc.getAnimal().equals(animal))
        .collect(Collectors.toList());

    Set<Sighting> set = sightings.stream()
        .filter(abc -> abc.getAnimal().equals(animal))
        .collect(Collectors.toSet());

    Map<String, List<Sighting>> map = sightings.stream()
        .filter(abc -> abc.getAnimal().equals(animal))
        // groupingBy中传入的是key的值的获取方式
        // value自动为对象的list
        .collect(Collectors.groupingBy(Sighting::getAnimal));

    Map<String, Sighting> collect2 = sightings.stream()
        .filter(abc -> abc.getAnimal().equals(animal))
        // toMap第一个参数决定map中的key，传入的参数数据类型和sightings集合中保存的元素数据类型一致，返回值数据类型要和Map中的key数据类型一致
        // 第二个参数决定map中的value，传入的参数数据类型和sightings集合中保存的元素数据类型一致，返回值数据类型要和Map中value数据类型一致
        // 第三个参数可选，是用来解决key冲突的问题，在遍历sightings集合过程中出现了两个相同的key，需要通过这个参数来解决两个value如何保存的问题。
        // 接收两个value对象，返回其中一个value对象，或者进行某些处理操作，返回的数据类型必须和Map中的value数据类型一致，并且和第二个参数的数据类型一致
        .collect(Collectors.toMap(Sighting::getAnimal, o2 -> o2, (val1, val2) -> val2));

  }

  @org.junit.Test
  public void printSightingsBy() {
  }

  @org.junit.Test
  public void printEndangered() {
  }

  @org.junit.Test
  public void printSightingsInPeriod() {
  }

  @org.junit.Test
  public void printSightingsOfInPeriod() {
  }

  @org.junit.Test
  public void printCounts() {
  }

  @org.junit.Test
  public void getCount() {
  }

  @org.junit.Test
  public void removeZeroCounts() {
  }

  @org.junit.Test
  public void getSightingsInArea() {
  }

  @org.junit.Test
  public void getSightingsOf() {
  }

  @org.junit.Test
  public void getAnimalBy() {
  }

  @org.junit.Test
  public void getSpotterBy() {
  }
}
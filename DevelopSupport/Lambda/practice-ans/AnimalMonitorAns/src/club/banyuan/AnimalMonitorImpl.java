package club.banyuan;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 监视不同种类动物的数量。由观察者记录目击事件。
 */
public class AnimalMonitorImpl implements AnimalMonitor {

  // 记录所有发现的动物。
  private List<Sighting> sightings;

  /**
   * 创建一个AnimalMonitor。
   */
  public AnimalMonitorImpl() {
    this.sightings = new SightingFiller().getSightings();
  }


  /**
   * 打印所有目击动物的详细信息。
   */
  @Override
  public void printList() {
    for (Sighting sighting : sightings) {
      printSighting(sighting);
    }
    sightings.forEach(t -> System.out.println(t.getDetails()));
    sightings.forEach(this::printSighting);
    sightings.forEach(Sighting::getAnimal);
  }

  private void printSighting(Sighting sighting) {
    System.out.println(sighting.getDetails());
  }

  /**
   * 打印给定动物的所有目击细节。
   *
   * @param animal 动物的类型。
   */
  @Override
  public void printSightingsOf(String animal) {
    List<Sighting> matches = new ArrayList<>();
    for (Sighting sighting : sightings) {
      if (sighting.getAnimal().equals(animal)) {
        matches.add(sighting);
      }
    }

    matches.forEach(this::printSighting);

    sightings.stream()
        .filter(abc -> abc.getAnimal().equals(animal))
        .forEach(this::printSighting);
  }

  /**
   * 打印给定观察者的所有目击动物。
   *
   * @param spotter 观察者的ID。
   */
  @Override
  public void printSightingsBy(int spotter) {
    sightings.stream()
        .filter(t -> t.getSpotter() == spotter)
        .forEach(this::printSighting);
  }

  /**
   * 打印一份被视为濒临灭绝的动物的清单。
   *
   * @param animalNames     动物名称列表。
   * @param dangerThreshold 小于或等于此级别的动物总数被认为濒临灭绝的
   */
  @Override
  public void printEndangered(List<String> animalNames, int dangerThreshold) {
    sightings.stream()
        .collect(Collectors
            .groupingBy(Sighting::getAnimal, Collectors.summingInt(Sighting::getCount)))
        .forEach((k, v) -> {
          if (v <= dangerThreshold && animalNames.contains(k)) {
            System.out.println("濒临灭绝的动物:" + k);
          }
        });
  }

  /**
   * 打印在特定期间periodID内记录的所有目击事件的详细信息，并将其作为参数传递给该方法
   *
   * @param period 日期ID
   * @return 指定日期的清单
   */
  @Override
  public List<Sighting> printSightingsInPeriod(int period) {
    return sightings.stream().filter(t -> t.getPeriod() == period).collect(Collectors.toList());
  }

  /**
   * 打印并返回指定日期区间内的清单
   *
   * @param fromPeriod 日期开始
   * @param toPeriod   日期结束
   * @param animal     动物类型
   */
  @Override
  public List<Sighting> printSightingsOfInPeriod(int fromPeriod, int toPeriod, String animal) {
    return sightings.stream().filter(
        t -> t.getPeriod() >= fromPeriod && t.getPeriod() <= toPeriod && t.getAnimal()
            .equals(animal)).collect(
        Collectors.toList());
  }

  /**
   * 打印特定动物类型的总的目击数量
   *
   * @param animal 动物类型
   */
  @Override
  public List<Sighting> printCounts(String animal) {
    Map<String, List<Sighting>> collect = sightings.stream()
        .collect(Collectors.groupingBy(Sighting::getAnimal));
    return collect.get(animal);
  }

  /**
   * 返回给定动物目击次数。
   *
   * @param animal 动物的类型。
   * @return 给定动物的目击次数总数。
   */
  @Override
  public int getCount(String animal) {
    return sightings.stream().filter(t -> t.getAnimal().equals(animal)).mapToInt(Sighting::getCount)
        .sum();
  }

  /**
   * 从发现清单中删除计数为零的记录。
   */
  @Override
  public void removeZeroCounts() {
    sightings.removeIf(t -> t.getCount() == 0);
  }

  /**
   * 返回特定区域内给定类型的动物的所有动物清单。
   *
   * @param animal 动物的类型。
   * @param area   区域的ID。
   * @return 目击清单。
   */
  @Override
  public List<Sighting> getSightingsInArea(String animal, int area) {
    return sightings.stream().filter(t -> t.getAnimal().equals(animal) && t.getArea() == area)
        .collect(
            Collectors.toList());
  }

  /**
   * 返回给定动物的所有目击清单。
   *
   * @param animal 动物的类型。
   * @return 给定动物的所有目击物清单。
   */
  @Override
  public List<Sighting> getSightingsOf(String animal) {
    return sightings.stream().filter(t -> t.getAnimal().equals(animal))
        .collect(Collectors.toList());
  }

  /**
   * @param spotter
   * @param period
   * @return 包含该观察者在特定日期看到的动物的名称，只包括数量大于零的动物
   */
  @Override
  public List<String> getAnimalBy(int spotter, int period) {
    return sightings.stream().filter(t -> t.getSpotter() == spotter && t.getPeriod() == period)
        .map(Sighting::getAnimal).collect(
            Collectors.toList());
  }

  /**
   * @param animal
   * @param period
   * @return 在该特定日期看到该动物的观察者
   */
  @Override
  public List<Integer> getSpotterBy(String animal, int period) {
    return sightings.stream()
        .filter(t -> t.getPeriod() == period && t.getAnimal().equals(animal))
        .map(Sighting::getSpotter).distinct().collect(Collectors.toList());
  }
}

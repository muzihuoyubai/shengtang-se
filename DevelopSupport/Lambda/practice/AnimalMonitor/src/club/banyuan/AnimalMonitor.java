package club.banyuan;

import java.util.ArrayList;
import java.util.List;

public interface AnimalMonitor {

  /**
   * 打印所有目击动物的详细信息。
   */
  void printList();

  /**
   * 打印给定动物的所有目击细节。
   *
   * @param animal 动物的类型。
   */
  void printSightingsOf(String animal);

  /**
   * 打印给定观察者的所有目击动物。
   *
   * @param spotter 观察者的ID。
   */
  void printSightingsBy(int spotter);

  /**
   * 打印一份被视为濒临灭绝的动物的清单。
   *
   * @param animalNames     动物名称列表。
   * @param dangerThreshold 小于或等于此级别的动物总数被认为濒临灭绝的
   */
  void printEndangered(ArrayList<String> animalNames,
      int dangerThreshold);

  /**
   * 返回给定动物目击次数。
   *
   * @param animal 动物的类型。
   * @return 给定动物的目击次数总数。
   */
  int getCount(String animal);

  /**
   * 从发现清单中删除计数为零的记录。
   */
  void removeZeroCounts();

  /**
   * 返回特定区域内给定类型的动物的所有动物清单。
   *
   * @param animal 动物的类型。
   * @param area   区域的ID。
   * @return 目击清单。
   */
  List<Sighting> getSightingsInArea(String animal, int area);

  /**
   * 返回给定动物的所有目击清单。
   *
   * @param animal 动物的类型。
   * @return 给定动物的所有目击物清单。
   */
  List<Sighting> getSightingsOf(String animal);
}

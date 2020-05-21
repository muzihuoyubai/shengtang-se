package club.banyuan;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 比较在基于数组的列表和基于链表的列表的第一个元素前插入n个值所需的时间
 * <p>
 * 1.创建一个计时器。
 * <p>
 * 2.计算将n个值添加到空链表的时间：
 * a.创建一个空的链表
 * b.启动计时器
 * c.依次将0..n-1中的每个值i插入到list中
 * d.停止计时器
 * e.显示时间
 * <p>
 * 3.计算将n个值添加到空数组列表的时间：
 * a.创建一个空的数组列表
 * b.启动计时器
 * c.依次将0..n-1中的每个值i插入到list中
 * d.停止计时器
 * e.显示时间
 */
public class Prepend {

  private static final int NUMBER_TOTAL = 10000;

  public static void main(String[] args) {
    Timer theTimer = new TimerImpl();
    // Linked List
    List<Integer> aLinkedList = new LinkedList<>();
    countListPrependTime(theTimer, aLinkedList);

    // ArrayList
    List<Integer> anArrayList = new ArrayList<>(NUMBER_TOTAL);
    countListPrependTime(theTimer, anArrayList);
  }

  private static void countListPrependTime(Timer theTimer, List<Integer> aLinkedList) {
    theTimer.start();
    for (int i = 0; i < NUMBER_TOTAL; i++) {
      aLinkedList.add(0, i);
    }
    theTimer.stop();
    String name = aLinkedList.getClass().getName();
    name = name.substring(name.lastIndexOf(".") + 1);
    System.out.println("向" + name + "插入" + NUMBER_TOTAL + "个元素，共耗时"
        + theTimer.getTimeMillisecond() + "毫秒。");
  }
}
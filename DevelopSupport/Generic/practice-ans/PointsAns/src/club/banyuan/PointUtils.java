package club.banyuan;

import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;
import org.junit.Assert;
import org.junit.Test;

public class PointUtils {

  /**
   * 返回具有最大Y值的点。如果存在多个这样的点，则只需选择一个即可。
   */
  public static Point highestPoint(List<Point> points) {
    Iterator<Point> pointIterator = points.iterator();

    Point rlt = points.get(0);
    while (pointIterator.hasNext()) {
      Point point = pointIterator.next();
      if (point.getY() > rlt.getY()) {
        rlt = point;
      }
    }
    return rlt;

    // 方案一
    // Point rlt = points.get(0);
    // for (Point point : points) {
    //   if (point.getY() > rlt.getY()) {
    //     rlt = point;
    //   }
    // }
    //
    // return rlt;

    // 方案二
    // Point rlt = points.get(0);
    // for (int i = 0; i < points.size(); i++) {
    //   if (points.get(i).getY() > rlt.getY()) {
    //     rlt = points.get(i);
    //   }
    // }
    // return rlt;

  }

  /**
   * 返回一个新点，新点的X值是所有给定点的X值的平均值，Y值是所有给定点的Y值的平均值。
   */
  public static Point centroid(List<Point> points) {
    if (points == null || points.size() == 0) {
      return null;
    }

    int sumX = 0, sumY = 0;

    Iterator<Point> pointIterator = points.iterator();
    while (pointIterator.hasNext()) {
      Point next = pointIterator.next();
      sumX += next.getX();
      sumY += next.getY();
    }
    int size = points.size();
    return new Point(sumX / size, sumY / size);
  }

  @Test
  public void test() {
    List<Point> points = new LinkedList<>();
    points.add(new Point(1, 1));
    points.add(new Point(1, 3));
    points.add(new Point(3, 1));
    points.add(new Point(3, 3));

    /* 应该是Point [x = 3，y = 3]或Point [x = 1，y = 3] */
    Point highestPoint = highestPoint(points);

    // TODO 编写一个单元测试
    // assert 结果是[x = 3，y = 3] 或  [x = 1，y = 3]中的一个
    Assert.assertEquals(3, highestPoint.getY());
    Assert.assertTrue(highestPoint.equals(new Point(1, 3)) || highestPoint.equals(new Point(3, 3)));

    // 应该是Point[x=2,y=2]
    Point centroid = centroid(points);
    // TODO 编写一个单元测试测试结果
    Assert.assertEquals(2, centroid.getX());
    Assert.assertEquals(2, centroid.getY());

    points = new LinkedList<Point>();
    points.add(new Point(1, 1));
    points.add(new Point(1, -1));
    points.add(new Point(-1, 1));
    points.add(new Point(-1, -1));

    highestPoint = highestPoint(points);
    /* 应该是Point[x=1,y=1] 或[x=-1,y=1] */
    // TODO 编写一个单元测试
    // assert 结果是[x=1,y=1] 或  [x=-1,y=1]中的一个
    Assert.assertTrue(highestPoint.equals(new Point(1, 1)) || highestPoint.equals(new Point(-1, 1)));

    // 应该是[x=0,y=0]
    centroid = centroid(points);
    // TODO 编写一个单元测试测试结果
    Assert.assertEquals(0, centroid.getX());
    Assert.assertEquals(0, centroid.getY());
  }
}

/**
 * 数据运算演示
 *
 * @author www.banyuan.club
 */
public class RelationDemo {

  public static void main(String[] args) {

    // 关系运算符最后返回一个boolean类型
    System.out.println(5 >= 6); // false
    System.out.println(7 <= 8.3); // true
    System.out.println(3 != 4); // true
    System.out.println(true == false); // false
    System.out.println(1 == 1.1); // false
    System.out.println(3 == 3.0); // true

    // 逻辑运算符，参与的两个操作数是boolean类型，返回一个boolean类型
    System.out.println(true || false); // true
    System.out.println(true && false); // false
    System.out.println(!true); // false
    System.out.println(true ^ false); // true

    // 短路
    int a = 1;
    // 可以直接通过 && 左侧的false判断结果是false，右侧表达式不会进行计算
    boolean and = false && (++a > 1);
    System.out.println(and); // false
    System.out.println(a); // 1

    a = 1;
    // 不会出现短路的情况
    and = false & (++a > 1);
    System.out.println(and); // false
    System.out.println(a); // 2
  }
}

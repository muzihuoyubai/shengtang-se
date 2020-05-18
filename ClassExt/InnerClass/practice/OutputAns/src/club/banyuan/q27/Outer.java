// package club.banyuan.q27;
//
// public class Outer {
//
//   public static int temp1 = 1;
//   private static int temp2 = 2;
//   public int temp3 = 3;
//   private int temp4 = 4;
//
//   public static class Inner {
//
//     private static int temp5 = 5;
//
//     // 不能访问temp3 和temp4 这两个成员必须要创建Outer的对象，而此方法调用的时候，Outer的对象可能没有被创建
//     // 可以这样写
//     // return (temp1 + temp2 + new Outer().temp3 + new Outer().temp4 + temp5);
//     private static int getSum() {
//       return (temp1 + temp2 + temp3 + temp4 + temp5);
//     }
//   }
//
//   public static void main(String[] args) {
//     Outer.Inner obj = new Outer.Inner();
//     System.out.println(obj.getSum());
//   }
//
// }
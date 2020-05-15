// package club.banyuan.q4;
//
// class Base extends Exception {
//
// }
//
// class Derived extends Base {
//
// }
//
// public class Main {
//
//   public static void main(String args[]) {
//     // some other stuff
//     try {
//       // Some monitored code
//       throw new Derived();
//     } catch (Base b) { // 接收所有Base 类或是其子类的异常类对象
//       System.out.println("Caught base class exception");
//     } catch (Derived d) { // 编译报错。这个子类对象的异常处理已经被上面的catch处理了，代码永远不会执行到这里
//       System.out.println("Caught derived class exception");
//     }
//   }
// }
package club.banyuan.sync.staticmethod;

public class Demo {

  public static void main(String[] args) {
    Customer zhangsan = new Customer("张三");
    Customer lisi = new Customer("李四");

    Thread zhangsanThread = new Thread(zhangsan);
    Thread lisiThread = new Thread(lisi);

    zhangsanThread.start();
    lisiThread.start();



  }
}

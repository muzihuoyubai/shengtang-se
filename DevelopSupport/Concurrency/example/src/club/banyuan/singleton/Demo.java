package club.banyuan.singleton;

public class Demo {

  public static void main(String[] args) {
    Shop shop = Shop.getInstance();
    Customer zhangsan = new Customer("张三", shop);
    Customer lisi = new Customer("李四", shop);

    Thread zhangsanThread = new Thread(zhangsan);
    Thread lisiThread = new Thread(lisi);

    zhangsanThread.start();
    lisiThread.start();


  }
}

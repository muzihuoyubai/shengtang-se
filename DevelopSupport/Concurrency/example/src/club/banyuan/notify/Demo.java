package club.banyuan.notify;

public class Demo {

  public static void main(String[] args) {
    Shop shop = Shop.getInstance();
    Customer zhangsan = new Customer("张三", shop);
    Customer lisi = new Customer("李四", shop);
    Customer wangwu = new Customer("王五", shop);

    zhangsan.start();
    lisi.start();
    wangwu.start();

    Factory factory = new Factory("第一家工厂", shop);
    Factory factory1 = new Factory("第二家工厂", shop);
    Factory factory2 = new Factory("第三家工厂", shop);
    factory.start();
    factory1.start();
    factory2.start();

  }
}

package club.banyuan.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Shop {

  private static final Shop shop = new Shop();
  private static final Lock lock = new ReentrantLock();
  private static final Condition prodCondition = lock.newCondition();
  private static final Condition custCondition = lock.newCondition();

  private int inventory = 10;
  private static final int MAX_STORE = 100;

  private Shop() {
  }

  public static Shop getInstance() {
    return shop;
  }

  public int getInventory() {
    return inventory;
  }

  public void setInventory(int inventory) {
    this.inventory = inventory;
  }


  public void buy(Customer customer) {
    lock.lock();
    if (inventory > 0) {
      System.out.println(customer.getName() + "购买了一件商品");
      inventory--;
      System.out.println("库存：" + inventory);
    } else {
      while (inventory <= 0) {
        System.out.println("商品不足！");
        try {
          prodCondition.signalAll();
          custCondition.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
    lock.unlock();
  }

  public void store(Factory factory) {
    lock.lock();
    if (inventory < MAX_STORE) {
      System.out.println(factory.getName() + "存入了一件商品");
      inventory++;
      System.out.println("库存：" + inventory);
      custCondition.signalAll();
    } else {
      while (inventory >= MAX_STORE) {
        System.out.println("库存已达到上线");
        try {
          prodCondition.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
    lock.unlock();
  }

}

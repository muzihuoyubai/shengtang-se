public class Driver {

  public static void main(String[] args) {
    // 创建一个电话
    CellularPhone aPhone = new CellularPhone("Phone");
    aPhone.start();

    // 创建两个呼叫生成器，他们坚持不断地给电话打电话。
    PhoneCallGenerator pcGen1 = new PhoneCallGenerator("Tom", aPhone);
    PhoneCallGenerator pcGen2 = new PhoneCallGenerator("Jerry", aPhone);
    pcGen1.start();
    pcGen2.start();

    MessageGenerator mother = new MessageGenerator("Mother", aPhone);
    MessageGenerator father = new MessageGenerator("Father", aPhone);
    mother.start();
    father.start();

    try {
      // 等待，直到所有的电话都结束
      pcGen1.join();
      pcGen2.join();

      mother.join();
      father.join();

      // 停止电话
      aPhone.stopPhone();
    } catch (InterruptedException ie) {
      // 必须要处理的join抛出的异常
      System.exit(1);
    }
  }
}

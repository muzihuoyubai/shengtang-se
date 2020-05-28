package club.banyuan.main;

import club.banyuan.machine.VendingMachine;
import club.banyuan.machine.VendingMachineStorageable;
import club.banyuan.machine.VendingMachineWithMenu;
import club.banyuan.machine.VmsStorageUtil;

public class Main {

  public static void main(String[] args) {
    // VendingMachine vendingMachine = new VendingMachine();
    // vendingMachine.start();
    // VendingMachineWithMenu vendingMachineWithMenu = new VendingMachineWithMenu();
    // vendingMachineWithMenu.start();

    VendingMachineStorageable vendingMachineStorageable = null;
    try {
      vendingMachineStorageable = VmsStorageUtil.load();
    } catch (Exception e) {
      System.err.println("读取售货机文件失败！");
      vendingMachineStorageable = new VendingMachineStorageable();
      e.printStackTrace();
    }
    vendingMachineStorageable.start();
  }
}

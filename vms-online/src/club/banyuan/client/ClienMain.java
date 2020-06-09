package club.banyuan.client;

import club.banyuan.machine.VendingMachineStorageable;
import club.banyuan.machine.VendingMachineWithMenu;
import club.banyuan.machine.VmsStorageUtil;

public class ClienMain {

  public static void main(String[] args) {
    // VendingMachine vendingMachine = new VendingMachine();
    // vendingMachine.start();
    VendingMachineWithMenu vendingMachineWithMenu = new VendingMachineWithMenu();
    vendingMachineWithMenu.start();
  }
}

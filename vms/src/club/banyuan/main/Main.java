package club.banyuan.main;

import club.banyuan.machine.VendingMachine;
import club.banyuan.machine.VendingMachineWithMenu;

public class Main {

  public static void main(String[] args) {
    // VendingMachine vendingMachine = new VendingMachine();
    // vendingMachine.start();
    VendingMachineWithMenu vendingMachineWithMenu = new VendingMachineWithMenu();
    vendingMachineWithMenu.start();
  }
}

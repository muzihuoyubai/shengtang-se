package club.banyuan.server;

import club.banyuan.machine.MessageServer;
import club.banyuan.machine.VendingMachineStorageable;
import club.banyuan.machine.VmsStorageUtil;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

  public static void main(String[] args) throws IOException {
    VendingMachineStorageable vendingMachineStorageable = null;
    try {
      vendingMachineStorageable = VmsStorageUtil.load();
    } catch (Exception e) {
      System.err.println("读取售货机文件失败！");
      vendingMachineStorageable = new VendingMachineStorageable();
      e.printStackTrace();
    }

    ServerSocket serverSocket = new ServerSocket(10000);
    while (true) {
      Socket accept = serverSocket.accept();
      System.out.println("售货机客户端接入。。。");
      MessageServer messageServer = new MessageServer();
      messageServer.sendMessage(vendingMachineStorageable, accept);
    }
  }
}

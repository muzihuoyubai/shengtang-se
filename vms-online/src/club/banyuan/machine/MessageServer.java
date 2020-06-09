package club.banyuan.machine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.Optional;

public class MessageServer {

  public void sendMessage(VendingMachineStorageable vendingMachineStorageable, Socket socket)
      throws IOException {
    BufferedReader bufferedReader = new BufferedReader(
        new InputStreamReader(socket.getInputStream()));

    MessageType messageType = MessageType.valueOf(bufferedReader.readLine());
    switch (messageType) {
      case MACHINE:
        sendMachineStatus(vendingMachineStorageable, socket);
        break;
      case INSERT_COIN:
        int userInput = Integer.parseInt(bufferedReader.readLine());
        int amount = vendingMachineStorageable.getUserAmount() + userInput;
        vendingMachineStorageable.setUserAmount(amount);
        sendMachineStatus(vendingMachineStorageable, socket);
        break;
      case PURCHASE:
        String code = bufferedReader.readLine();
        Shelf[] shelves = vendingMachineStorageable.getShelves();
        Optional<Shelf> first = Arrays.stream(shelves)
            .filter(t -> t.getCode().equals(code)).findFirst();
        if (first.isPresent()) {
          Shelf purchase = first.get();
          int userAmount = vendingMachineStorageable.getUserAmount();
          int salesAmount = vendingMachineStorageable.getSalesAmount();
          if (purchase.getInventory() > 0 && userAmount >= purchase.getPrice()) {
            userAmount -= purchase.getPrice();
            salesAmount += purchase.getPrice();
            purchase.setInventory(purchase.getInventory() - 1);
            vendingMachineStorageable.setUserAmount(userAmount);
            vendingMachineStorageable.setSalesAmount(salesAmount);
            BufferedWriter bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write("SUCCESS");
            bufferedWriter.newLine();
            bufferedWriter.flush();
            socket.close();
            return;
          }
        }

        BufferedWriter bufferedWriter = new BufferedWriter(
            new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("FAIL");
        bufferedWriter.newLine();
        bufferedWriter.flush();
        socket.close();
    }
    // sendShelves(vendingMachineStorageable, socket);

  }

  private void sendMachineStatus(VendingMachineStorageable vendingMachineStorageable,
      Socket socket) throws IOException {
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

    objectOutputStream.writeObject(vendingMachineStorageable);

    socket.close();
  }

  public void sendShelves(VendingMachineStorageable vendingMachineStorageable, Socket socket)
      throws IOException {
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

    Shelf[] shelves = vendingMachineStorageable.getShelves();
    for (Shelf shelf : shelves) {
      objectOutputStream.writeObject(shelf);
    }

    socket.close();
  }
}

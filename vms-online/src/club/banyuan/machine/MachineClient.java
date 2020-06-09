package club.banyuan.machine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class MachineClient {

  public Socket getConnection() throws IOException {
    return new Socket("127.0.0.1", 10000);
  }

  public void closeConnection(Socket socket) throws IOException {
    socket.close();
  }

  public VendingMachineStorageable getMachineStatus() {
    try {
      Socket connection = getConnection();
      BufferedWriter bufferedWriter = new BufferedWriter(
          new OutputStreamWriter(connection.getOutputStream()));
      bufferedWriter.write(MessageType.MACHINE.toString());
      bufferedWriter.newLine();
      bufferedWriter.flush();

      ObjectInputStream objectInputStream = new ObjectInputStream(connection.getInputStream());
      VendingMachineStorageable rlt = (VendingMachineStorageable) objectInputStream.readObject();
      closeConnection(connection);
      return rlt;
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
      throw new VendingMachineException("通信异常");
    }
  }

  public Shelf[] getShelves() {
    return getMachineStatus().getShelves();
  }

  public VendingMachineStorageable insertCoin(int coin) {
    try {
      Socket connection = getConnection();
      BufferedWriter bufferedWriter = new BufferedWriter(
          new OutputStreamWriter(connection.getOutputStream()));
      bufferedWriter.write(MessageType.INSERT_COIN.toString());
      bufferedWriter.newLine();
      bufferedWriter.write(coin + "");
      bufferedWriter.newLine();
      bufferedWriter.flush();

      ObjectInputStream objectInputStream = new ObjectInputStream(connection.getInputStream());
      VendingMachineStorageable object = (VendingMachineStorageable) objectInputStream.readObject();

      closeConnection(connection);
      return object;
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
      throw new VendingMachineException("通信异常");
    }
  }

  public boolean purchase(Shelf purchase) {
    try {
      Socket connection = getConnection();
      BufferedWriter bufferedWriter = new BufferedWriter(
          new OutputStreamWriter(connection.getOutputStream()));
      bufferedWriter.write(MessageType.PURCHASE.toString());
      bufferedWriter.newLine();
      bufferedWriter.write(purchase.getCode());
      bufferedWriter.newLine();
      bufferedWriter.flush();

      BufferedReader bufferedReader = new BufferedReader(
          new InputStreamReader(connection.getInputStream()));

      boolean rlt = "SUCCESS".equals(bufferedReader.readLine());
      closeConnection(connection);
      return rlt;

    } catch (IOException e) {
      e.printStackTrace();
      throw new VendingMachineException("通信异常");
    }
  }
}

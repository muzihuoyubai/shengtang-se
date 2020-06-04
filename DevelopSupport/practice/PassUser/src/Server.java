import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(10000);
    Socket socket = serverSocket.accept();

    ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
    objectOutputStream.writeObject(new User("张三", "男"));

    serverSocket.close();
  }
}

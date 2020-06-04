import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Client {

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    Socket socket = new Socket("127.0.0.1", 10000);
    ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
    User user = (User) objectInputStream.readObject();
    System.out.println(user);

    socket.close();
  }
}

package club.banyuan;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileUploadServer {

  public static void main(String[] args) {
    File parentFolder = createParentFolder();
    try (ServerSocket serverSocket = new ServerSocket(10000)) {
      Socket socket = serverSocket.accept();
      String hostAddress = socket.getInetAddress().getHostAddress();
      System.out.println(hostAddress + "接入服务器。。");
      InputStream inputStream = socket.getInputStream();
      int fileNameLength = getFileNameLength(inputStream);
      File file = getFile(parentFolder, inputStream, fileNameLength);
      saveFile(inputStream, file);
      System.out.println("程序结束");
    } catch (IOException e) {
      e.printStackTrace();
    }


  }

  public static File createParentFolder() {
    // 获取class path，如果不加"/" 获取到的是当前类所在的路径，即带有包路径的路径
    // 加了"/"表示获取class path的根路径
    String rootPath = FileUploadServer.class.getResource("/").getPath();
    File parentFolder = new File(rootPath, "upload");
    if (!parentFolder.exists() || !parentFolder.isDirectory()) {
      parentFolder.mkdir();
    }
    return parentFolder;
  }

  public static void saveFile(InputStream inputStream, File file) throws IOException {
    int count;
    byte[] buf = new byte[1024];
    FileOutputStream fileOutputStream = new FileOutputStream(file);
    int fileLength = parseHead(inputStream);
    System.out.println("文件内容长度:" + fileLength);
    int remain = fileLength;
    while (remain != 0) {
      count = inputStream.read(buf, 0, Math.min(buf.length, remain));
      fileOutputStream.write(buf, 0, count);
      remain -= count;
    }
  }

  public static File getFile(File parentFolder, InputStream inputStream, int fileNameLength)
      throws IOException {
    byte[] buf = new byte[1024];
    int count = inputStream.read(buf, 0, Math.min(buf.length, fileNameLength));
    String filename = new String(buf, 0, count);
    System.out.println("filename：" + filename);
    return new File(parentFolder, filename);
  }

  public static int getFileNameLength(InputStream inputStream) throws IOException {
    int fileNameLength = parseHead(inputStream);
    System.out.println("文件名长度：" + fileNameLength);
    if (fileNameLength > 1024) {
      throw new RuntimeException("名字长度过长:" + fileNameLength);
    }
    return fileNameLength;
  }

  public static int parseHead(InputStream inputStream) throws IOException {
    byte[] head = new byte[4];
    int count = inputStream.read(head);
    if (count < head.length) {
      throw new RuntimeException("格式不合法");
    }

    return BytesUtil.parse(head);
  }
}

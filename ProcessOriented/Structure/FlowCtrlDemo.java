import org.w3c.dom.ls.LSOutput;

public class FlowCtrlDemo {

  public static void main(String[] args) {

    /*
     * 单行语句
     */
    boolean condition = true;
    while (condition)
      condition = false;

    do
      condition = false;
    while(condition);

    for(;;)
      break;
  }
}

package club.banyuan;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    Resp[] root = new Resp[]{new Resp(1001, "A", null, 1)};
    Resp[] pRoot = new Resp[]{new Resp(1002, "B", 1001, 1), new Resp(1003, "C", 1001, 2)};
    Resp[] pB = new Resp[]{new Resp(1003, "D", 1001, 1), new Resp(1005, "E", 1001, 2)};
    Resp[] pE = new Resp[]{new Resp(1006, "F", 1005, 1), new Resp(1007, "G", 1005, 2)};
    Resp[] pC = new Resp[]{new Resp(1008, "H", 1003, 1), new Resp(1009, "I", 1003, 2),
        new Resp(1010, "J", 1003, 3)};
    root[0].children = new ArrayList<>(Arrays.asList(pRoot));
    pRoot[0].children = new ArrayList<>(Arrays.asList(pB));
    pB[1].children = new ArrayList<>(Arrays.asList(pE));
    pRoot[1].children = new ArrayList<>(Arrays.asList(pC));

    RespHtml.cal(Arrays.asList(root));
    System.out.println(root);

    RespHtml.printHtml(root[0]);
  }
}

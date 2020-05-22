package club.banyuan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RespHtml {

  // 判断跨多少行
  // 1. 有兄弟节点
  // 2. 兄弟节点有子节点，自己没有
  // 3. 跨多少行？  = 兄弟节点的子节点层级最深的那一级

  // 判断跨多少列
  // 当前节点下，有多少个叶子节点（没有子节点的节点）
  public static void cal(List<Resp> node) {
    if (node == null || node.size() == 0) {
      return;
    }
    calRow(node);
    calCol(node);

    // 对于节点下都没有子节点的节点，这些节点可能需要跨行，跨行根据当前节点据最深节点的差值

    List<List<Resp>> reform = reform(node);

    for (int i = 0; i < reform.size(); i++) {
      for (int j = 0; j < reform.get(i).size(); j++) {
        if (reform.get(i).get(j).children == null) {
          reform.get(i).get(j).setRowspan(reform.size() - i - 1);
        }
      }
    }


  }

  // 判断跨多少行
  // 1. 有兄弟节点
  // 2. 兄弟节点有子节点，自己没有
  // 3. 跨多少行？  = 兄弟节点的子节点层级最深的那一级
  public static void calRow(List<Resp> node) {
    if (node == null || node.size() == 0) {
      return;
    }

    if (node.size() == 1) {
      calRow(node.get(0).children);
    } else {
      List<Resp> noChildNodes = node.stream()
          .filter(t -> t.children == null || t.children.size() == 0)
          .collect(Collectors.toList());
      // noChildNodes 内容需要增加跨行，跨多少行需要根据子节点深度确定
      if (noChildNodes.size() < node.size()) {
        List<Resp> brotherWithChild = new ArrayList<>(node);
        brotherWithChild.removeAll(noChildNodes);
        int rowSpan = calChildNodeDeep(brotherWithChild);
        noChildNodes.forEach(t -> {
          t.setRowspan(rowSpan);
        });
      }
      for (Resp resp : node) {
        calRow(resp.children);
      }
    }
  }

  private static int calChildNodeDeep(List<Resp> node) {
    int rlt = 0;
    for (Resp resp : node) {
      int nodeDeep = getNodeDeep(resp, 0);
      if (nodeDeep > rlt) {
        rlt = nodeDeep;
      }
    }
    return rlt;
  }

  private static int getNodeDeep(Resp node, int deepLevel) {
    int rlt = deepLevel;
    if (node == null || node.children == null || node.children.size() == 0) {
      return rlt;
    }
    for (Resp child : node.children) {
      int nodeDeep = getNodeDeep(child, deepLevel + 1);
      if (nodeDeep > rlt) {
        rlt = nodeDeep;
      }
    }
    return rlt;
  }

  // 判断跨多少列
  // 当前节点下，有多少个叶子节点（没有子节点的节点）
  public static void calCol(List<Resp> node) {
    if (node == null || node.size() == 0) {
      return;
    }

    for (Resp resp : node) {
      resp.setColspan(getNoChildNodeTotal(resp, 0));
      calCol(resp.children);
    }
  }

  private static int getNoChildNodeTotal(Resp resp, int total) {
    if (resp == null || resp.children == null) {
      return total;
    }
    for (Resp child : resp.children) {
      if (child.children == null || child.children.size() == 0) {
        total++;
      }
    }

    List<Resp> collect = resp.getChildren().stream()
        .filter(t -> t.children != null && t.children.size() > 0).collect(
            Collectors.toList());

    for (Resp resp1 : collect) {
      total = getNoChildNodeTotal(resp1, total);
    }
    return total;
  }

  public static void printHtml(Resp resp) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(
        "<table  border=\"1px solid black\" align=\"center\" style=\"text-align: center\">");
    // printTd(resp, stringBuilder);
    List<List<Resp>> reform = reform(Arrays.asList(resp));
    for (List<Resp> resps : reform) {
      stringBuilder.append("<tr>");
      for (Resp resp1 : resps) {
        printTd(resp1, stringBuilder);
      }
      stringBuilder.append("</tr>");
    }

    // printRow(resp.getChildren(), stringBuilder);
    stringBuilder.append("</table>");
    System.out.println(stringBuilder.toString());
  }

  public static List<List<Resp>> reform(List<Resp> list) {
    List<List<Resp>> rlt = new ArrayList<>();
    rlt.add(new ArrayList<>());

    for (Resp resp : list) {
      rlt.get(0).add(resp);
    }

    for (Resp resp : list) {
      reform(rlt, resp.children, 1);
    }
    return rlt;
  }

  public static void reform(List<List<Resp>> target, List<Resp> list, int level) {
    if (list == null || list.size() == 0) {
      return;
    }
    target.add(new ArrayList<>());
    for (Resp resp : list) {
      target.get(level).add(resp);
    }
    for (Resp resp : list) {
      reform(target, resp.children, level + 1);
    }
  }

  public static void printRow(List<Resp> list, StringBuilder builder) {
    if (list == null) {
      return;
    }
    builder.append("<tr>");
    for (Resp resp : list) {
      printTd(resp, builder);
    }
    builder.append("</tr>");
    for (Resp resp : list) {
      printRow(resp.children, builder);
    }
  }

  private static void printTd(Resp resp, StringBuilder builder) {
    builder.append("<td");
    if (resp.getColspan() != 0) {
      builder.append(" colspan='" + (resp.getColspan() == 1 ? 2 : resp.getColspan()) + "'");
    }
    if (resp.getRowspan() != 0) {
      builder.append(" rowspan='" + (resp.getRowspan() == 1 ? 2 : resp.getRowspan()) + "'");
    }

    builder.append(">").append(resp.getName()).append("</td>");
  }

}

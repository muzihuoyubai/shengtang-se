package club.banyuan.menu;

import club.banyuan.machine.FlowStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Menu {

  private MenuNode root;
  private MenuNode curNode;
  private final List<MenuNode> allNodes = new ArrayList<>();

  public Menu(List<MenuNode> allNodes) {
    for (MenuNode allNode : allNodes) {
      addMenuNode(allNode);
    }
    if (root == null) {
      throw new IllegalArgumentException("没有根节点");
    }
    curNode = root;
  }

  public MenuNode getRoot() {
    return root;
  }

  public void setRoot(MenuNode root) {
    this.root = root;
  }

  public MenuNode getCurNode() {
    return curNode;
  }

  public void setCurNode(MenuNode curNode) {
    this.curNode = curNode;
  }

  public void addMenuNode(MenuNode menuNode) {
    if (menuNode.getMenuType() == MenuType.ROOT) {
      if (root != null) {
        throw new IllegalArgumentException("已经存在根节点");
      }
      root = menuNode;
    }
    allNodes.forEach(t -> {
      if (t.getFlowStatus() == menuNode.getParentStatus()) {
        t.addSubMenu(menuNode);
      }

      if (t.getParentStatus() == menuNode.getFlowStatus()) {
        menuNode.addSubMenu(t);
      }
    });
    allNodes.add(menuNode);
  }

  public void display() {
    System.out.println(curNode.getTitle());
    if (curNode.getSubMenus() != null) {
      for (MenuNode subMenu : curNode.getSubMenus()) {
        System.out.println(subMenu.getDesc());
      }
    }
  }

  public MenuNode scanUserInput() {
    Scanner scanner = new Scanner(System.in);
    System.out.println();
    System.out.print("Your choice: ");
    String userInput = scanner.next();
    Optional<MenuNode> selectNode = curNode.getSubMenus().stream()
        .filter(t -> t.getInputMatches().equals(userInput)).findFirst();

    if (selectNode.isPresent()) {
      return selectNode.get();
    } else {
      System.out.println("Invalid choice!");
      System.out.println();
      display();
      return scanUserInput();
    }
  }

  public FlowStatus toNextMenu(MenuNode menuNode) {

    Optional<MenuNode> nextMenu = allNodes.stream().filter(t -> t == menuNode).findFirst();
    if (nextMenu.isPresent()) {
      curNode = menuNode;
      return curNode.getFlowStatus();
    } else {
      throw new IllegalArgumentException("节点不存在:" + menuNode);
    }
  }

  public MenuNode toNextMenu() {
    curNode = curNode.getSubMenus().get(0);
    return curNode;
  }

  public MenuNode back() {
    curNode = curNode.getParentNode();
    return curNode;
  }

  public void toNextMenu(FlowStatus flowStatus) {
    Optional<MenuNode> menuNode = allNodes.stream().filter(t -> t.getFlowStatus() == flowStatus)
        .findFirst();
    if (menuNode.isPresent()) {
      curNode = menuNode.get();
    } else {
      throw new IllegalArgumentException("不存在的流程:" + flowStatus);
    }

  }
}

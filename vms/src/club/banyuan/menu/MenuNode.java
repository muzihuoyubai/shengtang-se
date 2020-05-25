package club.banyuan.menu;

import club.banyuan.machine.FlowStatus;
import java.util.ArrayList;
import java.util.List;

public class MenuNode {

  private String title;
  private String inputMatches;
  private String desc;
  private FlowStatus flowStatus;
  private FlowStatus parentStatus;
  private MenuType menuType;
  private MenuNode parentNode;
  private List<MenuNode> subMenus;

  public MenuNode(String desc, String inputMatches, String title,
      FlowStatus flowStatus, FlowStatus parentStatus, MenuType menuType) {
    this.title = title;
    this.inputMatches = inputMatches;
    this.desc = desc;
    this.flowStatus = flowStatus;
    this.parentStatus = parentStatus;
    this.menuType = menuType;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getInputMatches() {
    return inputMatches;
  }

  public void setInputMatches(String inputMatches) {
    this.inputMatches = inputMatches;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public List<MenuNode> getSubMenus() {
    return subMenus;
  }

  public void setSubMenus(List<MenuNode> subMenus) {
    this.subMenus = subMenus;
  }

  public FlowStatus getFlowStatus() {
    return flowStatus;
  }

  public void setFlowStatus(FlowStatus flowStatus) {
    this.flowStatus = flowStatus;
  }

  public FlowStatus getParentStatus() {
    return parentStatus;
  }

  public void setParentStatus(FlowStatus parentStatus) {
    this.parentStatus = parentStatus;
  }

  public MenuType getMenuType() {
    return menuType;
  }

  public void setMenuType(MenuType menuType) {
    this.menuType = menuType;
  }

  public MenuNode getParentNode() {
    return parentNode;
  }

  public void setParentNode(MenuNode parentNode) {
    this.parentNode = parentNode;
  }

  public void addSubMenu(MenuNode menuNode) {
    if (subMenus == null) {
      subMenus = new ArrayList<>();
    }

    subMenus.add(menuNode);
    menuNode.setParentNode(this);
  }
}

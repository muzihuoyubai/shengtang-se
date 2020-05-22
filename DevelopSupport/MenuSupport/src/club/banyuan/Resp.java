package club.banyuan;

import java.util.List;

public class Resp {

  private Integer Id; //id
  private String Name; //节点名称
  private Integer ParentId; //父节点
  private Integer Order; //排序码
  List<Resp> children;
  private int colspan;
  private int rowspan;

  public Resp(Integer id, String name, Integer parentId, Integer order) {
    Id = id;
    Name = name;
    ParentId = parentId;
    Order = order;
  }

  public int getColspan() {
    return colspan;
  }

  public void setColspan(int colspan) {
    this.colspan = colspan;
  }

  public int getRowspan() {
    return rowspan;
  }

  public void setRowspan(int rowspan) {
    this.rowspan = rowspan;
  }

  public List<Resp> getChildren() {
    return children;
  }

  public Resp() {
  }

  public Resp(Integer id, String name, Integer parentId, Integer order, List<Resp> children) {
    Id = id;
    Name = name;
    ParentId = parentId;
    Order = order;
    this.children = children;
  }

  public void setChildren(List<Resp> children) {
    this.children = children;
  }

  public Integer getId() {
    return Id;
  }

  public void setId(Integer id) {
    Id = id;
  }

  public String getName() {
    return Name;
  }

  public void setName(String name) {
    Name = name;
  }

  public Integer getParentId() {
    return ParentId;
  }

  public void setParentId(Integer parentId) {
    ParentId = parentId;
  }

  public Integer getOrder() {
    return Order;
  }

  public void setOrder(Integer order) {
    Order = order;
  }
}

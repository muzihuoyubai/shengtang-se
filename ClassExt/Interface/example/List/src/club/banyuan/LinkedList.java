package club.banyuan;

public class LinkedList implements List {

  private Node head = new Node();
  private Node tail = head;
  private int size;

  @Override
  public Object set(int index, Object element) {
    return null;
  }

  @Override
  public Object get(int index) {
    if (index >= size) {
      System.out.println("下标不合法");
      return null;
    }
    int count = index;
    Node cur = head;
    while (count != -1) {
      cur = cur.getNext();
      count--;
    }
    return cur.getData();
  }

  @Override
  public void clear() {

  }

  @Override
  public Object remove(int index) {
    return null;
  }

  @Override
  public boolean remove(Object o) {
    return false;
  }

  @Override
  public boolean add(Object o) {
    Node node = new Node();
    node.setData(o);
    node.setPrev(tail);
    tail.setNext(node);
    tail = node;
    size++;
    return true;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public int size() {
    return size;
  }
}

package club.banyuan.queue;


public class ArrayQueueRefine implements Queue {

  private static final int INIT_CAPACITY = 10;

  private Object[] array = new Object[INIT_CAPACITY];

  // 出队列的元素下标
  private int first;
  // 入队列的元素下标
  private int next;

  public void add(Object o) {
    if (((next + 1) % array.length) == first) {
      Object[] newArray = new Object[array.length * 2];
      if (next > first) {
        System.arraycopy(array, 0, newArray, 0, array.length);
      } else {
        System.arraycopy(array, first, newArray, 0, array.length - first);
        System.arraycopy(array, 0, newArray, array.length - first, next);
        first = 0;
        next = array.length - 1;
      }
      array = newArray;
    }

    array[next] = o;
    next = (next + 1) % array.length;
  }

  public Object delete() {
    if (isEmpty()) {
      return null;
    }

    Object rlt = array[first];
    array[first] = null;
    first = (first + 1) % array.length;
    return rlt;
  }

  public boolean isEmpty() {
    return first == next;
  }

}
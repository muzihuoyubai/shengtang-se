package club.banyuan.queue;


public class ArrayQueue implements Queue {

  private static final int INIT_CAPACITY = 10;

  private Object[] array = new Object[INIT_CAPACITY];

  private int size;

  public void add(Object o) {
    if (size == array.length) {
      // 扩容
      Object[] newArray = new Object[array.length * 2];
      //for(int i=0;i< array.length;i++){
      //	newArray[i] = array[i];
      //}
      System.arraycopy(array, 0, newArray, 0, array.length);
      array = newArray;
    }

    array[size] = o;
    size++;

  }

  public Object delete() {
    if (isEmpty()) {
      return null;
    }

    Object rlt = array[0];
    for (int i = 0; i < size - 1; i++) {
      array[i] = array[i + 1];
    }

    array[size - 1] = null;
    size--;
    return rlt;
  }

  public boolean isEmpty() {
    return size == 0;
  }

}
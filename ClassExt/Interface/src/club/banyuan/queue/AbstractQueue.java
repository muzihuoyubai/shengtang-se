package club.banyuan.queue;

public abstract class AbstractQueue implements Queue {

  protected static final int INIT_CAPACITY = 10;
  protected Object[] array = new Object[INIT_CAPACITY];

  public abstract void add(Object o);

  public abstract Object delete();

  public abstract boolean isEmpty();

  public void clear() {
    array = new Object[array.length];
  }
}

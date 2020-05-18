package club.banyuan;

public class Pair {

  private Object first;
  private Object second;

  public Pair(Object firstElement, Object secondElement) {
    first = firstElement;
    second = secondElement;
  }

  public Object getFirst() {
    return first;
  }

  public Object getSecond() {
    return second;
  }
}
package club.banyuan;

public class DataSet<T> {

  private double sum;
  private int count;
  private T maximum;
  private final Measurer<T> measurer;

  public DataSet(Measurer<T> aMeasurer) {
    sum = 0;
    count = 0;
    maximum = null;
    measurer = aMeasurer;
  }

  public void add(T x) {
    sum = sum + measurer.measure(x);
    if (count == 0 || measurer.measure(maximum) < measurer.measure(x)) {
      maximum = x;
    }
    count++;
  }

  public double getAverage() {
    if (count == 0) {
      return 0;
    }
    return sum / count;
  }

  public T getMaximum() {
    return maximum;
  }


}
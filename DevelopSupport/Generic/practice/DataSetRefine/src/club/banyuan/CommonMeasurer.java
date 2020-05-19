package club.banyuan;

public class CommonMeasurer<T extends Measurable> implements Measurer<T> {

  @Override
  public double measure(Measurable anObject) {
    return anObject.getMeasure();
  }
}

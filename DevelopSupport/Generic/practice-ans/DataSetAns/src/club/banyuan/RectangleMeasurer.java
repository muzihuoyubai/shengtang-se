package club.banyuan;

public class RectangleMeasurer implements Measurer<Rectangle> {

  @Override
  public double measure(Rectangle anObject) {
    return anObject.width * anObject.height;
  }
}

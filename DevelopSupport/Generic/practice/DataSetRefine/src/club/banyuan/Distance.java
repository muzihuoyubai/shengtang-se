package club.banyuan;

public class Distance implements Measurable {

  private int kilometer;

  public Distance(int kilometer) {
    this.kilometer = kilometer;
  }

  public void setKilometer(int kilometer) {
    this.kilometer = kilometer;
  }

  public int getKilometer() {
    return kilometer;
  }

  @Override
  public double getMeasure() {
    return getKilometer();
  }




}

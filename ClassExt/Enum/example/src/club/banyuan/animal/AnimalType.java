package club.banyuan.animal;

public class AnimalType {

  public static final AnimalType TIGER = new AnimalType("老虎");
  public static final AnimalType LION = new AnimalType("狮子");
  public static final AnimalType ELEPHANT = new AnimalType("大象");

  private final String typeName;
  // TODO 对code进行初始化，1 表示老虎，2表示狮子，3表示大象
  private final int code;

  private AnimalType(String typeName) {
    this.typeName = typeName;
  }

  public String getTypeName() {
    return typeName;
  }

  public int getCode() {
    return code;
  }

  // TODO
  public static AnimalType valueOf(int code){
    return null;
  }

  // TODO
  public static AnimalType valueOf(String typeName) {
    return null;
  }

  @Override
  public String toString() {
    return this.typeName;
  }
}

package club.banyuan.clsenum;

public class AnimalType {

  public static final AnimalType TIGER = new AnimalType("老虎", 1);
  public static final AnimalType LION = new AnimalType("狮子", 2);
  public static final AnimalType ELEPHANT = new AnimalType("大象", 3);

  private final String typeName;
  // TODO 对code进行初始化，1 表示老虎，2表示狮子，3表示大象
  private final int code;

  private AnimalType(String typeName, int code) {
    this.typeName = typeName;
    this.code = code;
  }

  public String getTypeName() {
    return typeName;
  }

  public int getCode() {
    return code;
  }

  // TODO
  public static AnimalType valueOf(int code) {
    if (TIGER.code == code) {
      return TIGER;
    } else if (ELEPHANT.code == code) {
      return ELEPHANT;
    } else if (LION.code == code) {
      return LION;
    }
    return null;
  }

  // TODO
  public static AnimalType valueOf(String typeName) {
    if (TIGER.typeName.equals(typeName)) {
      return TIGER;
    } else if (ELEPHANT.typeName.equals(typeName)) {
      return ELEPHANT;
    } else if (LION.typeName.equals(typeName)) {
      return LION;
    }

    return null;
  }

  @Override
  public String toString() {
    return this.typeName;
  }
}

package club.banyuan.polydemo;

public class Father extends GrandFather {

  private String fatherField = "fatherFiled";
  private String fatherFieldOverride = "fatherFieldOverride";

  public String getFatherField() {
    return fatherField;
  }

  public void setFatherField(String fatherField) {
    this.fatherField = fatherField;
  }

  public String getFatherFieldOverride() {
    return fatherFieldOverride;
  }

  public static String getFatherStaticField() {
    return "FatherStaticField";
  }

  public final String getSonPrivateAccess(){
    return getSonPrivate();
  }

  private String getSonPrivate() {
    return "FatherPrivate";
  }

  // @Override
  // public String toString() {
  //   return "Father{}";
  // }
}

package club.banyuan.polydemo;

public class Son extends Father {

  private String getSonPrivate() {
    return "SonPrivate";
  }

  // public String getSonPrivateAccess() {
  //   return getSonPrivate();
  // }

  @Override
  public String getFatherFieldOverride() {
    return "OverrideBySon";
  }

  public static String getFatherStaticField() {
    return "FatherStaticFieldFromSon";
  }

  public static void main(String[] args) {
    Son son = new Son();
    Father father = new Father();

    System.out.println(son instanceof Father);
    System.out.println(father instanceof Father);
    System.out.println(father instanceof GrandFather);
    System.out.println(son instanceof GrandFather);



    // ((Son) father).getSonPrivate();

    // System.out.println(father.getFatherField());
    // System.out.println(father.getFatherFieldOverride());
    // System.out.println(son.getFatherFieldOverride());
    // System.out.println(son.getSonPrivate());
    // System.out.println(father.getSonPrivateAccess());
    // System.out.println(son.getSonPrivateAccess());
    // System.out.println(father.getFatherStaticField());
    // System.out.println(son.getFatherStaticField());

    // Father realFatherObj = new Father();
    // System.out.println(realFatherObj.getSonPrivateAccess());
    // System.out.println(realFatherObj.getFatherFieldOverride());

    // System.out.println(father);
  }
}

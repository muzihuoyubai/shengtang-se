package club.banyuan.inherit;

public class Son extends Father {

  public void accessfatherField() {
    System.out.println(fatherField); // fatherField
    System.out.println(super.fatherField); // fatherField

    // 子类找到父类的存储区，父类又到父类的存储区找到这个成员
    // grandfatherField 和  super.grandfatherField 都指向Father的父类存储区
    System.out.println(grandfatherField); // grandfatherField
    System.out.println(super.grandfatherField);  // grandfatherField

    // Father覆盖了父类的成员，这样子类就无法再访问到Father父类的存储区了（除非在Father中的方法中指定使用super访问，然后再把值返回）
    // grandfatherFieldOverride 和 super.grandfatherFieldOverride 都指向Father的存储区
    System.out.println(grandfatherFieldOverride); // grandfatherFieldOverrideInFather
    System.out.println(super.grandfatherFieldOverride); // grandfatherFieldOverrideInFather
  }
}

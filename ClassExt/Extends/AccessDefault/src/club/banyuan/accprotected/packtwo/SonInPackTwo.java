package club.banyuan.accprotected.packtwo;

import club.banyuan.accprotected.packone.FatherInPackOne;

public class SonInPackTwo extends FatherInPackOne {

  // 子类内部不能调用父类的默认权限的方法，因为和父类不同包
  public String sonMethod() {
    System.out.println("sonMethod");
    // return fatherMethod(); // 编译报错
    return "sonMethod";
  }
}

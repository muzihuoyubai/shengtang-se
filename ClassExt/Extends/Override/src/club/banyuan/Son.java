package club.banyuan;

public class Son extends Father {

  // Override注解，表示当前方法是重写父类的方法
  // 用于编译器检查，编译器将检查是否父类具备这个被重写的方法，
  // 并且检查子类重写的方法声明是否满足重写原则
  // @Override // 编译报错 不能重写父类的私有方法
  public void methodA() {

  }

  // 返回数据类型void，必须和父类被重写方法一致
  @Override
  public void methodB() {

  }

  // 返回基本数据类型，必须和父类被重写方法一致
  @Override
  public int methodC() {
    return 2;
  }

  // 子类重写的方法，返回的类必须是父类方法返回的类相同类型，或是其子类
  @Override
  public Son methodD() {
    return this;
  }

  // 参数列表必须是一模一样才行，不能和返回值一样是子类或父类
  @Override
  public void methodE(Father father) {

  }

  // 访问权限必须大于等于父类被重写方法的访问权限
  // protected > 默认访问权限
  @Override
  protected void methodF() {

  }
}

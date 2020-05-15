package club.banyuan.q9;

class Person {

  String name;
}


public class Test2 {

  public Person myMethod() {
    Person person = new Person();

    try {
      person.name = "zhangsan";
      return person;
    } finally {
      // person = new Person(); 如果使用一个新对象之后进行赋值。最终返回的结果就是zhangsan，对新对象的赋值不会对try中的对象内容产生影响
      person.name = "lisi"; // finally中对引用数据类型中的成员修改，将会影响try最终返回的对象的内容
    }
  }

  public static void main(String[] args) {
    Test2 test = new Test2();
    Person rlt = test.myMethod();
    System.out.println("rlt=" + rlt.name); // 返回lisi
  }
}

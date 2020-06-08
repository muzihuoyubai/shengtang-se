import java.lang.annotation.Annotation;

@MyAno(value = "[a-z]+",name = "test")
public class AnnotationDemo {

  private String name;

  public AnnotationDemo(String name) {
    Annotation[] annotations = AnnotationDemo.class.getAnnotations();
    for (Annotation annotation : annotations) {
      if (annotation instanceof MyAno) {
        MyAno myAno = (MyAno) annotation;
        System.out.println(myAno.value());
        if (!name.matches(myAno.value())) {
          throw new RuntimeException("name不合法");
        }
      }
    }
    this.name = name;
  }

  public static void main(String[] args) {

    AnnotationDemo annotationDemo = new AnnotationDemo("abcd");
    // Annotation[] annotations = AnnotationDemo.class.getAnnotations();
    // for (Annotation annotation : annotations) {
    //   if (annotation instanceof MyAno) {
    //     MyAno myAno = (MyAno) annotation;
    //     System.out.println(myAno.age());
    //     System.out.println(myAno.value());
    //   }
    // }
  }
}

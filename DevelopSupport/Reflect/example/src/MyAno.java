import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAno {

  String value() default "123";

  String name() default "name";

  int age() default 1;

  String[] newNames() default {"123", "234"};

}

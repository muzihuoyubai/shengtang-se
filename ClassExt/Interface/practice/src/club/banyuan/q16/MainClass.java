package club.banyuan.q16;

// int long short byte  double float char boolean
import  java.lang.Integer;
import  java.lang.Double;
import  java.lang.Short;
import  java.lang.Byte;
import  java.lang.Long;
import  java.lang.Float;
import  java.lang.Character;
import  java.lang.Boolean;
abstract class A
{
    abstract void myMethod(Number N);
}

interface B
{
    abstract void myMethod(Object O);
}
 // Interger extends Number extends Object
class C extends A implements B
{
    void myMethod(Number N) 
    {
        System.out.println("Number");
    }
     
    public void myMethod(Object O)
    {
        System.out.println("Object");
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        A a = new C();

        a.myMethod(121);

        B b = new C();

        b.myMethod(121);

        C c = new C();

        c.myMethod(121);

    }
}
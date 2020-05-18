package club.banyuan.q23;

class X
{   
    static
    {
        class Y
        {   
            { // 代码不会被执行，不会执行局部内部类的构造方法，除非创建这个类的对象，但是这个类无法在代码块外部访问，所以构造代码块永远也无法执行。
                System.out.println(1);
            }
        }
    }
     
    {
        class Y
        {
            { // 代码不会被执行，不会执行局部内部类的构造方法，除非创建这个类的对象，但是这个类无法在代码块外部访问，所以构造代码块永远也无法执行。
                System.out.println(2);
            }
        }
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        new X();
    }
}
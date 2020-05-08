package club.banyuan.q6;

class A implements B
{
    // i =  +(2x2)  return 表达式的结果，表达式结果为赋值结果
    public int methodB(int i)
    {
        return i =+ i * i;
    }
}
 
interface B
{
    int methodB(int i);
}
 
public class MainClass 
{
    public static void main(String[] args)
    {
        B b = new A();
         
        System.out.println(b.methodB(2));
    }
}
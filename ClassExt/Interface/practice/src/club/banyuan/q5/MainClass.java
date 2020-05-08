package club.banyuan.q5;

interface P
{
    String p = "PPPP";
     
    String methodP();
}
 
interface Q extends P
{
    String q = "QQQQ";
     
    String methodQ();
}
 
class R implements P, Q
{
    public String methodP()
    {
        return q+p;
    }
     
    public String methodQ()
    {
        return p+q;
    }
}
 
public class MainClass 
{
    public static void main(String[] args)
    {
        Q r = new R();
        // 使用变量名可以访问接口中的成员，但是不能访问接口中的静态方法
        // 接口中的静态方法只能通过接口名进行访问
        System.out.println(r.q);

        System.out.println(r.methodP());
         
        System.out.println(r.methodQ());
    }
}
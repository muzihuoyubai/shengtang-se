### 目的
熟悉static的使用

### 练习
补全`class Person`代码，分别统计创建Person对象的总数和调用了两个参数的构造方法的总数
补全`class Main`中的`main`方法，结尾处输出以下内容
<pre>
一共创建了5个对象
两个参数的构造方法被调用了2次
</pre>


#### 1.以下代码的输出结果是

```
public class StaticDemo {
            int num1 = 6;
            static int num2 = 10;
 
      public static void main(String args[]) {
            StaticDemo s1 = new StaticDemo();
            StaticDemo s2 = new StaticDemo();
            s1.num1 = 15;
            s1.num2 = 17;
            s2.num1 = 22;
            s2.num2 = 28;
            System.out.println(s1.num1 + " " + s1.num2 + " " + s2.num1 + " "+ s2.num2);
 
   }
}
```
A. 15 17 22 28
B. 15 17 22 17
C. 15 28 22 28
D. 22 17 22 28
E. 22 28 22 28
F. 编译错误

#### 2.以下选项插入到代码片段中可以编译通过的是
```
public class Demo {
 
final String exam1 = "O";
static String exam2 = "C";
 
{
// CODE SNIPPET 1
  
}
static {
// CODE SNIPPET 2
  
}
 
}
```

A. exam1 = “A”; instead of // CODE SNIPPET 1
B. exam 2 = “J”; instead of // CODE SNIPPET 1
C. exam 1 = “P”; instead of // CODE SNIPPET 2
D. exam 2 = “8”; instead of // CODE SNIPPET 2
E. 编译错误
F. 运行错误

#### 3.以下代码的输出结果是

```
public class StaticDemo {
 
static String n1= examName("O");{
     n1=examName("A");
  }
static{
      n1=examName("C");
}
 public static void main(String[] args) {
           StaticDemo sd = new StaticDemo();
 
  }
 
public static String examName(String s){
          System.out.println(s);
        return s;
   }
}
```

A. O C A
B. C A O
C. O A C
D. C A O
E. 编译错误
F. 运行错误

#### 4. 以下代码哪一行会编译错误
```
public class StaticDemo {
 
StaticDemo sd = new StaticDemo();
void method1() {
   method4();  // 1
   StaticDemo.method2(); // 2
   StaticDemo.method3(); // 3
 
}
 
  static void method2() {
 }
 
  void method3() {
   method1(); //4
   method2(); //5
   sd.method2(); //6
}
 
   static void method4() {
   }
}
```

A. 1
B. 2
C. 3
D. 4
E. 5
F. 6

#### 5. 以下代码的输出结果是
```
public class StaticDemo {
 
int num1 = 3;
static int num2 = 5;
 
StaticDemo(int num1, int num2) {
 
   if (num2 < 30) {
    this.num2 = num2;
   }
     num1 = num1;
}
 
  public static void main(String args[]) {
 
         StaticDemo s1 = new StaticDemo(9, 10);
         StaticDemo s2 = new StaticDemo(12, 22);
 
         System.out.println(s1.num1 + " " + s1.num2 + " " + s2.num1 + " "+ s2.num2);
 
  }
}
```
A. 9 10 12 22
B. 9 22 12 22
C. 9 10 12 10
D. 3 22 3 22
E. 编译错误
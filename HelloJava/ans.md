## 练习答案和解析

1. 编译运行`Hello.java`，请记录打开终端开始到程序运行期间所有输入的终端命令

   ```shell
   # mac 下
   cd ~/projects/javase/HelloJava
   javac Hello.java
   java hello
   ```

   ```shell
   # windows 下
   d:
   cd d:\projects\javase\HelloJava
   javac Hello.java
   java hello
   ```

2. 将`HelloJava`目录下的`Hello.class`文件删除，编辑`Hello.java`将`class`后面的名称修改为`test`，然后编译`Hello.java`文件

   1. 生成的class文件名是什么

      生成test.class文件，说明编译后的文件名和文件内部class声明的名称一致

   2. 请尝试使用`java`运行编译后的文件，应该输入什么命令

      `java test`，说明java运行时传入的是class的名字

3. 保持上一题的状态，编辑Hello.java将class后面的名称修改为Test，然后编译Hello.java

   1. 是否生成新的class文件

      不生成新的class文件，编译后的内容将覆盖到`test.class`中，`javac`对于编译出来的class文件的查找是不区分大小写的，如果有这个文件，就把编译后的内容进行覆盖，如果没有这个文件则创建和class同名的文件。

   2. 请尝试使用`java`运行编译后的文件，应该输入什么命令

      `java Test`，说明运行时java传入的是class的名字大小写必须和声明的一致，不需要和class文件名一致，如果使用`java test`将报错找不到这个类`java.lang.NoClassDefFoundError`，java查找class文件的时候不区分大小写

   3. 将test.class 重命名为test1.class尝试运行，是否可以运行成功，如果不成功记录错误

      无法运行

      <pre>
      错误: 找不到或无法加载主类 test
      原因: java.lang.ClassNotFoundException: test
      </pre>

   4. 将test.class 重命名为TEST.class尝试运行，是否可以运行成功，如果不成功记录错误

      `java Test`可以运行成功，说明根据`java`后面的类名查找对应的class文件，查找的时候不区分大小写

4. 仿照`Hello.java`写一个`HelloWorld.java`, 其中class声明为`HelloWorld`，向屏幕输出`Hello World!`

   ```java
   class HelloWorld {
       public static void main(String[] args) {
           System.out.println("Hello World!");
       }
   }
   ```



## 总结

`javac` 根据指定的文件名来编译文件，生成的class文件命名和文件内部定义的名称一致，生成class文件之前先到路径位置查找是否有相同名字的class文件，查找的时候不区分大小写，如果有这个文件，就把编译后的内容进行覆盖，如果没有这个文件则创建和class同名的文件。

`java`程序根据后面传入的类名来搜索对应名字的class文件，搜索的时候不区分文件的大小写。如果找不到文件，则会出现`java.lang.ClassNotFoundException`错误。如果找到了文件，但是文件内部定义的class名称大小写和传入的不匹配，则会出现`java.lang.NoClassDefFoundError`。注意一个是类没有找到，一个是类没有定义。
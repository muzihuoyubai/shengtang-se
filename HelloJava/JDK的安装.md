# JDK安装包下载

安装JDK通常有两个选择，一个是Oracle JDK
[www.oracle.com/technetwork/java/javase/downloads/](http://www.oracle.com/technetwork/java/javase/downloads/)

另外一个是 OpenJDK
http://jdk.java.net/

OracleJDK官网下载速度较慢，这里提供一个国内下载OrcalJDK的镜像链接
https://repo.huaweicloud.com/java/jdk

## 下载说明

进入java jdk的下载路径

![image](http://by-camp.oss-cn-shanghai.aliyuncs.com/wiki/javase-online/images/jdk_setup_01.png)

![image](http://by-camp.oss-cn-shanghai.aliyuncs.com/wiki/javase-online/images/jdk_setup_02.png)

![image](http://by-camp.oss-cn-shanghai.aliyuncs.com/wiki/javase-online/images/jdk_setup_03.png)

选择合适的安装包进行下载，以下安装演示分别对应的安装包 

| 操作系统 | 安装包                          |
| -------- | ------------------------------- |
| Linux    | jdk-13.0.1_linux-x64_bin.tar.gz |
| Mac      | jdk-13.0.1_osx-x64_bin.dmg      |
| Windows  | jdk-13.0.1_windows-x64_bin.exe  |

## JDK版本的选择

我们的课程内容覆盖到java 8的特性，因此选择安装JDK的时候，版本不要低于8。我们演示时使用的是Oracle JDK 13。对于学习，可以使用最新版本的jdk。对于实际企业应用，大部分会选择LTS版本的jdk。

### LTS

LTS(long term support)是JDK的长期维护版，目前JDK8和JDK11提供长期的升级支持。长期维护版本的更新主要是提高稳定性、安全性。JDK的版本升级（比如JDK8升级到JDK9）会存在很大的风险，JDK版本升级都会引入很多新的特性，并且可能会把之前使用的某些方法废弃或修改，这样就可能会对已经运行的程序产生未知的影响。

### OracleJDK和OpenJDK

Oracle的长期维护版本以及JDK10之后的版本，用于商业用途需要付费。学习和开发可以免费使用。

OpenJDK完全免费，实际上还有很多公司包括阿里基于OpenJDK之上提供了各自的JDK支持。

# 配置环境变量

我们在操作系统安装任意的软件之后，为了可以在任意路径下安装的程序，需要将启动文件路径告知操作系统，这样操作系统在接收这个文件名的时候，就知道要启动这个程序了。告知的方式就是将启动文件所在的目录路径配置到环境变量中。操作系统接收到程序执行指令的时候（通常就是输入和程序文件名一样的指令），回去到环境变量里面配置的路径下面搜索是否有这个程序文件，如果就执行，如果没有就报错指令不存在。

## Mac/Linux下环境变量显示和配置

Mac和Linux下系统设置了名为`PATH`(注意必须是全大写)的变量保存所有的路径，多个路径之间使用`:`进行分割。

使用`echo $PATH`命令显示环境变量的内容。

使用`export PATH="$PATH:新路径"`向环境变量里追加新路径。

每次命令窗口启动的时候读取环境变量信息(先到/etc/profile 中读取全局配置，然后到~/.bash_profile 读取当前用户配置)，然后缓存到当前窗口中。使用`export`命令设置，仅对当前窗口有效。将配置命令写入到 `~/.bash_profile`中配置当前用户的环境变量，或者将配置命令写入到`/etc/profile`(需要root权限)中，配置所有用户的环境变量

### 异常处理

如果不小心导入错了环境变量，可能会导致所有的命令都识别不了了，原因可能是改错了PATH导致所有的命令找不到了，运行以下命令让基本命令生效，可以在终端输入以下内容恢复基本的环境变量。然后再修复配置错误。

```
export PATH=/usr/local/sbin:/usr/local/bin:/sbin:/bin:/usr/sbin:/usr/bin
```

## Windows下环境变量显示和配置

windows下系统设置了名为`path`的环境变量（注意windows下是不区分大小写的），多个路径之间使用`;`进行分割。

使用`echo %path%`命令显示环境变量的内容

使用`set path=%path%;新路径`向环境变量里追加新路径。

为了让环境变量对所有用户生效，需要将新增的路径配置到系统设置中。

# 判断JDK是否已经安装

开启命令窗口，输入`java -version`进行判断是否已经安装了JDK，输出类似以下内容表示安装成功

```
java version "13-ea" 2019-09-17
Java(TM) SE Runtime Environment (build 13-ea+33)
Java HotSpot(TM) 64-Bit Server VM (build 13-ea+33, mixed mode, sharing)
```

如果已安装jdk但是不知道安装到哪个路径了，可以使用以下命令帮助判断`java -verbose`，输出的内容可能会比较多，翻到最顶端

```
[0.015s][info][class,load] opened: /Library/Java/JavaVirtualMachines/jdk-13.0.1.jdk/Contents/Home/lib/modules
...
...
java.lang.constant.Constable source: shared objects file
```

opened: **/Library/Java/JavaVirtualMachines/jdk-13.0.1.jdk/Contents/Home/lib/modules** 这里显示了jdk安装的具体路径

# 安装JDK

## mac下JDK的安装

运行dmg文件，根据提示继续即可

![image](http://by-camp.oss-cn-shanghai.aliyuncs.com/wiki/javase-online/images/jdk_setup_04.png)

![image](http://by-camp.oss-cn-shanghai.aliyuncs.com/wiki/javase-online/images/jdk_setup_05.png)

### 视频演示

Mac安装JDK

## windows下JDK的安装

根据安装提示进行安装，建议

![image](http://by-camp.oss-cn-shanghai.aliyuncs.com/wiki/javase-online/images/jdk_setup_06.png)

安装完成后配置环境变量，环境变量配置主要是为了可以在任意路径下运行javac

计算机右键选择属性

![image](http://by-camp.oss-cn-shanghai.aliyuncs.com/wiki/javase-online/images/jdk_setup_07.png)

选择高级系统设置

![image](http://by-camp.oss-cn-shanghai.aliyuncs.com/wiki/javase-online/images/jdk_setup_08.png)

选择环境变量

![image](http://by-camp.oss-cn-shanghai.aliyuncs.com/wiki/javase-online/images/jdk_setup_09.png)

新建系统变量

![image](http://by-camp.oss-cn-shanghai.aliyuncs.com/wiki/javase-online/images/jdk_setup_10.png)

添加变量名JAVA_HOME，变量值为jdk安装的路径，例如D:\Java\jdk1.8.0_144

找到系统变量中的path，点击编辑

![image](http://by-camp.oss-cn-shanghai.aliyuncs.com/wiki/javase-online/images/jdk_setup_11.png)

在已有的路径下，最前面增加`%JAVA_HOME%\bin;` 注意后面的分号是要加的，另外注意不要全选将其他的path覆盖掉了

![image](http://by-camp.oss-cn-shanghai.aliyuncs.com/wiki/javase-online/images/jdk_setup_12.png)

## Linux 安装

将jdk-13.0.1_linux-x64_bin.tar.gz压缩包复制到指定路径，例如/opt/java 路径下

```shell
# 注：所有的$ 后面跟的是linux命令，没有以$开头的行是运行命令后的显示内容
# jdk-13.0.1_linux-x64_bin.tar.gz 现在放到了/opt/java 路径下，进入到/opt/java路径, 可以通过ls查看路径下面内容，需要看到这个压缩包

# 解压缩
$ tar -xvf jdk-13.0.1_linux-x64_bin.tar.gz

# 解压缩后将会多出来一个文件夹
$ ls
jdk-13.0.1  jdk-13.0.1_linux-x64_bin.tar.gz

# 进入到解压缩后的文件夹
cd jdk-13.0.1

# 获取当前路径
$ pwd
/opt/java/jdk-13.0.1

# 以下命令的功能是将路径加入到path中，加入到path之后
# 注意这个路径后面多了一个bin目录，javac可执行程序在bin路径下，加入path之后可以在任意路径下运行javac命令
# echo 将java路径加到了~/.bash_profile 文件中，注意使用单引号，注意PATH大写
$ echo 'export PATH=/opt/java/jdk-13.0.1/bin:$PATH' >> ~/.bash_profile

# 使得结果生效
$ source ~/.bash_profile 

# 查看javac是否成功安装
$ javac -version
javac 13.0.1
```

修改后的bash_profile内容如下，最后一句话是追加上的

```
# .bash_profile

# Get the aliases and functions
if [ -f ~/.bashrc ]; then
	. ~/.bashrc
fi

# User specific environment and startup programs

PATH=$PATH:$HOME/bin
export PATH
export PATH=/opt/java/jdk-13.0.1/bin:$PATH
```
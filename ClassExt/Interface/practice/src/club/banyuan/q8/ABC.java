package club.banyuan.q8;

interface ABC
{
	// 编译通过，允许在方法前使用public或abstract修饰，
	// 并且最终都是public abstract，会自动补全剩余的修饰关键字
	abstract void methodOne();
	
	public void methodTwo();
}

interface PQR extends ABC
{
	// 允许接口继承另一个接口，并且声明相同方法签名的方法。
	// 如果这么写，要保证定义的方法满足重写条件，不能返回值类型不一致
	public void methodOne();
	
	public void methodTwo();
}
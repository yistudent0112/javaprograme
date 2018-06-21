/*2018年1月6日10:36:51
 * 总结：
 * 1. A类继承一个接口Runnable，该接口里面只有一个函数run，因此，不能直接调用start() 这个函数
 * 		只能在创建一个Thread。
 * 2. Thread 中有一个构建函数的参数是(Runnable a) 
 * */

package 线程_2_构建线程的方法一;

class A implements Runnable
{
	public void run()
	{
		while(true)
		{
			System.out.println("AAAAAA");
		}
	}
}

public class TestThread1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A aa = new A();
		Thread tt = new Thread(aa);//应该有一个构造函数 public thread(Runnable r),不能new一个接口对象，但是可以定义一个接口的引用
		
		tt.start();
		
		while(true)
		{
			System.out.println("BBBBBB");
		}
		
		
	}

}

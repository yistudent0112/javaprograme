/*2018年1月6日14:52:07
 * 总结：
 * 1. 不能不用try catch() 直接在函数run后面写 throw Exception 因为父类的run函数没有抛异常，由子类抛出的异常不能大于父类，可以得到，不能写 throw Exception
 * 
 * */
package 线程_5_线程的休眠;

class A implements Runnable //不能不用try catch() 直接在函数run后面写 throw Exception 因为父类的run函数没有抛异常，由子类抛出的异常不能大于父类，可以得到，不能写 throw Exception
{
	public void run()
	{
		
		for(int i=0;i<33;i++)
		{
			System.out.println(Thread.currentThread().getName() );
			System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
			
			try
			{
				Thread.sleep(1000);
			}
			catch(Exception e)
			{
				System.out.println("FFFFFFFFFFf");
			}
		}
	}
}

public class TestThread {
	public static void main(String[] args)
	{
		int m = 0;
		Thread t = new Thread(new A());
		t.start();
		
		
		
	}

}

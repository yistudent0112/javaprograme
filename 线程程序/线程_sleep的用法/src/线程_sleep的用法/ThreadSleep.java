package 线程_sleep的用法;

class A implements Runnable
{
	public void run()//throws Exception 这是不行的，因为父类的run函数没有抛出异常
	{
		while(true) 
		{
			System.out.println("AAAAAAA");
			try
			{
				Thread.sleep(1000);//sleep会抛出一个非RunnException，必须进行捕获处理
			}
			catch(Exception e)
			{
				
			}
		}
	}
}


public class ThreadSleep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		A aa = new A();
		Thread tt = new Thread(aa);
		tt.start();
	}

}

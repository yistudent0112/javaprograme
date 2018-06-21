package 线程_Sleep;

class A implements Runnable
{
	public void run()
	{
		
		
		while(true)
		{
			System.out.printf("%s线程在执行\n", Thread.currentThread().getName());
			try
			{
				Thread.sleep(1000);
			}
			catch(Exception e)
			{
				//System.out.println("FFFFFFFFFFf");
			}
		}
	}
}

public class TestSleep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A aa = new A();
		Thread tt1 = new Thread(aa);
		tt1.start();
		Thread tt2 = new Thread(aa);
		tt2.start();
		
	}

}

package 线程_join的用法;

class A extends Thread
{
	public void run()
	{
		int i = 0;
		while(i < 50)
		{
			System.out.println("AAAAAA" + i);
		}
	}
}

public class TestJoin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A aa = new A();
		aa.start();
		try
		{
			aa.join();
		}
		catch(Exception e)
		{
			
		}
		//while(true)
		//{
		//	System.out.println("BBBBBB");
		//}
	}

}

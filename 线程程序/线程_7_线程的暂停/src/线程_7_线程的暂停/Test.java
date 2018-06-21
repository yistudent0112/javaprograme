package 线程_7_线程的暂停;

class A implements Runnable
{
	public void run()
	{
		for(int i=0; i<50; i++)
		{
			System.out.println("A_" + i);
		}
	}
}


public class Test {
	public static void main (String[] args)
	{
		Thread t = new Thread(new A() );
		t.start();
		try 
		{
			t.join();//注意join奇特的用法
		}
		catch(Exception e)
		{
			
		}
		
		for(int i=0; i<50; i++)
		{
			System.out.println("B_" + i);
		}
	}

}

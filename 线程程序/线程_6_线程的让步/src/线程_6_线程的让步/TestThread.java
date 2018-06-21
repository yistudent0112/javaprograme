package 线程_6_线程的让步;

class A implements Runnable
{
	public void run()
	{
		for (int i=0; i<100; i++)
		{
			System.out.println(Thread.currentThread().getName() + ": " + i);
			if( 0 == i%10)
			{
				Thread.yield();
			}
		}
			
	}
}

public class TestThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new A());
		Thread t2 = new Thread(new A());
		
		t1.setName("A线程");
		t2.setName("B线程");
		
		t1.start();
		t2.start();
		
	}

}

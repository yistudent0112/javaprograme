package 线程_两种构建现成的方法;

class A extends Thread
{
	public void run()
	{
		while(true)
		{
			System.out.println("AAAAAA");
		}
	}
}

class B implements Runnable
{
	public void run()
	{
		while(true)
		{	
			System.out.println("BBBBBB");
		}
	}
}

public class ThreadCreate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A aa = new A();
		aa.start();
		B bb = new B();
		Thread tt = new Thread(bb);
		tt.start();
	}

}

package 线程_1;

class A extends Thread
{
	public void run()
	{
		while(true)
		{
			System.out.println("AAAAA");
		}
	}
}

public class TestTthread_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A aa = new A();
		aa.start();//aa.start() 会自动调用run函数
		
		while(true)
		{
			System.out.println("BBBBB");
		}
	}

}

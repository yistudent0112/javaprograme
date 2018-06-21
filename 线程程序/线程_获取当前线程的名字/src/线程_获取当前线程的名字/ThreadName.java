package 线程_获取当前线程的名字;

class A extends Thread
{
	public void run()
	{
		System.out.println(Thread.currentThread().getName());
	}
}


public class ThreadName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A aa1 = new A();
		aa1.setName("张三");
		aa1.start();
		
		A aa2 = new A();
		aa2.setName("李四");
		aa2.start();
		
		A aa3 = new A();
		aa3.start();
		
		System.out.println(Thread.currentThread().getName());
	
		

	}

}

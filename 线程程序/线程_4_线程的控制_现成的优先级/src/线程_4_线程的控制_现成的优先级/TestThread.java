 /*2018年1月6日14:25:52
 * 总结：
 * 1. 线程的优先级高，只能说明在一秒中之内，执行他的概率高一点
 * 
 * 
 * 
 * */

package 线程_4_线程的控制_现成的优先级;

class A implements Runnable
{
	public void run() 
	{
		for (int i=0; i<100; i++)
		System.out.printf("A-%d\n", i);
	}
}

class B implements Runnable
{
	public void run() 
	{
		for (int i=0; i<100; i++)
		System.out.printf("B-%d\n", i);
	}
}

public class TestThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new A() );
		Thread t2 = new Thread(new B() );
		t1.setPriority(Thread.NORM_PRIORITY+5);//Thread.NORM_PRIORITY = 5;
		
		t1.start();
		t2.start();
	}

}

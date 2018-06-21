/*2018年3月6日21:27:00
 * 
 *总结：
 *类的优先级高只能代表被执行的概率高
 * 
 * */

package 线程_线程的优先级;

class A extends Thread
{
	public void run()
	{
		for(int i=0; i<100; i++)
		{
			System.out.printf("%d--A\n", i);
		}
	}
}

class B extends Thread
{
	public void run()
	{
		for(int i=0; i<100; i++)
		{
			System.out.printf("%d-B\n", i);
		}
	}
}

public class ThreadPriority {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A aa = new A();
		B bb = new B();
		aa.setPriority(Thread.NORM_PRIORITY + 3);
		
		aa.start();
		bb.start();
		

	}

}

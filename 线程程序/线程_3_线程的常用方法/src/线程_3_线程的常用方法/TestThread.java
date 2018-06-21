/*2018年1月6日11:15:32
 * 总结：
 * 1. currentThread() ---- 返回当前被执行的线程对象的引用
 * 2. getName() ----- 返回线程对象的名字
 * 3. setName() ----- 设置当前线程的名字，是String类型
 * 4. 每一次执行的结果都是不同的 
 * */


package 线程_3_线程的常用方法;

class A extends Thread
{
	public void run()
	{
		System.out.printf("%s 正在被执行！\n", Thread.currentThread().getName() );
	}
}

public class TestThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A aa1 = new A();
		aa1.start();
		
		A aa2 = new A();
		aa2.start();	
				
		A aa3 = new A();
		aa3.start();
		
		System.out.printf("%s 正在被执行！\n", Thread.currentThread().getName() );
	}

}

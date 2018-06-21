/*2018年3月5日21:23:04
 * 总结：
 * 直接调用run函数的话，就是一个死循环，但是如果调用的是start函数的话，
 * 	就是建立一个线程，与另一个线程交替执行
 * 输出结果AB交替输出
 * start只能执行run中的代码
 * */

package 线程_start与run函数的区别;

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

public class Thread_start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A aa = new A();
		aa.start();//一个类只能调用一个start方法
		//aa.run();//直接调用run函数的话，就是一个死循环，但是如果调用的是start函数的话，就是建立一个线程，与另一个线程交替执行
		while(true)
		{
			System.out.println("BBBBBB");
		}
	}

}

/*2018年3月7日20:39:23
 * 总结：
 * join的作用是: 暂停当前调用join对象的线程，也就是本程序中的main函数
 * 而不是终止join的对象的线程
 * 
 * */

package 线程_join;


class A extends Thread
{
	public void run()
	{
		int i = 0;
		while(i < 50)
		{
			System.out.println("AAAAAA" + i);
			i++;
		}
	}
}

public class TestJoin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A aa = new A();
		aa.start();
		int x = 0;
		
		try
		{
			aa.join();
		}
		catch(Exception e)
		{
			
		}
		while(x<50)
		{
			System.out.println("BBBBBB" + x);
			x++;
		}
	}

}

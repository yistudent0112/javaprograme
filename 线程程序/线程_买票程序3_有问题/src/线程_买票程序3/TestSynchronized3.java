/*2018年3月10日19:45:12
 * 总结：
 * 为什么synchronized中的str指向的是new中的str？
 * 
 * */



package 线程_买票程序3;

class Tickets extends Thread
{
	public static int m_tickets = 100;
	public static String str = new String("aa");//本语句不能写在run方法里面，否则会生成两个str，到时候锁定的不是同一个对象
	
	public void run()//void 前面不能加synchronized，否则只有一个线程执行买票
	{
		String str = "aa";
		while(true)//也不能用synchronized将run方法括起来，否则只有一个程序在买票
		{
			synchronized (str)//为什么指向的是new中的str？
			{
				if( m_tickets>0 )
				{
					System.out.printf("%s线程正在卖出%d张票!\n", Thread.currentThread().getName(), m_tickets );
					m_tickets--;
				}
				else 
					break;
			}
		}
	}
	
}

public class TestSynchronized3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tickets aa1 = new Tickets();
		Tickets aa2 = new Tickets();
		aa1.start();
		aa2.start();
	
	}

}

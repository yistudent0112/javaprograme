/*2018年3月8日21:07:58
 * 总结：
 * 当A B C D锁定的是不同的对象，那么三行代码可能还未执行完，就被另一个线程执行。
 *修饰内部代码块的时候，必须锁定一个对象，但是在修饰方法的时候，不能加对象，会自动锁定this对象
 * 
 * 
 * */


package 线程_买票程序;

class Tickets implements Runnable
{
	public int m_tickets = 100;
	String str = new String();
	
	public void run()
	{
		while(true)
		{
			synchronized (str)
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

public class TestSynchronized {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tickets aa = new Tickets();
		Thread tt1 = new Thread(aa);
		Thread tt2 = new Thread(aa);
		tt1.start();
		tt2.start();

	}

}

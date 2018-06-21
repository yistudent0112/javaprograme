package 线程_生产消费_试1;

class SynStack
{
	private char[] date = new char[6];
	private int cnt = 0;
	
	public synchronized void push(char a)
	{
		while(cnt == date.length)
		{
			try
			{
				this.wait();
			}
			catch(Exception e)
			{}
		}
		this.notify();
		
		date[cnt] = a;
		cnt++;
		System.out.printf("正在生产第%d个产品，该产品是: %c\n", cnt, a);
	}
	
	public synchronized char pop()
	{
		while(cnt == 0)
		{
			try 
			{
				this.wait();
			}
			catch(Exception e)
			{}
		}
		this.notify();
		
		System.out.printf("正在消费第%d个产品，该消费是: %c\n", cnt, date[cnt-1]);
		
		cnt--;
		return date[cnt];
	}
	
}

class Consumer implements Runnable
{
	private SynStack ss =null;
	
	public Consumer(SynStack ss)
	{
		this.ss = ss;
	}
	
	
	public void run()
	{
		char ch;
		for(int i=0; i<20; i++)
		{
			ch = (char)('a'+i);
			ss.push(ch);
		}
	}
}

class Producer implements Runnable
{
	private SynStack ss = null;
	
	public Producer(SynStack ss)
	{
		this.ss = ss;
	}
	
	public void run()
	{
		for(int i=0; i<20; i++)
		{
			ss.pop();
		}
	}
}

public class TestPC2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SynStack ss = new SynStack();
		
		Consumer con = new Consumer(ss);
		Producer pro = new Producer(ss);
		Thread t1 = new Thread(con);
		Thread t2 = new Thread(pro);
		
		t1.start();
		t2.start();

	}

}

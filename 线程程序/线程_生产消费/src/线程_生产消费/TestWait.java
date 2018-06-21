package 线程_生产消费;

class SynStack
{
	private char[] data = new char[6];
	private int cnt = 0;//表示数组的有效元素
	
	public synchronized void push(char ch)
	{
		while (cnt == data.length)
		{
			try
			{
				this.wait();
			}
			catch (InterruptedException e) 
			{
						
			}
		}
		this.notify();
		
		data[cnt] = ch;
		++cnt;
		System.out.printf("生产线程正在生产第%d个产品，该产品是：%c\n", cnt, ch);
		
	}
	
	public synchronized char pop()
	{
		char ch;
		while (cnt == 0)
		{
			try 
			{
				this.wait();
			}
			catch (InterruptedException e)
			{
			
			}
		}
		this.notify();
		
		ch = data[cnt-1];
		System.out.printf("消费线程正在消费第%d个产品，该产品是：%c\n", cnt, ch);
		
		--cnt;
		return data[cnt];
	}
	
}

class Producer implements Runnable
{
	private SynStack ss = null;
	
	public Producer(SynStack ss)
	{
		this.ss = ss;
	}
	
	public void run()// throws Exception//不行的，因为原来的run函数里面都没有抛出异常
	{
		char ch;
		for(int i=0; i<20; i++)
		{
			ch = (char) ('a'+i);
			ss.push(ch);
		}
	}
}

class Consumer implements Runnable
{
	private SynStack ss = null;
	
	public Consumer(SynStack ss)
	{
		this.ss = ss;
	}
	public void run()
	{
		for (int i=0; i<20; i++)
		{
			ss.pop();
		}
	}
}

public class TestWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SynStack ss = new SynStack();
		Consumer con = new Consumer(ss);
		Producer pro = new Producer(ss);
		
		Thread t1 = new Thread(con);
		t1.start();
		
		Thread t2 = new Thread(pro);
		t2.start();

	}

}

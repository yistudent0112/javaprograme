/*2018年3月11日15:02:11
 * 总结：
 * 1.	sleep()是Thread类的Static(静态)的方法；因此他不能改变对象的机锁，所以当在一个Synchronized块中调用Sleep()方法是，
 * 		线程虽然休眠了，但是对象的机锁并木有被释放，其他线程无法访问这个对象（即使睡着也持有对象锁）。
 * 2.	push和pop两个函数锁定的是同一个对象ss
 * 3.	循环必须用while，不停地检测，不然就下一次的时候就不会再检测了
 * 4.	this.notify();//在还没有执行wait语句的时候就已经将push线程唤醒了，所以不存在wait之后还要执行本线程的问题
 * */



package 线程_生产消费2;

class SynStack 
{
	private char[] data = new char[6];
	private int cnt = 0; //表示数组有效元素的个数
	
	public synchronized void push(char ch)//实际锁定的是ss
	{
		while (cnt == data.length)
		{
			try
			{
				this.wait();//当返回本线程的时候是从这里开始执行的，仍然会在while循环里面继续判断cnt的长度
				//System.out.println("aaaaaaaaaaaaa");
				//Thread.sleep(1000);
			}
			catch (Exception e)
			{
			}
		}
		this.notify();//push的这条线程不是被挂起了吗，又怎么会再执行这条语句？
						//如果没有暂停的线程，本语句没有作用
						//如果本语句放在while里面，那么只能等待cnt == data.lentgh的时候才能执行pop线程
		data[cnt] = ch;
		++cnt;
		System.out.printf("生产线程正在生产第%d个产品，该产品是: %c\n", cnt, ch);
	}
	
	public synchronized char pop()//实际锁定的是ss对象
	{
		char ch;
		
		while (cnt == 0)
		{
			try
			{
				//System.out.println("bbbbbbbbbbbbbbbb");
				this.wait();
				//Thread.sleep(1000);//如果是sleep的话。确实会一直锁定，只能执行一条线程
			}
			catch (Exception e)
			{
			}
		}
		this.notify();//在还没有执行wait语句的时候就已经将push线程唤醒了，但是由于再执行pop的时候已经将ss锁定，所以无法执行push，所以不存在wait之后还要执行本线程的问题
		ch = data[cnt-1];
		
		System.out.printf("消费线程正在消费第%d个产品，该产品是: %c\n", cnt, ch);
		
		--cnt;
		return ch;		
	}	
}

class Producer implements Runnable
{
	private SynStack ss = null;
	
	public Producer(SynStack ss)
	{
		this.ss = ss;
	}
	
	public void run() // throws Exception
	{
		//push('a');  //error
		char ch;
		
		//本for语句是可以打断的，但是呢即使打断了，去执行Consumer也没有可以取出来的产品，还是会回到for语句内部
		for (int i=0; i<20; ++i)
		{
			try
			{
			Thread.sleep(100);
			}
			catch (Exception e)
			{			
			}
				
			ch = (char)('a'+i);
			ss.push(ch);//ss在调用push
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
		for (int i=0; i<20; ++i)
		{
		//	try{
		//	Thread.sleep(100);
		//	}
		//	catch (Exception e){			
		//	}
			
			//System.out.printf("%c\n", ss.pop());
			ss.pop();
		}
		
	}
}


public class TestPC
{
	public static void main(String[] args)
	{
		SynStack ss = new SynStack();
		Producer p = new Producer(ss);
		Consumer c = new Consumer(ss);
		Thread t1 = new Thread(p);
		t1.start();
				
		Thread t2 = new Thread(c);
		t2.start();
	}
}



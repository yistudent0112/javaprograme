
public class DataScaleTest {
    public static void test() {
    	//使用System.currentTimeMillis()只能够得到当前的毫秒数，
    	//对于前面的较小的数据情况下，不能够准确的得到运算所需的时间差
    	//可以通过使用System.nanoTime()来获取时间，这个返回的是纳秒时间	
    	Long scale=0L;
    	int sum=0;
    	Long startTime=0L;
    	Long endTime=0L;
    	for(int i=0;i<10;i++) {
    		scale=(long) Math.pow(10, i);
    	   startTime=System.currentTimeMillis();
    	   for(int j=0;j<scale;j++) {
    		   sum+=j;
    	   }
    	   endTime=System.currentTimeMillis();
//    	   try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	   System.out.println("在当前"+scale+"的数据规模下，进行一次运算所需的时间为"
    	   +(endTime-startTime)+"ms");
    	}
    }
    /*
     * 数据规模的概念：
     * 
     * 如果想要在1s之内解决问题：
     * 
     * O(n^2)的算法可以处理大约10^4级别的数据
     * O(n)的算法可以处理大约10^8级别的数据
     * O(n*logn)的算法可以处理大约10^7级别的数据
     * 
     */
	public static void main(String[] args) {
		test();

	}

}

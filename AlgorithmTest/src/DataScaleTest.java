
public class DataScaleTest {
    public static void test() {
    	//ʹ��System.currentTimeMillis()ֻ�ܹ��õ���ǰ�ĺ�������
    	//����ǰ��Ľ�С����������£����ܹ�׼ȷ�ĵõ����������ʱ���
    	//����ͨ��ʹ��System.nanoTime()����ȡʱ�䣬������ص�������ʱ��	
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
    	   System.out.println("�ڵ�ǰ"+scale+"�����ݹ�ģ�£�����һ�����������ʱ��Ϊ"
    	   +(endTime-startTime)+"ms");
    	}
    }
    /*
     * ���ݹ�ģ�ĸ��
     * 
     * �����Ҫ��1s֮�ڽ�����⣺
     * 
     * O(n^2)���㷨���Դ����Լ10^4���������
     * O(n)���㷨���Դ����Լ10^8���������
     * O(n*logn)���㷨���Դ����Լ10^7���������
     * 
     */
	public static void main(String[] args) {
		test();

	}

}

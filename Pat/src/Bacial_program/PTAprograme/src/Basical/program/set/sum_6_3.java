package Basical.program.set;
/*
 * ����Ҫ��ʵ��һ���������������N�������ĺ͡�
 */
public class sum_6_3 {
   public static int sum(int []a,int n) {
    	int sum=0;
    	if(n>a.length) {
    		sum=-1;
    		return sum;
    	}
    	for(int i=0;i<n;i++) {
    		sum+=a[i];
    	}
    	return sum;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int []a= {-100,200,350,-500,860};
       int n=5;
       System.out.println(sum(a,n));
       }

}

package com.yi.DynamicPrograme;
/**
 * 
 * ����ʹ�ö�̬�滮�޷����Ե��ҳ�����
 * ������ͨ��ö�ٵķ�ʽ������Ѱ�ҹ���
 * 1.S(1)=f(1)
 * 2.S(2)=Max(0+f(2),S(1))
 * 3.S(3)=Max(S(1)+f(3),S(2))
 * 4.S(4)=Max(S(2)+f(4),S(3))
 * 5.S(5)=Max(S(3)+f(5),S(4))
 * ͨ��ö�ٵķ�ʽ���Է��֣�����S(n)�Ǵ��ڶ�ǰ�����������ϵ��
 * S(n)=Max(S(n-2)+f(n),S(n-1))
 * ͨ����һ��ʽ�Ϳ���д����Ӧ������㷨��
 *
 */
public class DynamicPrograme4 {
	  public int rob(int[] nums) {
		  if(nums.length<0) {
			  return 0;
		  }
		 
	        int last=0;
	        int max=0;
	        for(int i=0;i<nums.length;i++) {
	        	//����һ��λ�ڵ�ǰ��ǰһ��Ľ��
	        	int temp=max;
	        	//����max��ֵ
	        	max=Math.max(last+nums[i], max);
	        	last=temp;
	        }
	        return max;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
DynamicPrograme4 test=new DynamicPrograme4();
int []house= {2,7,9,3,1};
test.rob(house);
	}

}

package com.yi.DynamicPrograme;
/*
 * �������ֲ����˱����ƽ�ķ�����ȥ�������п��ܵ������
 * ��ÿһ�������������أ����鿴�Ƿ����
 * ��Ϊ���˶��ݹ飬�������е�Ч�ʺܵ�
 * 
 * �����ֳ�����һ�ִӺ���ǰ�ҵķ��������������һ�����Ƿ��ܴﵽ�յ㣬���������Ϣ���ж�ǰһ�����ܷ񵽴
 * �Ӷ����϶�̬�滮����ǰ�жϡ�
 * ��������������������ǿ��Խ��������ģ�Ҳ����˵��һ���������յ㣬����������ǰ���Ǹ���Ҳ������
 * ��     2   0   8   3   0   0   0   1
 *            ��    ��
 *         ���Ե���  ���ɵ��� 
 * �����ҿ������ϵĽ��д�˵��������������˼·�͵ڶ��ֺ���ֻ�����Ǵ�ǰ�����Ƶġ�����������ߵ���Զ����
 * ����������С��0�ˣ��ʹ����޷������Ծ�ˡ�  
 * ������һ����Ҫע��ĵ㣬�������������������һ������Ϊ0���Ǵ�����Ե����յ�ġ�
 * ����Ҫ����������Ϊ0��������ͣ�����һ�������������ֿ���
 * ��    2    0    0    �ж�Ϊtrue
 *    2    1    0     1  �ж�Ϊfalse     
 */
public class DynamicPrograme1 {
	//��ÿ�ֿ��ܶ���������أ��������У�Ч�ʼ���
//	   public boolean canJump(int[] nums) {
//	        if(nums==null||nums.length<1) {
//	        	return false;
//	        }
//	        if(nums.length==1){
//	            return true;
//	        }
//	        boolean result=true;
//	        int length=nums.length-1;
//	        boolean[] flags=new boolean [length+1];
//	        result=jump(nums,length,0,flags);
//	        return result;
//	    }
//	   public static boolean jump(int []nums,int length,int index,boolean[]flags) {
//		  if(flags[index]) {
//			  return false;
//		  }
//		   if(index>length) {
//			   return false;
//		   }
//		   if(nums[index]==0) {
//			   return false;
//		   }
//		   if(nums[index]>=(length-index)) {
//			   return true;
//		   }
//		   boolean flag=false;
//		   for(int i=nums[index];i>0;i--) {
//			   flag=jump(nums,length,index+i,flags);
//			   if(flag) {
//				   return true;
//			   }
//		   }
//		   flags[index]=true;
//		   return false;
//	   }
	//�����߼��ϴ�������
//	   public boolean canJump(int[] nums) {
//		   if(nums==null||nums.length<1) {
//	        	return false;
//	        }
//	        if(nums.length==1){
//	            return true;
//	        }
//	        boolean result=true;
//	        int length=nums.length-1;
//	        int zero=0;
//	        while(nums[length]==0) {
//	        	zero++;
//	        	length--;
//	        }
//	        if(nums[length]<zero) {
//	        	return false;
//	        }
//	        if(nums[length]==zero) {
//	        	return true;
//	        }
//	        zero=0;
//	        for(int i=length;i>-1;i--) {
//	        
//	        	if(nums[i]>zero) {
//	        		zero=0;
//	        		continue;
//	        	}
//	        	if(nums[i]==0) {
//	        		zero++;
//	        	}else {
//	        		result=false;
//	        		break;
//	        	}
//	        	
//	        }
//	        if(zero>0) {
//	        	result=false;
//	        }
//	        return result;
//	   }
	
	//ʹ�ö�̬�滮�ķ���������      
	//���ƹ�ʽΪ   
	//��һ�������� ���� ��һλ�õ�����(�����λ��������Զ)�� ��һ����������һ֮������ֵ
    public boolean canJump(int[] nums) {
		   if(nums==null||nums.length<1) {
	        	return false;
	        }
		   //������Ϊ1ʱ���϶��ܹ�����
	        if(nums.length==1){
              return true;
          }
	        int result=0;
	        int length=nums.length;
	        for(int i=0;i<length;i++) {
	        	//�����ĵ��ƹ�ʽ
	        		result=Math.max(nums[i], result-1);
	        		
              if(result<0) {
	        		return false;
	        	}
              //��������Ϊ0��ȴ����ͣ���յ��ϵ����
              if(result==0&&i!=length-1) {
            	  return false;
              }
	        }
	        return result>=0;
	   }
	public static void main(String[] args) {
	int []nums= {0,1};
	DynamicPrograme1 test=new DynamicPrograme1();
	test.canJump(nums);
	}

}

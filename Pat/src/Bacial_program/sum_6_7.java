package Bacial_program;
/*
 * ����Ҫ��ʵ��һ���������ж���һ��������N�Ƿ�����������
 * ������ȫƽ����������������λ������ͬ����144��676�ȡ�
 */
public class sum_6_7 {
public static boolean IsNumber(int n) {
	boolean flag=false;
	int temp=n;
	int length=0;
	int []a =new int[10];
	while(temp>0) {
		a[length]=temp%10;
		length++;
		temp=temp/10;
	}
	//�ж��������ƽ�����Ƿ�Ϊ����
	if(IsInt(Math.sqrt(n)+"")) {
	    for(int i=0;i<length-1;i++) {
	    	for(int j=i+1;j<length;j++) {
	    		if(a[i]==a[j]) {
	    			flag=true;
	    			break;
	    		}
	    	}
	    }
	}
	
	return flag;
}
/*
 * �˺��������ж�һ�����Ƿ�Ϊ��������֧��double�����������ж�
 * �� 4.0Ϊtrue 4Ϊfalse
 */
public static boolean IsInt(String i) {
	boolean flag=false;
	int index=i.indexOf(".");
    i=i.substring(index+1);//�������С������С��������
   if(i.equals("0")) {
	   flag=true;
   }
	return flag;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //System.out.println(IsNumber(143));
		int number=0;
        for(int i=100;i<1000;i++) {
        	if(IsNumber(i)) {
        		System.out.println(i);
        		number++;
        	}
        }
        System.out.println(number);
       // System.out.println(IsInt("4.0"));
	}

}

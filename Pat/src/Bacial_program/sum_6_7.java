package Bacial_program;
/*
 * 本题要求实现一个函数，判断任一给定整数N是否满足条件：
 * 它是完全平方数，又至少有两位数字相同，如144、676等。
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
	//判断这个数的平方根是否为整数
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
 * 此函数用来判断一个数是否为整数，仅支持double类型数进行判断
 * 例 4.0为true 4为false
 */
public static boolean IsInt(String i) {
	boolean flag=false;
	int index=i.indexOf(".");
    i=i.substring(index+1);//用来获得小数点后的小数部分数
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

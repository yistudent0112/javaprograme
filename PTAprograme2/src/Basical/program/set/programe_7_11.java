package Basical.program.set;
/*
 * 为鼓励居民节约用水，自来水公司采取按用水量阶梯式计价的办法，
 * 居民应交水费y（元）与月用水量x（吨）相关：
 * 当x不超过15吨时，y=4x/3；
 * 超过后，y=2.5x−17.5。
 * 请编写程序实现水费的计算。
 */
public class programe_7_11 {
public static double CountPrice(int UsedWater) {
	double sum=0.0;
	if(UsedWater<=0) {
		//表示输入的用水量异常
		sum=-1;
	}else if(UsedWater<=15) {
		sum=4.0/3*UsedWater;
	}else {
		sum=2.5*UsedWater-17.5;
	}
	return sum;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       System.out.println(CountPrice(0));
       System.out.println(CountPrice(15));
       System.out.println(CountPrice(20));
	}

}

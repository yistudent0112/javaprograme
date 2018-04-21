package Bacial_program;
/*
 * 模拟交通警察的雷达测速仪。
 * 输入汽车速度，如果速度超出60 mph，
 * 则显示“Speeding”，否则显示“OK”。
 */
public class programe_7_8 {
	public static void  OverSpeed(int speed) {
		System.out.print("Speed: "+speed+"    ");
		if(speed>60) {
			System.out.println("Speeding");
		}else if(speed<0||speed==0) {
			System.out.println("Wrong speed");
		}else {
			System.out.println("OK");
		}
	}
    public static void main(String []args) {
    	OverSpeed(-10);
    	OverSpeed(40);
    	OverSpeed(100);
    }
}

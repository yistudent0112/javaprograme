package Bacial_program;
/*
 * ģ�⽻ͨ������״�����ǡ�
 * ���������ٶȣ�����ٶȳ���60 mph��
 * ����ʾ��Speeding����������ʾ��OK����
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

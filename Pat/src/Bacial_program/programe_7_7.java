package Bacial_program;

import java.util.Scanner;

/*
 * ��дһ������Ҫ���û�����24Сʱ�Ƶ�ʱ�䣬Ȼ����ʾ12Сʱ�Ƶ�ʱ�䡣
 */
public class programe_7_7 {
public static void TranseTime() {
	Scanner in =new Scanner(System.in);
	String time=in.next();
	//�������ʱ��ָ��Сʱ�ͷ�����������
	String[] times=time.split(":");

    int hour=Integer.parseInt(times[0]);
	int minute=Integer.parseInt(times[1]);
	String noon="AM";
	//��Сʱ�������д���������������������
	if(hour>12) {
		hour=hour-12;
		noon="PM";
	}
	System.out.println(hour+":"+minute+" "+noon);
	in.close();
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     TranseTime();
	}

}

package Bacial_program;

import java.util.ArrayList;
import java.util.List;

import Bacial_program.programe_7_5_table;
public class programe_7_5 {
	//����һ��List���ڴ洢table�е���Ϣ
private  List<programe_7_5_table>list;
public programe_7_5() {
	list=new ArrayList<programe_7_5_table>();
}
//����������list�������Ϣ
public void add(programe_7_5_table temp) {
	list.add(temp);
}
//����չʾlist�е���Ϣ
public void show() {
	System.out.println("-------------------------");
	System.out.print("Province"+"\t");
	System.out.print("Area(km2)"+"\t");
	System.out.print("Pop.(10K)"+"\t\n");
	System.out.println("-------------------------");
	for(programe_7_5_table t:list) {
		System.out.print(t.getProvince()+"\t");
		System.out.print(t.getArea()+"\t");
		System.out.print(t.getPop()+"\t");
		System.out.println();
	}
	System.out.println("-------------------------");
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		programe_7_5 p=new programe_7_5();
     programe_7_5_table t1=new programe_7_5_table("����", 139600.00, 6461.00);
     programe_7_5_table t2=new programe_7_5_table("����",  16410.54, 1180.77);
     programe_7_5_table t3=new programe_7_5_table("����", 82400.00, 3144.23);
     programe_7_5_table t4=new programe_7_5_table("�Ϻ�", 6340.50, 1360.26);
     programe_7_5_table t5=new programe_7_5_table("�㽭", 101800.00, 4894.00);
     p.add(t1);
     p.add(t2);
     p.add(t3);
     p.add(t4);
     p.add(t5);

     p.show();
     
	}

}

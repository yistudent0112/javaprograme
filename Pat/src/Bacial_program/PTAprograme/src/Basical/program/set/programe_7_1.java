package Basical.program.set;
/*
 * �����֪Ӣ�Ƴ��ȵ�Ӣ��foot��Ӣ��inch��ֵ��
 * ��ô��Ӧ������(foot+inch/12)��0.3048��
 * ���ڣ�����û����������������
 * ��ô��ӦӢ�Ƴ��ȵ�Ӣ�ߺ�Ӣ���Ƕ����أ�
 * ������1Ӣ�ߵ���12Ӣ�硣
 */
import Basical.program.set.programe_7_1_Inch;
public class programe_7_1 {
  public double  InchChangeMeter(programe_7_1_Inch Inch) {
	  double meter=0.0;
	  double inch=Inch.getInch();
	  double foot=Inch.getFoot();
	  meter=(foot+inch/12)*0.3048;
	  return meter*100;
  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		programe_7_1 p=new programe_7_1();
		programe_7_1_Inch Inch=new programe_7_1_Inch(5,0);
		System.out.println(p.InchChangeMeter(Inch));
	}

}

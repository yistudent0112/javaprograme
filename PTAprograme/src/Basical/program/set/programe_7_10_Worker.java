package Basical.program.set;

public class programe_7_10_Worker {
private int Years;
private int SalaryPerHour;
//���������޳���5��ʱ��Сʱ���ʱ�Ϊ50Ԫ
	public programe_7_10_Worker(int years) {
	Years = years;
	if(Years<5) {
		SalaryPerHour=30;
	}else {
		SalaryPerHour=50;
	}
}

	public int getYears() {
		return Years;
	}

	public int getSalaryPerHour() {
		return SalaryPerHour;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

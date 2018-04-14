package Basical.program.set;

public class programe_7_10_Worker {
private int Years;
private int SalaryPerHour;
//当工作年限超过5年时，小时工资变为50元
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

package DiDi;

public class PassengerCar extends Auto {
private int CapOfPassenger;
	public PassengerCar(String name, int num, int money,int Cap) {
		super(name, num, money);
		CapOfPassenger=Cap;
		// TODO Auto-generated constructor stub
	}
public void show() {
	super.show();
	System.out.println("the capacity of car is "+CapOfPassenger);
}
}

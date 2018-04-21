package DiDi;

public class PickUp extends Auto {
private int CapOfPassenger;
private int CapOfLoad;
	public PickUp(String name, int num, int money,int passenger,int load) {
		super(name, num, money);
		CapOfPassenger=passenger;
		CapOfLoad=load;
		// TODO Auto-generated constructor stub
	}
public void show() {
super.show();
	System.out.println("this car can load "+CapOfLoad+" tens of goods and carry "+CapOfPassenger+" passengers" );
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Auto a=new PickUp("bmw",5,500,5,0);
a.show();
	}

}

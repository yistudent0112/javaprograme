package DiDi;

public class Trunk extends Auto {
public int CapOfLoad;
	public Trunk(String name, int num, int money,int load) {
		super(name, num, money);
		CapOfLoad=load;
		// TODO Auto-generated constructor stub
	}
	public void show() {
		super.show();
		System.out.println("the capacity of trunk is "+CapOfLoad);
	}

}

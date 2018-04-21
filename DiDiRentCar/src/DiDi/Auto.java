package DiDi;

public class Auto {
private String BrandName;
private int number;
private int money;
public Auto(String name,int num,int money) {
	BrandName=name;
	number=num;
	this.money=money;
}
public void borrow(int day) {
	number--;
	
}
public void back () {
	number++;
}
public void show() {
	System.out.println("this car is "+BrandName+".It will cost "+money+" per day.");
}
public int getMoney() {
	return money;
}
public String getName() {
	return BrandName;
}

	
}

package DiDi;

public class Test {
private static Auto a=new PassengerCar("benz c",1,700,5);
private static Auto b=new PassengerCar("bmw",3,600,5);
private static Auto c=new PassengerCar("audi",10,400,5);
private static Auto d=new Trunk("benz",5,1000,50);
private static Auto e=new Trunk("Tesla",1,2000,100);
private static Auto f=new Trunk("train",3,2700,150);
private static Auto g=new PickUp("GM",4,1200,20,5);
private static Auto h=new PickUp("ford",2,800,15,4);
private static Rent r=new Rent();
public static void main(String []args) {
	r.load(a);
	r.load(b);
	r.load(c);
	r.load(d);
	r.load(e);
	r.load(f);	
	r.load(g);
	r.load(h);
	//r.menu();
	r.exception();
	System.out.println(r.searchName("bmw").getName());
	System.out.println(r.searchName("").getName());
	System.out.println(r.searchNum(1).getName());
	System.out.println("the sum of money is "+r.Calculate());
	r.showAll();
}
}

package DiDi;
import java.util.ArrayList;
import java.util.Scanner;
public class Rent {
private ArrayList<Auto>a=new ArrayList<Auto>();
private ArrayList<Auto>temp=new ArrayList<Auto>();
public void showAll() {
	for(Auto a:temp) {
		a.show();
	}
}
public void load(Auto e) {
	a.add(e);
}
public Auto rent(int n) {
	Auto tem=a.get(n);
	temp.add(tem);
	return tem;
}
public void printAll() {
	int i=0;
	for(Auto b:a) {
		System.out.print(i+".");
		b.show();
		i++;
	}
}
public int Calculate() {
	
	int sum=0;
	for(Auto b:temp) {
		sum=sum+b.getMoney();
	}
	return sum;
}
public Auto searchNum(int n) {
	return a.get(n);
}
public Auto searchName(String name) {
	for(Auto b:a) {
		if(b.getName().equals(name))
			return b;
	}
	Auto wrong =new Auto("Not Found",0,0);
	return wrong;
}
public void exception() {
	try {
		System.out.println("before the exception happen.");
		int i=1/0;
		System.out.println("after the exception happen.");
	}catch(Exception e) {
		System.out.println("catch the exception");
		showAll();
	}
}
public void menu() {
	Scanner in=new Scanner(System.in);
	boolean again=true;
	int temp=0;
	int choose=0;
	do {
		printAll();
		System.out.println("please choose the car you want to rent.");
		choose=in.nextInt();
		rent(choose);
		System.out.println("if you want to quit(print 1)");
		temp=in.nextInt();
	if(temp==1)
		again=false;
	}while(again);
	in.close();
}
}

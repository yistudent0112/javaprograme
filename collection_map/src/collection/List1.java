package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class List1 {
private List<Integer>a;
public List1() {
	a=new ArrayList<Integer>();
}
public void add(int b) {
	a.add(b);
}
public void sort() {
	Collections.sort(a);
	System.out.println("after sort");
	show();
}
public void show() {
	for(int temp:a) {
		System.out.println(temp);
	}
}
public boolean contains(int n) {
	return a.contains(n);
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
List1 l1=new List1();
Random r=new Random();
for(int i=0;i<10;) {
	int  temp=r.nextInt(100);
	while(!l1.contains(temp)) {
		l1.add(temp);
		i++;
	}
}
System.out.println("before sort");
l1.show();
l1.sort();
	}

}

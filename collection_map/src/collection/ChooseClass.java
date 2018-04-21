package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ChooseClass {
private List<course> a;
public ChooseClass() {
	this.a=new ArrayList<course>();
}
public  void showAll() {
	//System.out.println("the course to choose : ");
	for(course temp:a) {
		 
		 System.out.println("the name of course is "+temp.getName()+"the id of course is "+temp.getId());
	}
}
public course add(int n) {
	for(course temp:a) {
		if(temp.getId()==n)
			return temp;
	}
	return null;
}
public void choose() {
	student s=new student(10,"yi");
	course c1=new course("高数",1);
	course c2=new course("大物",2);
	course []c3= {new course("离散",3),new course("c语言",4)};
	course []c4= {new course("数据结构",5),new course("数据库",6)};
	a.add(c1);
	a.add(c2);
	//a.addAll(c3);
	a.addAll( Arrays.asList(c3));
	a.addAll( Arrays.asList(c4));
	Scanner in=new Scanner (System.in);
	int num=0;
	for(int i=0;i<3;i++) {
	System.out.println("choose from that class : ");
	showAll();
System.out.println("please input the number of the clas you want to add.");
s.add(add(in.nextInt()));
	}
	in.close();
	s.showAll();
}
public static void main(String []args) {
	ChooseClass c=new ChooseClass();
	c.choose();
}
}

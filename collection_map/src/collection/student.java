package collection;

import java.util.HashSet;
import java.util.Set;

public class student {
private int id;
private String name;
private Set<course> Course;
public student(int id,String name) {
	this.id=id;
	this.name=name;
	this.Course=new HashSet<course>();
}
public void add(course a) {
	Course.add(a);
}
public int getId() {
	return id;
}
public String getName() {
	return name;
}

public void showAll() {
	for(Object a:Course) {
		 course temp=(course)a;
		 System.out.println("the name of course is "+temp.getName()+"the id of course is "+temp.getId());
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
course a =new course("¸ßÊý",1);
course b =new course("´óÓ¢",2);
student s=new student(10,"yi");
//s.add(a);

	}

}

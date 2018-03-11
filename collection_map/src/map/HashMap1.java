package map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class HashMap1 {
private Map<Integer,Student>s;
public HashMap1() {
	s=new HashMap<Integer,Student>();
}
public void add() {
	Scanner in=new Scanner (System.in);
	int i=0;
	while(i<3) {
		System.out.println("please print the student name");
		String name=in.next();
		System.out.println("please print the student id");
		int number=in.nextInt();
		Student temp=s.get(number);
		if(temp==null) {
		Student s1=new Student(name,number);
		s.put(number, s1);
		System.out.println("add sucessed");
		i++;
		}
		else {
			System.out.println("this student id has been used.");
			continue;
		}
	}
	//in.close();
}
public boolean testContainsKey(Integer a) {
	return s.containsKey(a);
}
public void show1() {
	Set<Integer>temp=s.keySet();
	System.out.println("get by keyet");
	System.out.println("we have "+s.size()+" students");
	for(Integer i:temp) {
		System.out.println(s.get(i));
	}
}
public void modify() {
	Scanner in=new Scanner (System.in);
	System.out.println("please print the student id");
	int number=in.nextInt();
	System.out.println("please print the student name to modify");
	String name=in.next();

	Student temp=s.get(number);
	if(temp==null) {
	System.out.println("id do not exit");
	}
	else {
		Student s1=new Student(name,number);
		s.replace(number, s1);
		System.out.println("modify successed");
	}
	in.close();
}

public void remove() {
	int number;
	System.out.println("please input the student id to remove");
	Scanner in=new Scanner (System.in);
	number=in.nextInt();
	Student temp=s.get(number);
	if(temp==null) {
		System.out.println("we do not have this student");
	}
	else
	s.remove(number);
}
public void show2() {

	System.out.println("by entry");
	Set<Entry<Integer,Student>>s1=s.entrySet();
	for(Entry<Integer,Student>s2:s1) {
		System.out.println(s2.getValue());
	}
}
//@SuppressWarnings("unchecked")
public void sort() {	
	ArrayList <Student>list =(ArrayList<Student>) s.values();
	//Arrays.sort(list);
	for(Student a:list) {
		System.out.println("student id is "+a);
	}
//Collections.sort(list,Comparator<Map.Entry<Integer, Student>>(){
//	public int compare(Entry<Integer, Student>o1,Entry<Integer, Student>o2) {
//		 return o1.getValue().compareTo(o2.getValue());
//	}
//});
}
public boolean testContains(Student a) {
	return s.containsValue(a);
}
public  static void main(String []args) {
	HashMap1 h=new HashMap1();
	h.add();
   // h.show1();
	//h.modify();
	//h.remove();
	//System.out.println(h.testContainsKey(1));
h.sort();
    //Student a=new Student("yi",1);
	//System.out.println(h.testContains(a));
	//h.show2();
}
}

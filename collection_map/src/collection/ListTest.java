package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListTest {
private List<course> CourseToSelect;
public ListTest() {
	CourseToSelect=new ArrayList<course>();
}
public void add(course a) {
	CourseToSelect.add(a);
}
public void add(course a,int index) {
	CourseToSelect.add(index, a);
}
public void add(course[] a) {
	CourseToSelect.addAll(Arrays.asList(a));
}
public void add(course[]a,int index) {
	CourseToSelect.addAll(index, Arrays.asList(a));
}
public void showAll() {
	System.out.println("the course to choose : ");
	for(Object a:CourseToSelect) {
		 course temp=(course)a;
		 System.out.println("the name of course is "+temp.getName()+"the id of course is "+temp.getId());
	}
}
public void testIterator() {
	Iterator it=CourseToSelect.iterator();
	System.out.println("use iterator");
	while(it.hasNext()) {
		course temp=(course) it.next();
		 System.out.println("the name of course is "+temp.getName()+"the id of course is "+temp.getId());	
	}
}
public void setCourse(int index,course a) {
	CourseToSelect.set(index, a);
}
public void removeCourse(int index) {
	CourseToSelect.remove(index);
}
public void removeCourse(course a) {
	CourseToSelect.remove(a);
}
public void removeCourse(course[]a) {
	CourseToSelect.removeAll(Arrays.asList(a));
}
public course getCourse(int index) {
	return (course)CourseToSelect.get(index);
}
public boolean testContains(course a) {
	return CourseToSelect.contains(a);
}
public boolean testContainsAll(course[]a) {
	return CourseToSelect.containsAll(Arrays.asList(a));
}
public int testIndex(course a) {
	return CourseToSelect.indexOf(a);
}
public int testLastIndex(course a) {
	return CourseToSelect.lastIndexOf(a);
}
public void test() {
	course c1=new course("高数",1);
	course c2=new course("大物",2);
	course []c3= {new course("离散",3),new course("c语言",4)};
	course []c4= {new course("数据结构",5),new course("数据库",6)};
//ListTest l=new ListTest();
add(c1);
add(c2,0);
add(c3);
add(c4,2);
add(c1);
showAll();
System.out.println("whether contains course c1 :"+testContains(c1));
course c=new course("高数",1);
System.out.println("whether contains course c1 :"+testContains(c));
System.out.println("whether contains course c3 :"+testContainsAll(c3));
course []c5= {new course("离散",3),new course("c语言",4)};
System.out.println("whether contains course c3 :"+testContainsAll(c5));
System.out.println("the index of the course c1 is "+testIndex(c1) );
System.out.println("the index of the course c1 is "+testLastIndex(c1) );
//System.out.println("the index of the course c1 is "+testIndex(c1) );

//System.out.println(l.getCourse(0).getName());
//l.testIterator();
//l.setCourse(0, c1);
//l.showAll();
//l.removeCourse(c1);
//l.removeCourse(0);
//l.removeCourse(c3);
//l.showAll();
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((CourseToSelect == null) ? 0 : CourseToSelect.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	ListTest other = (ListTest) obj;
	if (CourseToSelect == null) {
		if (other.CourseToSelect != null)
			return false;
	} else if (!CourseToSelect.equals(other.CourseToSelect))
		return false;
	return true;
}
public static void main(String []args) {
ListTest t=new ListTest();
	t.test();
}
}

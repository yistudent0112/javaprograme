package map;

public class Student implements Comparable{
private String name;
private int Id;
public Student(String name,int id ) {
	this.name=name;
	Id=id;
}
public String toString() {
	return "student name is "+name+" .student id is "+Id;
}
public int getId() {
	return Id;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + Id;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
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
	Student other = (Student) obj;
	if (Id != other.Id)
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	return true;
}
@Override
public int compareTo(Object obj) {
	// TODO Auto-generated method stub
	Student s1=(Student )obj;
	if(this.Id>s1.Id)
	return 1;
	else if(this.Id==s1.Id)
return 0;
	else 
		return -1;
}
}

package collection;

public class course {
private String name;
private int id;
public course(String name,int id ) {
	this.name=name;
	this.id=id;
}
public String getName() {
	return name;
}
public int getId() {
	return id;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
	return result;
}
//@Override
//public boolean equals(Object obj) {
//	if (this == obj)
//		return true;
//	if (obj == null)
//		return false;
//	if (getClass() != obj.getClass())
//		return false;
//	course other = (course) obj;
//	if (id != other.id)
//		return false;
//	return true;
//}
@Override 
public boolean equals(Object obj) {
	if(this==obj)
		return true;
	if(obj==null)
		return false;
	if(getClass()!=obj.getClass())
		return false;
	course other =(course)obj;
	if(id!=other.id)
		return false;
	return true;
}
}

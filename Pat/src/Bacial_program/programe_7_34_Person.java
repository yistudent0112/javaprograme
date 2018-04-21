package Bacial_program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class programe_7_34_Person {
	private String Name;
	private String BirthDay;
	private String Gender;
	private String LocalPhone;
	private String MobilePhone;

	public String getName() {
		return Name;
	}

	public programe_7_34_Person(String name, String birthDay, String gender, 
			String localPhone, String mobilePhone) {
		Name = name;
		BirthDay = birthDay;
		Gender = gender;
		LocalPhone = localPhone;
		MobilePhone = mobilePhone;
	}
 
	public void setBirthDay(String birthDay) {
		BirthDay = birthDay;
	}

	public void setName(String name) {
		Name = name;
	}


	public String getBirthDay() {
		return BirthDay;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getLocalPhone() {
		return LocalPhone;
	}

	public void setLocalPhone(String localPhone) {
		LocalPhone = localPhone;
	}

	public String getMobilePhone() {
		return MobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		MobilePhone = mobilePhone;
	}

	@Override
	public String toString() {
		return "Person [Name=" + Name + ", BirthDay=" + BirthDay + ", Gender=" 
	+ Gender + ", LocalPhone="+ LocalPhone + ", MobilePhone=" + MobilePhone + "]";
	}

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
/*String time="2014/2/2";
SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd");
Date d=dateFormat.parse(time);
System.out.println(d);*/
	}

}

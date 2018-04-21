package Bacial_program;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 通讯录中的一条记录包含下述基本信息：
 * 朋友的姓名、出生日期、性别、固定电话号码、移动电话号码。 
 * 本题要求编写程序，录入N条记录，
 * 并且根据要求显示任意某条记录。
 */
public class programe_7_34 {
	private static List<programe_7_34_Person> list = new 
			ArrayList<programe_7_34_Person>();
	private static int N;

	public static void Input() {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		for (int i = 0; i < N; i++) {
			String Name = in.next();
			String BirthDay = in.next();
			String Gender = in.next();
			String LocalPhone = in.next();
			String MobilePhone = in.next();
			programe_7_34_Person p = new programe_7_34_Person(Name, BirthDay,
					Gender, LocalPhone, MobilePhone);
			AddPerson(p);
		}
		
	}

	public static boolean AddPerson(programe_7_34_Person p) {
		return list.add(p);
	}

	public static programe_7_34_Person FindPersonByIndex(int index) {
		if (index > (list.size()-1) || index < 0) {
			return null;
		}
		programe_7_34_Person temp = list.get(index);
		return temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Input();
		String flag = "";
		Scanner in = new Scanner(System.in);
		while (!flag.equals("exit")) {
			System.out.println("please input the index of information "
					+ "you want to search");
			int index = in.nextInt();
			if (FindPersonByIndex(index) == null) {
				System.out.println("Not Found!");
			} else {
				System.out.println(FindPersonByIndex(index));
			}
			System.out.println("if you want to quit,print exit");
			flag = in.next();
		}
		in.close();
	}

}

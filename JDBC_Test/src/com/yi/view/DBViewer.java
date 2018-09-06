package com.yi.view;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import com.yi.control.DBAction;
import com.yi.util.Task;

public class DBViewer {
	private static DBAction action=null;
	private static String context = "��ӭ�����������ϵͳ\n" 
            + "�������������ϵͳ�Ĺ����б�:\n" 
			+ "[MAIN\\M]:���˵�\n" 
            + "[ADD\\A]:�½�����\n"
			+ "[UPDATE\\U]:��������\n" 
            + "[DELETE\\D]:ɾ������\n" 
			+ "[QUERY\\Q]:��ѯ��������\n"
			+ "[SEARCH\\S]:��ѯ������Ϣ(�������������������������)\n" 
			+ "[PRIORITY\\P]:������������ȼ������������������\n"
			+ "[DIFFICULTY\\F]:����������Ѷȶ����������������\n" 
			+ "[BREAK\\B]:�˳���ǰĿ¼���������˵�\n" 
			+ "[EXIT\\E]:�˳��������ϵͳ\n";
	private static String OPERATION_MAIN = "MAIN";
	private static String OPERATION_ADD = "ADD";
	private static String OPERATION_UPDATE = "UPDATE";
	private static String OPERATION_DELETE = "DELETE";
	private static String OPERATION_QUERY = "QUERY";
	private static String OPERATION_SEARCH = "SEARCH";
	private static String OPERATION_PRIORITY = "PRIORITY";
	private static String OPERATION_DIFFICULTY = "DIFFICULTY";
	private static String OPERATION_BREAK = "BREAK";
	private static String OPEARTION_EXIT = "EXIT";
static {
	action=new DBAction();
}
	public static void main(String[] args) {
	
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		System.out.println(context);
		String word = null;
		boolean exit=false;
		while (true) {
			word = in.next();
			switch (word) {
			case "MAIN":
			case "main":
			case "m":
			case "M":MainMenu();
				break;
			case "ADD":
			case "add":
			case "a":
			case "A":Add(in);
				break;
			case "UPDATE":
			case "update":
			case "u":
			case "U":Update(in);
				break;
			case "DELETE":
			case "delete":
			case "d":
			case "D":Delete(in);
				break;
			case "QUERY":
			case "query":
			case "q":
			case "Q":SearchAll();
				break;
			case "search":
			case "SEARCH":
			case "s":
			case "S":SearchDIY(in);
				break;
			case "PRIORITY":
			case "priority":
			case "p":
			case "P":Priority(in);
				break;
			case "DIFFICULTY":
			case "difficulty":
			case "f":
			case "F":Difficulty(in);
				break;
			case "BREAK":
			case "break":
			case "b":
			case "B":MainMenu();
				break;
			case "EXIT":
			case "exit":
			case "e":
			case "E":
				exit=true;
				Exit();
				break;
				default:
					System.out.println("�������ָ���������������롣");
			}
			if(exit) {
				break;
			}
		}
		System.out.println("��л���ʹ�ã��ټ���");
		in.close();
	}
	public static void Exit() {
		System.out.println("�����˳��������ϵͳ��");
	}
	public static void MainMenu() {
		System.out.println(context);
	}
public static void Add(Scanner in) {
	int step=0;
	Task temp=new Task();
	if(step==0) {
		System.out.println("���������������");
		temp.setTask_name(in.next());
        step++;
	}
	if(step==1) {
		System.out.println("����������Ĺ�����");
		temp.setTask_charge(in.next());
        step++;
	}
	if(step==2) {
		System.out.println("��������������ȼ�");
		temp.setTask_priority(in.nextInt());
        step++;
	}
	if(step==3) {
		System.out.println("������������Ѷ�");
		temp.setTask_difficulty(in.nextInt());
        step++;
	}
	if(step==4) {
		System.out.println("����������Ľ���(100Ϊ���)");
		temp.setTask_progress(in.nextInt());
        step++;
	}
	action.addTask(temp);
	System.out.println("������ӳɹ�");
}
public static void Update(Scanner in) {
	SearchAll();
	int step=0;
	Task temp=new Task();
	String word=null;
	if(step==0) {
		System.out.println("����������ı��");
		temp.setId(in.nextInt());
		temp=action.searchById(temp);
		List<Task>list=new ArrayList<Task>();
		list.add(temp);
		print(list);
		step++;
		word=in.nextLine();
	}
	
	if(step==1) {
		System.out.println("���������������");
		temp.setTask_name(in.next());
        step++;
	}
	if(step==2) {
		System.out.println("����������Ĺ�����");
		temp.setTask_charge(in.next());
        step++;
	}
	if(step==3) {
		System.out.println("��������������ȼ�");
		temp.setTask_priority(in.nextInt());
        step++;
	}
	if(step==4) {
		System.out.println("������������Ѷ�");
		temp.setTask_difficulty(in.nextInt());
        step++;
	}
	if(step==5) {
		System.out.println("����������Ľ���(100Ϊ���)");
		temp.setTask_progress(in.nextInt());
        step++;
	}
	action.updateTask(temp);
	System.out.println("������³ɹ�");
}
public static void Delete(Scanner in) {
	SearchAll();
	Task temp=new Task();
	System.out.println("����������ı��");
	temp.setId(in.nextInt());
	action.deleteTask(temp);
	System.out.println("����ɾ���ɹ�");
}

public static void Priority(Scanner in) {
	boolean asc=true;
	System.out.println("�������Ƿ��յ���˳���ѯ(Y/N)");
	String word=in.next();
	if(Objects.equals(word, "N")||Objects.equals(word, "n")) {
		asc=false;
	}
	List<Task>list=new ArrayList<Task>();
	list=action.searchAllTaskOrderByPriority(asc);
print(list);
}
public static void Difficulty(Scanner in) {
	boolean asc=true;
	System.out.println("�������Ƿ��յ���˳���ѯ(Y/N)");
	String word=in.next();
	if(Objects.equals(word, "N")||Objects.equals(word, "n")) {
		asc=false;
	}
	List<Task>list=new ArrayList<Task>();
	list=action.searchAllTaskOrderByDifficulty(asc);
	print(list);
}
public static void SearchAll() {
	List<Task>list=new ArrayList<Task>();
	list=action.searchAllTask();
	print(list);
}
public static void print(List<Task> list) {
	System.out.println("*************************************************************"
			+ "**************************************************************");
	System.out.println("id\t"+"task_name\t"+"task_start\t"+"task_end\t"+"task_charge\t"
			+"task_priority\t"+"task_difficulty\t");
	for(Task temp:list) {
		System.out.println(temp.getId()+"\t"+temp.getTask_name()+"      \t"+temp.getTask_start()+"  \t"
	+temp.getTask_end()+"       \t"+temp.getTask_charge()+"       \t"
				+temp.getTask_priority()+"     \t"+temp.getTask_difficulty()+"   \t");
		printProgress(temp.getTask_progress());
	}
	System.out.println("*************************************************************"
			+ "**************************************************************");
}
public static void printProgress(int number) {
	if(number>100) {
		number=100;
	}
	if(number<0) {
		number=0;
	}
	int n=number/10;
	System.out.print("������ɽ���: ");
	for(int i=0;i<n;i++) {
		System.out.print("===");
	}
	System.out.println(" "+number+"%");
}
public static void SearchDIY(Scanner in) {
	List<Map<String,Object>>params=new ArrayList<Map<String,Object>>();
	List<Task>list=new ArrayList<Task>();
	Map<String,Object>param=new HashMap<String,Object>();
	boolean loop=true;
	String word=in.nextLine();
	while(loop) {
	System.out.println("��������ļ�������   where (���벿��)");
	word=in.nextLine();
	String []words=word.split(" ");
	if(words.length>2) {
	param.put("name",words[0]);
	param.put("rela", words[1]);
	param.put("value", words[2]);
	params.add(param);
	loop=false;
	}else {
		System.out.println("������ļ���������������������");
	}
	}
	list=action.searchTaskDIY(params);
    print(list);
}
}

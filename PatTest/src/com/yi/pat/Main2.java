package com.yi.pat;


import java.util.Scanner;
/*
 * �����˼���ǰѶ���ĸ��׺�����Ϣת��Ϊͼ���ڽӱ���ʽ������
 * Ȼ��Ը��������ȱ�����ȷ��ÿһ�����������ı���
 * �������������Ϣȥ�������ҵ���������ͬ���ˣ����ҵ����������ڵı��ּ���
 */
public class Main2 {

	public static void main(String[] args) {
	Scanner in=new Scanner(System.in);
	int length=in.nextInt();
	int fathers=in.nextInt();
	int []persons=new int [length+1];
	int father=0;
	int sonNums=0;
	for(int i=0;i<fathers;i++) {
		father=in.nextInt();
		sonNums=in.nextInt();
		for(int j=0;j<sonNums;j++) {
			persons[in.nextInt()]=father;
		}
	}
	
	in.close();
	int []generations=new int[length+1];
	findGeneration(generations, 1, length, persons, 2);
//	for(int temp:generations) {
//		System.out.printf("%5d",temp);
//	}
	int genes=0;
	int index=0;
	int []results=new int [fathers];
	for(int i=1;i<=length;i++) {
	results[generations[i]]++;
	}
	for(int i=0;i<fathers;i++) {
		if(results[i]>genes) {
			genes=results[i];
			index=i;
		}
	}
	System.out.println(genes+" "+index);
	}
	//�Ը��������ȱ����ĵݹ麯��
	//genes�����ӵı��֣�father�������ĸ�����Ϣ��Ҳ���������Ϣȥ�ҵ��������ĺ�����
	//generations����������еĺ��ӱ�����Ϣ
public static void findGeneration(int []generations,int father,int length,int []persons,int genes) {
	for(int i=1;i<=length;i++) {
		if(persons[i]==father) {
			generations[i]=genes;
			findGeneration(generations, i, length, persons, genes+1);
		}
	}
}
}

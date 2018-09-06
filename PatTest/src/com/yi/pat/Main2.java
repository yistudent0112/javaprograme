package com.yi.pat;


import java.util.Scanner;
/*
 * 本题的思想是把读入的父亲孩子信息转换为图的邻接表形式存贮，
 * 然后对根结点做深度遍历来确定每一个孩子所处的辈分
 * 根据这个辈分信息去遍历，找到人数最多的同辈人，并找到他们所处于的辈分级别
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
	//对根结点做深度遍历的递归函数
	//genes代表孩子的辈分，father代表他的父亲信息，也根据这个信息去找到他所属的孩子们
	//generations数组存贮所有的孩子辈分信息
public static void findGeneration(int []generations,int father,int length,int []persons,int genes) {
	for(int i=1;i<=length;i++) {
		if(persons[i]==father) {
			generations[i]=genes;
			findGeneration(generations, i, length, persons, genes+1);
		}
	}
}
}

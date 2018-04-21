package poker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/*
 * �����ຬ��ϴ�ƣ����ƺ�������ӵ��һ�����һ�����Ƶ�����
 */
public class Board {
private static String[]colors= {"Spade","Heart","Diamond","Club"};
private static String[]numbers= {"A","2","3","4","5","6","7","8","9","10"
		,"J","Q","K"};
private static int CardLength=54;
private Card list[]=new Card[CardLength];
private static Player p1=new Player("yi");
private static Player p2=new Player("er");
private static Player p3=new Player("san");
private static Player p4=new Player("si");
/*
 * �����һ�������Ŀ��Ƴ���
 */
public Board() {
	int a=0;
	for(int i=0;i<colors.length;i++) {
		for(int j=0;j<numbers.length;j++) {
//		for(int a=0;a<52;a++) {
			Card temp=new Card(colors[i],numbers[j]);
			list[a]=temp;
		a++;
//		}
			}
	}
	//���ƿ��м����С��������
	list[a++]=new Card("joker","small");
	list[a++]=new Card("JOKER","big");
	}
	
/*
 * �Է��Ƶ��������б�����չʾ���е���
 */
public void show() {
	for(int i=0;i<list.length;i++) {
		System.out.println(list[i]);
	}
}
/*
 *���ƿ����ϴ�ƣ�ʹ�õķ��������ƿ��е����������ƽ���λ�� 
 */
public void shuffle() {
Random r=new Random();
int temp=r.nextInt(100)*10;
for(int i=0;i<temp;i++) {
	int location=r.nextInt(CardLength);
	int  location1=r.nextInt(CardLength);
	Card temp1=list[location];
	list[location]=list[location1];
	list[location1]=temp1;
}
}
//public void start() {
//	Player p1=new Player("yi");
//	Player p2=new Player("er");
//	for(int i=0;i<10;i++) {
//		p1.add(list[i]);
//		i++;
//		p2.add(list[i]);
//	}
//	System.out.println("Player 1");
//	p1.show();
//	System.out.println("Player 2");
//	p2.show();
//}
/*
 * ��nλ��ҷ�����Ϊcards����
 */
public void start(int n,int cards) {
	for(int i=0;i<n*cards;i++) {
	switch(n) {
	case 4:p4.add(list[i]);i++;
	case 3:p3.add(list[i]);i++;
	case 2:p2.add(list[i]);i++;
	case 1:p1.add(list[i]);
	}
	
	}
}
/*
 * ������ҵ�������ͬ����չʾ��ҵ�����
 */
public void showPlayerCard(int n) {
	switch(n) {
	case 4:System.out.println("player 4 card");p4.show();
	case 3:System.out.println("player 3 card");p3.show();
	case 2:System.out.println("player 2 card");p2.show();
	case 1:System.out.println("player 1 card");p1.show();	
	}
}
public void PlayRule(int n) {
	switch(n) {
	case 4:System.out.println("player 4 biggest card");
	System.out.println(p4.BigCard());
	case 3:System.out.println("player 3 biggest card");
	System.out.println(p3.BigCard());
//	System.out.println(p3.getLength());
	case 2:System.out.println("player 2 biggest card");
	System.out.println(p2.BigCard());
	case 1:System.out.println("player 1 biggest card");
	System.out.println(p1.BigCard());	
	}
	
}
public static void main(String[]args) {
	Board b=new Board();
	b.show();
	b.shuffle();
    System.out.println("-------------------------");
//	b.show();
	b.start(3,17);
	b.showPlayerCard(3);
	System.out.println("the biggest card.");
	b.PlayRule(3);
}
}

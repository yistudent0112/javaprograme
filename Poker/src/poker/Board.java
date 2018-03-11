package poker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/*
 * 牌桌类含有洗牌，发牌函数，并拥有一个存放一副卡牌的容器
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
 * 构造出一副完整的卡牌出来
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
	//给牌库中加入大小王两张牌
	list[a++]=new Card("joker","small");
	list[a++]=new Card("JOKER","big");
	}
	
/*
 * 对放牌的容器进行遍历，展示所有的牌
 */
public void show() {
	for(int i=0;i<list.length;i++) {
		System.out.println(list[i]);
	}
}
/*
 *对牌库进行洗牌，使用的方法是是牌库中的任意两张牌交换位置 
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
 * 给n位玩家发数量为cards的牌
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
 * 根据玩家的数量不同，来展示玩家的手牌
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

package poker;

import java.util.ArrayList;
/*
 * ����һ�������
 * ��һ���������ԣ�����һ�����������洢����
 */
public class Player {
private String name;
private ArrayList<Card>c=new ArrayList<Card>();
public Player(String n) {
	name=n;
}
/*
 * ��������ҵĿ���������ӿ���
 * ���ж��������Ƿ����ظ��Ŀ���
 */
public boolean add(Card a) {
	if(c.contains((Object)a)){
	return false;
	}
	c.add(a);
	return true;
}
/*
 * ������ӡ��ҵ�����
 */
public void show() {
	for(Card a:c) {
		System.out.println(a);
	}
}
public Card BigCard() {
	Card temp=c.get(0);
	for(int i=0;i<c.size();i++) {
		if(temp.compareTo(c.get(i))) {
			 temp=c.get(i);
		}
	}	
	return temp;
}
public int getLength() {
	return c.size();
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Player p=new Player("yi");
Card c=new Card("Diamond","2");
Card c1=new Card("Heart","Q");
Card c2=new Card("Diamond","K");
Card c3=new Card("Heart","2");
Card c4=new Card("Spade","2");
Card c5=new Card("Diamond","4");
Card c6=new Card("Diamond","5");
Card c7=new Card("Diamond","6");
Card c8=new Card("Diamond","7");
Card c9=new Card("Diamond","8");
Card c10=new Card("Diamond","9");
Card c11=new Card("Diamond","10");
p.add(c);
p.add(c1);
p.add(c2);
p.add(c3);
p.add(c4);
p.add(c5);
p.add(c6);
p.add(c7);
p.add(c8);
p.add(c9);
p.add(c10);
p.add(c11);
p.show();
System.out.println(p.BigCard());
	}

}

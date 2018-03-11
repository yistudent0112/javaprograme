package poker;
/*
 * 定义一个卡牌类
 * 有两个属性，花色和大小
 */
public class Card {

private String color;
private String number;
public Card(String c,String n) {
	color=c;
	number=n;
}
public int compareColor() {
	if(this.color.equals("Spade"))
		return 4;
	if(this.color.equals("Heart"))
		return 3;
	if(this.color.equals("Club"))
		return 2;
	if(this.color.equals("Diamond"))
		return 1;
	return 0;
}
public int compareNumber() {
	if(this.number.equals("A"))
		return 12;
	if(this.number.equals("2"))
		return 13;
	if(this.number.equals("3"))
		return 1;
	if(this.number.equals("4"))
		return 2;
	if(this.number.equals("5"))
		return 3;
	if(this.number.equals("6"))
		return 4;
	if(this.number.equals("7"))
		return 5;
	if(this.number.equals("8"))
		return 6;
	if(this.number.equals("9"))
		return 7;
	if(this.number.equals("10"))
		return 8;
	if(this.number.equals("J"))
		return 9;
	if(this.number.equals("Q"))
		return 10;
	if(this.number.equals("K"))
		return 11;
	if(this.number.equals("small"))
		return 14;
	if(this.number.equals("big"))
		return 15;
	return 0;
}
public boolean compareTo(Card other) {
	int number1=this.compareNumber()*10+this.compareColor();
	int number2=other.compareNumber()*10+other.compareColor();
	if(number1<number2)
		return true;
	else
	return false;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((color == null) ? 0 : color.hashCode());
	result = prime * result + ((number == null) ? 0 : number.hashCode());
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
	Card other = (Card) obj;
	if (color == null) {
		if (other.color != null)
			return false;
	} else if (!color.equals(other.color))
		return false;
	if (number == null) {
		if (other.number != null)
			return false;
	} else if (!number.equals(other.number))
		return false;
	return true;
}
/*
 * 用来返回卡牌的信息
 * @see java.lang.Object#toString()
 */
public String toString() {
	return "the card color is "+color+" the card number is "+number;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Card c1=new Card("joker","small");
		Card c2=new Card("JOKER","big");
		System.out.println(c2.compareTo(c1));
	}

}

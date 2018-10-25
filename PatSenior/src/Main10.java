import java.io.BufferedInputStream;
import java.util.Scanner;
class Person{
	int []scores;
	int sum;
	int FullScoreNum;
	int rank;
	int Num;
	public Person(int problems,int Num) {
		scores=new int[problems];
		this.Num=Num;
	}
}
public class Main10 {

	public static void main(String[] args) {
		Scanner in=new Scanner(new BufferedInputStream(System.in));
		int players=in.nextInt();
		int problems=in.nextInt();
		int count=in.nextInt();
		int []problemScore=new int[problems];
		Person []player=new Person[players];
		for(int i=0;i<problems;i++) {
			problemScore[i]=in.nextInt();
		}
		for(int i=0;i<count;i++) {
			
		}
		in.close();

	}

}

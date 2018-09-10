import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main5 {

	public static void main(String[] args) {
		Scanner in=new Scanner(new BufferedInputStream(System.in));
		int number=in.nextInt();
		List<Set<Integer>>list=new ArrayList<Set<Integer>>(number);
		Set<Integer>set=null;
		int temp;
		for(int i=0;i<number;i++) {
			set=new HashSet<Integer>();
			temp=in.nextInt();
			for(int j=0;j<temp;j++) {
				set.add(in.nextInt());
			}
			list.add(set);
		}
		int compare=in.nextInt();
		List<Integer>listMap=new ArrayList<Integer>();
		for(int i=0;i<2*compare;i++) {
		listMap.add(in.nextInt());
		}
		in.close();
		for(int i=0;i<compare*2;i=i+2) {
			System.out.printf("%.1f",calculatePercent(listMap.get(i)-1,listMap.get(i+1)-1, list)*100);
			System.out.println("%");
		}
//Set<Integer>set=new HashSet<Integer>();
//System.out.println(set.add(1));
//System.out.println(set.add(1));
//for(int t:set) {
//	System.out.println(t);
//}
		//System.out.printf("%.1f",0.111);
	}
public static double calculatePercent(int a,int b,List<Set<Integer>>list) {
	double precent=0.0;
	int common = 0;
	Set<Integer>seta=list.get(a);
	Set<Integer>setb=list.get(b);
	Set<Integer>same=new HashSet<Integer>();
	for(int temp:seta) {
		if(setb.contains(temp)) {
			common++;
		}
		same.add(temp);
	}
	for(int temp:setb) {
		same.add(temp);
	}
	precent=common*1.0/same.size();
	return precent;
}
}

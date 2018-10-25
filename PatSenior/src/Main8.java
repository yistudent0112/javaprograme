import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main8 {
	public static void main(String[] args) {
		Scanner in=new Scanner(new BufferedInputStream(System.in));
		int players=in.nextInt();
		int problems=in.nextInt();
		int count=in.nextInt();
	
		int [][]res=new int [players+1][problems+1];
		int temp=0;
		int temp1=0;
		int score=0;
		int []scores=new int[problems];
		int []fullMark=new int[players+1];
		for(int i=0;i<problems;i++) {
			scores[i]=in.nextInt();
		}
		for(int i=0;i<count;i++) {
			temp=in.nextInt();
			temp1=in.nextInt();
			score=in.nextInt();
			if(score==0||score==-1){
				res[temp][temp1]=-1;
			}else if(score>res[temp][temp1]&&score<=scores[temp1-1]) {
			res[temp][temp1]=score;
			if(score==scores[temp1-1]) {
				fullMark[temp]++;
			}
			}
		}
		in.close();
		Map<Integer,Float>map=new HashMap<Integer,Float>();
		float sum=0;
		for(int i=1;i<=players;i++) {
			for(int j=1;j<=problems;j++) {
				if(res[i][j]>0) {
					sum+=res[i][j];
				}
			}
			sum+=fullMark[i]*1.0/(problems+1);
			map.put(i, sum);
			sum=0.0f;
		}
		List<Map.Entry<Integer, Float>>list=new ArrayList<>(map.entrySet());
	   Collections.sort( list, new Comparator<Map.Entry<Integer, Float>>() {

		@Override
		public int compare(Entry<Integer, Float> o1, Entry<Integer,Float> o2) {
			if(o1.getValue()>o2.getValue()) {
				return -1;
			}else if(o1.getValue()<o2.getValue()){
				return 1;
			}
			return o1.getKey().compareTo(o2.getKey());
		}
	});
	   int sort=0;
	   int add=0;
		int length=list.size();
		for(int i=0;i<length;i++) {
			if(list.get(i).getValue()>0) {
				if(i>0&&Math.floor(list.get(i).getValue())==Math.floor(list.get(i-1).getValue())) {
					add++;
					System.out.print(sort+" ");
				}else {
					sort++;
					System.out.print((sort+add)+" ");
					add=0;
					
				}
					//System.out.print((sort+add)+" ");
					System.out.printf("%05d",list.get(i).getKey());
					System.out.print(" "+((int)Math.floor(list.get(i).getValue()))+" ");
				for(int k=1;k<problems;k++) {
					if(res[list.get(i).getKey()][k]==0) {
						System.out.print("- ");
					}else if(res[list.get(i).getKey()][k]==-1){
						System.out.print(0+" ");
					}else {
						System.out.print(res[list.get(i).getKey()][k]+" ");
					}
				}
				if(res[list.get(i).getKey()][problems]==0) {
					System.out.print("-");
				}else if(res[list.get(i).getKey()][problems]==-1){
					System.out.print(0);
				}else {
					System.out.print(res[list.get(i).getKey()][problems]);
				}
				System.out.println();
			}
		}
//		int []test=new int[10];
//		for(int temp:test) {
//			System.out.println(temp);
//		}
	}
	
}

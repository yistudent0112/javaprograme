import java.io.BufferedInputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class Main1098 {
public static void main(String[] args) {
	Scanner in =new Scanner(new BufferedInputStream(System.in));
	int number=in.nextInt();
	LinkedList<Integer>pre=new LinkedList<Integer>();
	LinkedList<Integer>post=new LinkedList<Integer>();
//	int []pre=new int[number];
//	int []post=new int[number];
	for(int i=0;i<number;i++) {
		pre.add(in.nextInt());
//		pre[i]=in.nextInt();
	}
	for(int i=0;i<number;i++) {
		post.add(in.nextInt());
//		post[i]=in.nextInt();
	}
	in.close();
	boolean Insert=true;
	String Insertion="Insertion Sort";
	String Heap="Heap Sort";
	Insert=choose(pre, post);
	if(Insert) {
		System.out.println(Insertion);
	}else {
		System.out.println(Heap);
	}
	for(int temp:post) {
		System.out.print(temp+" ");
	}
}
public static  boolean choose(LinkedList<Integer> pre,LinkedList<Integer> post) {
	boolean flag=true;
	int length=pre.size();
	int temp=0;
	int ASCindex=0;
	int DESCindex=0;
	for(int i=0;i<length-1;i++) {
		if(post.get(i)<post.get(i+1)) {
			ASCindex++;
		}else {
			break;
		}
	}
	for(int i=length-1;i>0;i--) {
		if(post.get(i)>post.get(i-1)) {
			DESCindex++;
		}else {
			break;
		}
	}
	if(DESCindex>ASCindex) {
		flag=false;
		temp=post.get(length-1-DESCindex);
		
	}else {
		temp=post.get(ASCindex+1);
		post.remove(ASCindex+1);
		for(int i=0;i<ASCindex;i++) {
			if(post.get(i)<temp&&temp<post.get(i+1)) {
				post.add(i+1, temp);
				break;
			}
		}	
	}
	return flag;
}
}

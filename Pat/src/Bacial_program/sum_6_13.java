package Bacial_program;
/*
 * ��һ���ϸ�������У�
 * ����int binSearch(SeqList T, KeyType k)�������ֵز���k�������е�λ�á�
 */
public class sum_6_13 {
public static int BinSearch(int []list,int key) {
	int temp=list.length/2;
	int high=list.length;
	int low=0;
	if(list[0]>key&&list[list.length]<key) {
		return -1;
	}
	boolean found=false;
	while(!found) {
		if(list[temp]<key) {
			low=temp;
			temp=(temp+high)/2;	
		}
		else if(list[temp]>key) {
			high=temp;
			temp=(temp+low)/2;
		}
		else if(list[temp]==key) {
			found=true;
		}
		if((high-low)==1) {
			found=true;
			temp=-1;
		}
		//  System.out.println(temp);
	}
	return temp;	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int list[]= {1,2,3,4,6};
     System.out.println(BinSearch(list, 6));
	}

}

package Basical.program.set;

/*
 * ����ÿ�ζ���һ����3λ����Ȼ�������λ��������֡�
 * ע�⣺����������ֺ��н�β��0ʱ�������Ӧ����ǰ����0��
 * ��������700�����Ӧ����7��
 */

public class programe_7_3 {
public static int transverse(int number) {
	if(number>-1) {
	int []numbers=new int[20];
	int index=0;
	//�������е�ÿλ�ֱ������������ȥ
	while(number>0) {		
		numbers[index]=number%10;		
		number=number/10;
		index++;
	}
	int result=0;
	//�������е�ÿλ�����ȡ����
	for(int i=0;i<index;i++) {
		result=result*10+numbers[i];
	}
	return result;
	//������������ֱ�ӷ���-1
	}else {
		return -1;
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      System.out.println(transverse(-1));
	}

}

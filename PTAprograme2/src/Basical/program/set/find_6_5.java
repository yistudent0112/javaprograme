package Basical.program.set;


import java.util.Collections;

/*
 * ����Ҫ��ʵ��һ����������N������Ԫ��S[]�е����ֵ��
 * ���м���Ԫ�ص�����Ϊ�Զ����ElementType��
 */
public class find_6_5 {
	class ElementType implements Comparable<ElementType>{
        int a;			
		@Override
		public int compareTo(ElementType e) {
			if(this.a>e.a)
				return 1;
			else if(this.a<e.a)
				return -1;
			else
			return 0;
		}		
	}
  /* ElementType max(ElementType a[],int n) {
	   ElementType []temp;
	   //temp=Collections.sort(a);
	   return temp[0];
   }
  */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
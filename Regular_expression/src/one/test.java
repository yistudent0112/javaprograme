package one;

public class test {
   public static void main(String[]args) {
	   String data="a";//����һ��������
	   String regex="\\d";//�����ж�
	   boolean flag=data.matches(regex);
	   //System.out.println(flag);
	   
	   String data1="a";//����һ��������
	   String regex1="\\D";//�������ж�
	   boolean flag1=data1.matches(regex1);
//	   System.out.println(flag1);
	   
	   String data2=" ";//����һ���ո�
	   String regex2="\\s";//�ո��ж�
	   boolean flag2=data2.matches(regex2);
	   //System.out.println(flag2);
	   
	   String data3="a";//����һ���ǿո�
	   String regex3="\\S";//�ǿո��ж�
	   boolean flag3=data3.matches(regex3);
//	   System.out.println(flag1);
	   
	   String data4="a";//����һ������
	   String regex4="\\w";//�����ж�
	   boolean flag4=data4.matches(regex4);
	   System.out.println(flag4);
	   
	   String data5="";//����һ���ǵ���
	   String regex5="^\\W$";//�ǵ����ж�(^��$��������������ʼ�����������ʡ�Բ�д)
	   boolean flag5=data5.matches(regex5);
//	   System.out.println(flag5);
	   
   }
}

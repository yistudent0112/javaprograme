package 线程_String;

public class TestString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "aa";//创建了一个对象，和一个对象名，对象名里面存放aa的地址
		String str2 = new String("aa");//创建了一个对象名，在这个对象名里面存放的是什么
									//创建了一个对象，在这个对象里面存放的是什么
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		System.out.println(str2==str1);
		System.out.println(str1.equals(str2));
		
		
	}
}

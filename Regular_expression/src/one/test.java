package one;

public class test {
   public static void main(String[]args) {
	   String data="a";//给定一个非数字
	   String regex="\\d";//数字判断
	   boolean flag=data.matches(regex);
	   //System.out.println(flag);
	   
	   String data1="a";//给定一个非数字
	   String regex1="\\D";//非数字判断
	   boolean flag1=data1.matches(regex1);
//	   System.out.println(flag1);
	   
	   String data2=" ";//给定一个空格
	   String regex2="\\s";//空格判断
	   boolean flag2=data2.matches(regex2);
	   //System.out.println(flag2);
	   
	   String data3="a";//给定一个非空格
	   String regex3="\\S";//非空格判断
	   boolean flag3=data3.matches(regex3);
//	   System.out.println(flag1);
	   
	   String data4="a";//给定一个单词
	   String regex4="\\w";//单词判断
	   boolean flag4=data4.matches(regex4);
	   System.out.println(flag4);
	   
	   String data5="";//给定一个非单词
	   String regex5="^\\W$";//非单词判断(^、$代表的是正则的起始与结束，可以省略不写)
	   boolean flag5=data5.matches(regex5);
//	   System.out.println(flag5);
	   
   }
}

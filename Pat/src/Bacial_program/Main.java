package Bacial_program;


import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String word1=in.nextLine();
		String word2=in.nextLine();
		String word3=in.nextLine();
		String word4=in.nextLine();
	   in.close();
	   int length1=0;
	   if(word1.length()<word2.length()) {
		   length1=word1.length();
	   }else {
		   length1=word2.length();
	   }
	   int length2=0;
	   if(word3.length()<word4.length()) {
		   length2=word3.length();
	   }else {
		   length2=word4.length();
	   }
	   char common1 = 0;
	   int common2=0;
	   boolean first=true;
	   boolean second=true;
	   for(int i=0;i<length1;i++) {
		   if(word1.charAt(i)==word2.charAt(i)&&first&&word1.charAt(i)>='A'&&word1.charAt(i)<='G') {
			   common1=word1.charAt(i);
			   first=false;
			   continue;
		   }
		   if(word1.charAt(i)==word2.charAt(i)&&second&&(word1.charAt(i)>='A'&&word1.charAt(i)<='N'
				   ||(word1.charAt(i)>='0'&&word1.charAt(i)<='9'))) {
			   common2=i;
			   second=false;
			 continue;
		   }  
		   if(!first&&!second) {
			   break;
		   }
		   
	   }
	   int common3=0;
	   for(int i=0;i<length2;i++) {
		   if(word3.charAt(i)==word4.charAt(i)&&word3.charAt(i)>='A') {
			   common3=i;
			   break;
		   }
	   }
	   int day=common1-'A';
	   String days=null;
	   switch (day) {
	case 0:
		days="MON";
		break;
	case 1:
		days="TUE";
		break;
	case 2:
		days="WED";
		break;
	case 3:
		days="THU";
		break;
	case 4:
		days="FRI";
		break;
	case 5:
		days="SAT";
		break;
	case 6:
		days="SUN";
		break;
	default:
		break;
	}
	   String hour;
	   String minute;
	   if(common2<10) {
		   hour="0"+common2;
	   }else {
		   hour=common2+"";
	   }
	   if(common3<10) {
		   minute="0"+common3;
	   }else {
		   minute=common3+"";
	   }
	   System.out.println(days+" "+hour+":"+minute);
//	  3485djDkxh4hhGE
//	  2984akDfkkkkggEdsb
	}

}

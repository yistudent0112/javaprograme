package com.yi.pat;

import java.util.Scanner;

public class CountPats {


		public static void main(String []args){
		Scanner in=new Scanner(System.in);
		String word=in.nextLine();
		int length=word.length();
		if(length<3){
		    System.out.println(0);
		}else{
		    int PNumber=0;
		    int TNumber=0;
		    int ANumber=0;
		    for(int i=0;i<length;i++){
		        if('A'==word.charAt(i)){
		            ANumber++;
		        }
		        else if('T'==word.charAt(i)){
		            TNumber++;
		        }
		        else if('P'==word.charAt(i)){
		            PNumber++;
		        }
		    }
		    if(PNumber<=TNumber&&(PNumber<=ANumber)){
		        System.out.println(PNumber);
		        return;
		    }
		     if(ANumber<=TNumber&&(ANumber<=PNumber)){
		        System.out.println(ANumber);
		        return ;
		    }
		     if(TNumber<=PNumber&&(TNumber<=ANumber)){
		        System.out.println(TNumber);
		        return ;
		    }
		}
		}
		

}

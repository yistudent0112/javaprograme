package com.yi.String;
/**
 * 
    * @ClassName: String6  
    * @Description: TODO
    * 实现 atoi，将字符串转为整数。
    * 在找到第一个非空字符之前，需要移除掉字符串中的空格字符。
    * 如果第一个非空字符是正号或负号，选取该符号，
    * 并将其与后面尽可能多的连续的数字组合起来，这部分字符即为整数的值。
    * 如果第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
    * 字符串可以在形成整数的字符后面包括多余的字符，
    * 这些字符可以被忽略，它们对于函数没有影响。
    * 当字符串中的第一个非空字符序列不是个有效的整数；
    * 或字符串为空；或字符串仅包含空白字符时，则不进行转换.
    * 若函数不能执行有效的转换，返回 0。
    * 说明：
    * 假设我们的环境只能存储 32 位有符号整数，
    * 其数值范围是 [−231,  231 − 1]。
    * 如果数值超过可表示的范围，则返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。 
    * @author yi  
    * @date 2018年7月16日  
    *
 */
public class String6 {
    public int myAtoi(String str) {
        long number=0;
        int sign=1;
        int wrong=0;
        StringBuffer buffer=new StringBuffer();
        char[]str1=str.toCharArray();
        for(int i=0;i<str.length();i++) {
        	if(buffer.length()==0) {
        		if(str1[i]=='-') {
        		sign=-1;
                 wrong++;
        		}
        		else if(str1[i]=='+') {
        			sign=1;
        		wrong++;
        		}
        		if(wrong>1) {
        			return (int)number;
        		}
        		else if(str1[i]=='0') {
                      if(!(str1[i+1]>='0'&&str1[i+1]<='9')) {
                    	  return (int)number;
                 	   }
        		}
        		else if(str1[i]>='a'&&str1[i]<='z'||str1[i]=='.') {
        			return (int)number;
        		}
        		else if(str1[i]>'0'&&str1[i]<='9') {
          		buffer.append(str1[i]);
          	   }
        	}else {
        	  if(str1[i]>='0'&&str1[i]<='9') {
        		buffer.append(str1[i]);
        	   }
        	  else {
        		  break;
        	  }
        	}
        }
        if(buffer.length()>0&&buffer.length()<18) {
        	number=Long.valueOf(buffer.toString()).longValue();
        }
        if(number>Integer.MAX_VALUE&&sign==1) {
        	return  Integer.MAX_VALUE*sign ;
        }else if(number>Integer.MAX_VALUE&&sign==-1) {
        	return  (Integer.MAX_VALUE+1)*sign ;
        }

        return (int)number*sign;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
String6 test=new String6();
test.myAtoi("   +0 123");
	}

}

package com.yi.Other;

import java.util.Objects;
import java.util.Stack;
/**
 * 
 * ����ж������Ƿ���ϱ�׼���⣬ʹ��ջ������Ϳ����ˣ��������Ž�ջ������������ʱ��ջһ��Ԫ�ؽ��бȽ�
 * �������ʱ����һЩ������û�п��ǵ�
 * 1.������Ķ��������ţ�û��������ʱ��Ӧ���ڽ���ǰ�ж�ջ�Ƿ�Ϊ��
 * 2.��ջ��û��Ԫ��ʱ��ֱ�Ӷ�����һ�������ţ�û�п��ǿ�ָ������
 * 3.û�п��ǵ��ַ�������Ϊ����ʱ���������жϣ�����ֱ�ӷ���false
 *
 */
public class Other5 {
	  public boolean isValid(String s) {
		  if(Objects.equals(null,s)||Objects.equals("", s)) {
			  return true;
		  }
	        boolean flag=true;
	        char[]words=s.toCharArray();
	        if(words.length%2!=0) {
	        	return false;
	        }
	        Stack<Character>stack=new Stack<Character>();
	        for(int i=0;i<words.length;i++) {
	        	if('('==words[i]) {
	        		stack.push('(');
	        	}
	        	else if('{'==words[i]) {
	        		stack.push('{');
	        	}else if('['==words[i]) {
	        		stack.push('[');
	        	}else if(')'==words[i]) {
	        		if(stack.isEmpty()) {
	        			flag=false;
	        			break;
	        		}
	        		char temp=stack.pop();
	        		if('('!=temp) {
	        			flag=false;
	        			break;
	        		}
	        	}else if('}'==words[i]) {
	        		if(stack.isEmpty()) {
	        			flag=false;
	        			break;
	        		}
	        		char temp=stack.pop();
	        		if('{'!=temp) {
	        			flag=false;
	        			break;
	        		}
	        	}else if(']'==words[i]) {
	        		if(stack.isEmpty()) {
	        			flag=false;
	        			break;
	        		}
	        		char temp=stack.pop();
	        		if('['!=temp) {
	        			flag=false;
	        			break;
	        		}
	        	}
	        }
	        if(!stack.isEmpty()) {
	        	flag=false;
	        }
	        	
	        return flag;
	    }
	public static void main(String[] args) {
		Other5 test=new Other5();
		String words="()[]{}";
		test.isValid(words);

	}

}

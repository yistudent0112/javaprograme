package com.yi.Other;

import java.util.Objects;
import java.util.Stack;
/**
 * 
 * 这道判断括号是否符合标准的题，使用栈来解决就可以了，把左括号进栈，读到右括号时出栈一个元素进行比较
 * 但在设计时，有一些问题我没有考虑到
 * 1.当读入的都是左括号，没有右括号时，应该在结束前判断栈是否为空
 * 2.当栈内没有元素时，直接读入了一个右括号，没有考虑空指针问题
 * 3.没有考虑到字符串长度为奇数时。不用做判断，可以直接返回false
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

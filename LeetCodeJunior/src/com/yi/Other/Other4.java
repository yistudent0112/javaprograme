package com.yi.Other;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * ������Ҫ��˼·�ϵ����⣬����ÿһ��Ĺ���ֻҪ�������������һ����������ĺ��������ľ�û��������
 * ��һ��ʼ��д��ʱ�������Ȱ����ߵ�����1���������У��ٲ����м�����ݡ�
 * ��������add������Ȼ�ܹ��ƶ�������ӣ������ܹ���ǰ�滹û�����ݵ���������£��ͶԺ������ֵ
 * ����ֻ�аѺ�һ��1��������������
 *
 */
public class Other4 {
public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> trangle=new ArrayList<List<Integer>>();
       
        for(int i=1;i<=numRows;i++) {
        	List<Integer>level=new ArrayList<Integer>(i);
        	if(i==1) {
        	level.add(1);
    
        	}
        	else if(i==2) {
        		level.add(1);
        		level.add(1);
            	
        	}
        	else {
        		List<Integer>preLevel=trangle.get(i-2);
        		level.add(1);
        		for(int j=0;j<preLevel.size()-1;j++) {
        			level.add(preLevel.get(j)+preLevel.get(j+1));
        		}
        		level.add(i-1,1);
        	}
        	trangle.add(level);
        }
        return trangle;
    }
	public static void main(String[] args) {
Other4 test=new Other4();
test.generate(4);
	}

}

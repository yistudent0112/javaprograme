package com.yi.Other;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * 这题主要是思路上的问题，对于每一层的构建只要想清楚是来自上一层的两个数的和所产生的就没有问题了
 * 在一开始编写的时候，我想先把两边的两个1给你加入层中，再补充中间的数据。
 * 后来发现add函数虽然能够制定索引添加，但不能够在前面还没有数据的内容情况下，就对后面添加值
 * 所以只有把后一个1结点放在最后添加了
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

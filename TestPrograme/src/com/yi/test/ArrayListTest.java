package com.yi.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *         接口                                  实现类            是否有序             是否允许元素重复
 *  Collection                  否                            是
 *  List                        是                            是
 *  Set          AbstractSet    否                            否
 *                 HastSet      否                            否
 *                 TreeSet   是(二叉排序树)               否
 *  Map          AbstractMap    否                    key不行，value可以
 *                 HashMap      否                    key不行，value可以
 *                 TreeMap   是(二叉排序树)       key不行，value可以
 *                 
 * ArrayList中常用的成员变量
 *    Object[]  elementData  核心变量，用来存放ArrayList中存放的元素
 *    int           size     表示当前数组中已添加的元素的数量
 * ArrayList中常用的函数
 * 1.size    得到ArrayList中已添加的元素的数量
 * 2.add     向ArrayList中添加一个元素，如果指定了添加的位置，并且当前位置上有值的话
 * 会把添加位置之后的所有元素都向后平移一格，然后再添加元素，也就是说不会发生元素被覆盖的情况
 * 3.get     从ArrayList中得到一个元素
 * 4.set     向ArrayList中的指定位置赋值，会产生元素的覆盖
 * 5.remove  从ArrayList中删除一个元素，并将删除位置后的所有元素前移一格
 * 6.clear   清除ArrayList中的所有元素
 */
public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
List<Integer>test=new ArrayList<Integer>();
	}

}

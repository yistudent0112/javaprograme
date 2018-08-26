package com.yi.contest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/*
 * 今天做题的时候需要用到动态增加数组。
 * 就是对于一个String类型的数组，我添加一个元素后，数组的长度会加一
 * 而不是事先指定好数组的长度，这样就不能解决长度不够用的问题了(即定义了长度为10，结果需要添加11个元素)
 * 而java自带的基础数据类型的所有数组类型中，都是在初始化的时候需要指定数组的长度
 * 从而固定的分配一段内存空间的，所以只能使用list类型的高级对象来实现动态增加的功能
 * 再通过toarray函数把它转化为数组类型
 * 下面记录一下静态数组的初始化方式和list类型转换中的问题
 */
public class contest888 {
	public void arrayInit() {
		// 这只是定义一个string数组类型的变量，但对他还没有进行初始化操作，也就不能对他进行使用
		// 当要使用它的时候，还是需要对他进行初始化的
		String[] a = null;
		// 固定长度的初始化方法，这种方法最为常见，会默认的将数组内的值置位null，如果是int就是0
		// 如果是double就是0.0，如果是boolean就是false
		String[] b = new String[10];
		// 根据给定的内容来初始化数组，数组的长度为初始化字符串的数量
		String[] c = {};
		// 另一种初始化字符串的方式，和上面那个一种的作用是一样的，只不过是不用的写法
		String[] d = new String[] {};
	}

	public void transList() {
		ArrayList<String> result = new ArrayList<String>();
		result.add("1");
		result.add("2");
		result.add("3");
		result.add("4");
		result.add("5");
		// 创建一个内容为空的字符串数组
		String[] temp = new String[] {};
		// 因为这时候temp不能够容纳转换成String数组的内容(temp为空，不能存放信息)，
		// 就会返回一个String数组
		result.toArray(temp);
		// 这时候使用temp来接受这个被转换好的数组就完成了转换
		temp = result.toArray(temp);
		// 或者直接将temp1定义为能够接受内容有足够大小的string数组，这时候就可以直接进行转换了
		String[] temp1 = new String[result.size()];
		result.toArray(temp1);
	}

	public String[] uncommonFromSentences(String A, String B) {
		if (Objects.equals("", A.trim()) && Objects.equals("", B.trim())) {
			return null;
		}
		if (Objects.equals("", A.trim())) {
			return B.split(" ");
		}
		if (Objects.equals(" ", B.trim())) {
			return A.split(" ");
		}
		String[] result = new String[] {};
		// StringBuffer sb=new StringBuffer();
		String[] resultA = A.split(" ");
		String[] resultB = B.split(" ");
		int lengthA = resultA.length;
		int lengthB = resultB.length;
		int index = 0;
		Set<String> setA = new HashSet<String>();
		for (int i = 0; i < lengthA; i++) {
			if (!setA.add(resultA[i])) {
				setA.remove(resultA[i]);
			}
		}
		Set<String> setB = new HashSet<String>();
		for (int i = 0; i < lengthB; i++) {
			if (!setB.add(resultB[i])) {
				setB.remove(resultB[i]);
			}
		}

		for (int j = 0; j < lengthB; j++) {
			if (!setA.contains(resultB[j])) {
				result[index++] = resultB[j];
				// sb.append(resultB[j]);
				// sb.append(" ");
			}
		}
		for (int i = 0; i < lengthA; i++) {
			if (!setB.contains(resultA[i])) {
				result[index++] = resultA[i];
				// sb.append(resultA[i]);
				// sb.append(" ");
			}
		}
		// ArrayList<String>result=new ArrayList<String>();
		// return result.toArray(String[]{} );
		// return sb.toString().trim().split(" ");
		return result;
	}

	public String[] test() {
		ArrayList<String> result = new ArrayList<String>();
		result.add("1");
		result.add("2");
		result.add("3");
		result.add("4");
		result.add("5");
		String[] temp = new String[] {};
		// result.toArray(temp);
		// temp[0]="1";
		return temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		contest888 test = new contest888();
		String a = "this apple is sweet";
		String b = "this apple is sour";
		test.uncommonFromSentences(a, b);
		// String[]result=test.test();
		// for(String word:result) {
		// System.out.println(word);
		// }
	}

}

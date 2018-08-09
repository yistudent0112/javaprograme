package com.yi.test;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

/**
 * 
 * 代码优化的作用    ————避免未知错误
 * 代码优化的目标：1.减小代码的体量   2.提高代码的运行效率
 * 
 * 具体细节：
 * 1.尽量多使用final修饰符
 * java编译器会尽可能将被final修饰的函数转换为内联函数，这样就会提高代码的性能
 * 并且使用final修饰还能避免函数被继承后重写，避免了错误发生的可能性
 * 2.尽量多重用对象
 * 少生成不必要生成的对象就能减少内存空间的使用，还能提高运行速度
 * 3.尽可能使用局部变量
 * 因为在java的内存机制中局部变量存贮在栈中，而全局变量存储在堆中，速度较慢
 * 而且局部变量不需要使用内存回收机制，在调用结束后就自动清理内存
 * 4.及时关闭输入输出流
 * 这些调用系统函数的功能都会占用大量的资源
 * 5.尽量减少对变量的重复运算
 * 例  for(int i=0;i<a.length;i++)   不如        for(int i=0,b=a.length;i<b;i++)
 * 6.谨慎使用异常
 *    异常对性能影响非常大，当异常被触发是java虚拟机就会修改堆栈信息。
 *    异常只应该用于错误处理，而不应该用于流程控制
 * 7.在使用集合或工具类使，如果知道大致使用范围就设定好集合的大小
 * 这样分配固定的内存空间，会比虚拟机不断给对象扩容内存空间在性能上快
 * 8.当要复制大量的数据时，使用System.arraycopy()
 * 9.乘法和除法运算使用移位运算来代替
 * 因为移位运算是由底层来实现的，所以性能上会快很多 
 * 10.不要让public方法中有太多的形参出现
 * public是对外公布的方法，要是参数过多会产生两个问题
 * 1.不符合面向对象的思想，过多的形参和面向对象的思想冲突
 * 2.过多的形参有可能会引发传参出错
 * 如果要传入的参数过多，可以将他作为一个封装类，然后传递一个类的对象进来
 * 11.对资源的close操作应该写在不同的try，catch中
 * 这样当一个close出现异常情况的时候，另一个输入输出流还能够正常的关闭
 *
 */
public class OptimizationTest {
private static int test() {
	int i=1;
	try {
		return i;
	}catch(Exception exception) {
		exception.printStackTrace();
	}
	finally {
	    i=0;
		return i;
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//System.out.println(Objects.equals('a', null));
//		String word="test";
//		switch(word) {
//		case "test":
//			System.out.println("test");
//			break;
//		}
//		System.out.println(UUID.randomUUID());
//		System.out.println(UUID.randomUUID());
		System.out.println(test());
	}

}

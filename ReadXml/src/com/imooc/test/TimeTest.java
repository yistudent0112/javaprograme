package com.imooc.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Timer;

import org.junit.jupiter.api.Test;

import com.imooc.yi.DomTest;

class TimeTest {

/*	@Test
	void test() {
		fail("Not yet implemented");
	}*/
	
	@Test
	void Domtest() {
	DomTest domtest=new DomTest();
	domtest.main(null);
	}
	
	@Test
    void Dom4jTest() {
    	com.imooc.yi.Dom4jTest dom4jTest=new com.imooc.yi.Dom4jTest();
    	dom4jTest.main(null);
    }
	
	@Test
	void JdomTest() {
		com.imooc.yi.JdomTest jdomtest=new com.imooc.yi.JdomTest();
		jdomtest.main(null);
	}
	
	@Test
	void SaxTest() {
		com.imooc.yi.SaxTest saxtest=new com.imooc.yi.SaxTest();
		saxtest.main(null);
	}
}

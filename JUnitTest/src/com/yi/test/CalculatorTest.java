package com.yi.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class CalculatorTest {
    public static Calculator c=new Calculator();
	@Test
	void testAdd() {
		c.add(2);
		c.add(2);
		assertEquals(4, c.getResult());
	}

	@Test
	void testSubtract() {
	c.subtract(2);
	assertEquals(2, c.getResult());
	}

	@Disabled
	void testMultiply() {
		c.multiply(10);
		assertEquals(20, c.getResult());
	}
  
	@Test
	void testDevide() throws Exception {
		Assertions.assertThrows(Exception.class, ()->c.devide(0));
	}

	@Test
	void testSquare() {
		fail("Not yet implemented");
	}

	@Test
	void testSquareroot() {
		assertTimeout(Duration.ofSeconds(2), () -> {
           for(;;); // Perform task that takes less than 2 minutes.
        });
		//assertTimeout(Duration.ofSeconds(1),()->c.squareroot());
	
	//c.squareroot();
	}

	@Test
	void testClear() {
		fail("Not yet implemented");
	}

	@Test
	void testMain() {
		fail("Not yet implemented");
	
	}

}

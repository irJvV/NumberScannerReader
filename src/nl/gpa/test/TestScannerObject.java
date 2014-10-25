package nl.gpa.test;

import static org.junit.Assert.*;

import java.util.concurrent.atomic.AtomicIntegerArray;

import nl.gpa.java.ValidateAccountNumber;

import org.junit.Test;

public class TestScannerObject {

	@Test
	public void testTrueValidation() {
		AtomicIntegerArray concurrentAccountArray = new AtomicIntegerArray(10);
		concurrentAccountArray.set(0, 3);
		concurrentAccountArray.set(1, 4);
		concurrentAccountArray.set(2, 5);
		concurrentAccountArray.set(3, 8);
		concurrentAccountArray.set(4, 8);
		concurrentAccountArray.set(5, 2);
		concurrentAccountArray.set(6, 8);
		concurrentAccountArray.set(7, 6);
		concurrentAccountArray.set(8, 5);
		concurrentAccountArray.set(9, 0);
		ValidateAccountNumber vn = new ValidateAccountNumber();		
		assertEquals(concurrentAccountArray.get(9),0);
		assertTrue(vn.validate(concurrentAccountArray));
		assertEquals(concurrentAccountArray.get(9),1);
	}
	
	@Test
	public void testFalseValidation() {
		AtomicIntegerArray concurrentAccountArray = new AtomicIntegerArray(10);
		concurrentAccountArray.set(0, 3);
		concurrentAccountArray.set(1, 3);
		concurrentAccountArray.set(2, 5);
		concurrentAccountArray.set(3, 8);
		concurrentAccountArray.set(4, 8);
		concurrentAccountArray.set(5, 2);
		concurrentAccountArray.set(6, 8);
		concurrentAccountArray.set(7, 6);
		concurrentAccountArray.set(8, 5);
		concurrentAccountArray.set(9, 0);
		ValidateAccountNumber vn = new ValidateAccountNumber();		
		assertEquals(concurrentAccountArray.get(9),0);
		assertTrue(!vn.validate(concurrentAccountArray));
		assertEquals(concurrentAccountArray.get(9),0);
	}

}

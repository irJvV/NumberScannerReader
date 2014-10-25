package nl.gpa.test;
import static org.junit.Assert.*;

import java.util.concurrent.atomic.AtomicIntegerArray;

import nl.gpa.java.CreateFindingString;
import nl.gpa.java.ValidateAccountNumber;

import org.junit.Test;


public class TestOutputString {

	@Test
	public void testTrueString() {
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
		CreateFindingString cfs = new CreateFindingString();
		assertEquals(cfs.findingString(concurrentAccountArray),"345882865");
	}
	
	@Test
	public void testERRString() {
		AtomicIntegerArray concurrentAccountArray = new AtomicIntegerArray(10);
		concurrentAccountArray.set(0, 4);
		concurrentAccountArray.set(1, 9);
		concurrentAccountArray.set(2, 0);
		concurrentAccountArray.set(3, 0);
		concurrentAccountArray.set(4, 6);
		concurrentAccountArray.set(5, 7);
		concurrentAccountArray.set(6, 7);
		concurrentAccountArray.set(7, 1);
		concurrentAccountArray.set(8, 5);
		concurrentAccountArray.set(9, 0);
		ValidateAccountNumber vn = new ValidateAccountNumber();		
		assertTrue(!vn.validate(concurrentAccountArray));
		assertEquals(concurrentAccountArray.get(9),0);
		CreateFindingString cfs = new CreateFindingString();
		assertEquals(cfs.findingString(concurrentAccountArray),"490067715 ERR");
	}
	
	@Test
	public void testILLString() {
		AtomicIntegerArray concurrentAccountArray = new AtomicIntegerArray(10);
		concurrentAccountArray.set(0, -19);
		concurrentAccountArray.set(1, 2);
		concurrentAccountArray.set(2, 3);
		concurrentAccountArray.set(3, 4);
		concurrentAccountArray.set(4, 5);
		concurrentAccountArray.set(5, 6);
		concurrentAccountArray.set(6, 7);
		concurrentAccountArray.set(7, 8);
		concurrentAccountArray.set(8, 9);
		concurrentAccountArray.set(9, -1);
		ValidateAccountNumber vn = new ValidateAccountNumber();		
		assertTrue(!vn.validate(concurrentAccountArray));
		assertEquals(concurrentAccountArray.get(9),-1);
		CreateFindingString cfs = new CreateFindingString();
		assertEquals(cfs.findingString(concurrentAccountArray),"?23456789 ILL");
	}

}

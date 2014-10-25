package nl.gpa.java;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class ValidateAccountNumber {
	
	public boolean validate(AtomicIntegerArray concurrentAccountArray){
		int val = (   ( concurrentAccountArray.get(8)
					+(2*concurrentAccountArray.get(7))
					+(3*concurrentAccountArray.get(6))
					+(4*concurrentAccountArray.get(5))
					+(5*concurrentAccountArray.get(4))
					+(6*concurrentAccountArray.get(3))
					+(7*concurrentAccountArray.get(2))
					+(8*concurrentAccountArray.get(1))
					+(9*concurrentAccountArray.get(0))
					)%11
		);
		if(val==0){
			concurrentAccountArray.set(9, 1);
			return true;
		}else{
			return false;
		}
		
	}

}

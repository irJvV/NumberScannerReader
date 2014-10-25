package nl.gpa.java;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class StringArrayToAccountNumberMap extends Thread {

	private String[] accountStringArray;
	private int[] accountSequence;
	private int character;
	private  AtomicIntegerArray concurrentAccountArray;
	private CountDownLatch latch;

	public StringArrayToAccountNumberMap(String[] accountStringArray) {
		this.setAccountStringArray(accountStringArray);
		this.setCharacter(0b00000000);
		this.setAccountSequence(new int[9]);
		this.setConcurrentAccountArray(new AtomicIntegerArray(10));
		this.setLatch(new CountDownLatch(9));
		this.start();
	}

	@Override
	public void run() {
		char[] lineOne = this.accountStringArray[0].toCharArray();
		char[] lineTwo = this.accountStringArray[1].toCharArray();
		char[] lineThree = this.accountStringArray[2].toCharArray();
		for (int c = 0; c < 27; c++) {
			this.setCharacter(this.getCharacter() << 1);
			if (lineOne[c] != ' ') {
				this.setCharacter(this.getCharacter() + 1);
			}
			this.setCharacter(this.getCharacter() << 1);
			if (lineTwo[c] != ' ') {
				this.setCharacter(this.getCharacter() + 1);
			}
			this.setCharacter(this.getCharacter() << 1);
			if (lineThree[c] != ' ') {
				this.setCharacter(this.getCharacter() + 1);
			}

			if ((c+1)%3==0) {

				this.accountSequence[((c+1)/3)-1]=this.getCharacter();
				new TransformFromByteToNumber(this,((c+1)/3)-1,this.getCharacter());
				// verwerken character to actual number
				this.setCharacter(0b00000000);
			}
		}
		try {
			this.latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//print out to console with ? for -NUMBER and appended with "" / "ERR"
		if(concurrentAccountArray.get(9)!=-1){
			ValidateAccountNumber vn = new ValidateAccountNumber();
			vn.validate(concurrentAccountArray);
		}
		CreateFindingString cfs = new CreateFindingString();
		System.out.println(cfs.findingString(concurrentAccountArray));
		
	}

	public String[] getAccountStringArray() {
		return accountStringArray;
	}

	public void setAccountStringArray(String[] accountStringArray) {
		this.accountStringArray = accountStringArray;
	}

	public int[] getAccountSequence() {
		return accountSequence;
	}

	public void setAccountSequence(int[] accountSequence) {
		this.accountSequence = accountSequence;
	}

	public int getCharacter() {
		return character;
	}

	public void setCharacter(int character) {
		this.character = character;
	}

	public CountDownLatch getLatch() {
		return latch;
	}

	public void setLatch(CountDownLatch latch) {
		this.latch = latch;
	}

	public AtomicIntegerArray getConcurrentAccountArray() {
		return concurrentAccountArray;
	}

	public void setConcurrentAccountArray(AtomicIntegerArray concurrentAccountArray) {
		this.concurrentAccountArray = concurrentAccountArray;
	}
}

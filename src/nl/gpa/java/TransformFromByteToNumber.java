package nl.gpa.java;

public class TransformFromByteToNumber extends Thread{
	
	private StringArrayToAccountNumberMap stringArrayToAccountNumberMap;
	private int i;
	private int character;

	public TransformFromByteToNumber(
			StringArrayToAccountNumberMap stringArrayToAccountNumberMap, int i,
			int character) {
		this.stringArrayToAccountNumberMap = stringArrayToAccountNumberMap;
		this.i = i;
		this.character = character;
		this.start();
	}

	@Override
	public void run() {
		switch(this.character){
			case 235:	this.stringArrayToAccountNumberMap.getConcurrentAccountArray().set(this.i,0);
						break;
			case 3:		this.stringArrayToAccountNumberMap.getConcurrentAccountArray().set(this.i,1);
						break;
			case 122:	this.stringArrayToAccountNumberMap.getConcurrentAccountArray().set(this.i,2);
						break;
			case 59:	this.stringArrayToAccountNumberMap.getConcurrentAccountArray().set(this.i,3);
						break;
			case 147:	this.stringArrayToAccountNumberMap.getConcurrentAccountArray().set(this.i,4);
						break;
			case 185:	this.stringArrayToAccountNumberMap.getConcurrentAccountArray().set(this.i,5);
						break;
			case 249:	this.stringArrayToAccountNumberMap.getConcurrentAccountArray().set(this.i,6);
						break;
			case 35:	this.stringArrayToAccountNumberMap.getConcurrentAccountArray().set(this.i,7);
						break;
			case 251:	this.stringArrayToAccountNumberMap.getConcurrentAccountArray().set(this.i,8);
						break;
			case 187:	this.stringArrayToAccountNumberMap.getConcurrentAccountArray().set(this.i,9);
						break;
			default:	this.stringArrayToAccountNumberMap.getConcurrentAccountArray().set(this.i,this.character*-1);
						this.stringArrayToAccountNumberMap.getConcurrentAccountArray().set(9,
								(this.stringArrayToAccountNumberMap.getConcurrentAccountArray().get(9)-1));
						break;
		}
		
		this.stringArrayToAccountNumberMap.getLatch().countDown();
	}

	public StringArrayToAccountNumberMap getStringArrayToAccountNumberMap() {
		return stringArrayToAccountNumberMap;
	}

	public void setStringArrayToAccountNumberMap(
			StringArrayToAccountNumberMap stringArrayToAccountNumberMap) {
		this.stringArrayToAccountNumberMap = stringArrayToAccountNumberMap;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getCharacter() {
		return character;
	}

	public void setCharacter(int character) {
		this.character = character;
	}

	
}

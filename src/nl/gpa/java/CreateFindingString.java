package nl.gpa.java;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class CreateFindingString {
	
	private StringBuilder findings;
	
	public CreateFindingString(){
		this.findings = new StringBuilder();
	}
	
	public String findingString(AtomicIntegerArray concurrentAccountArray){
		for(int c = 0;c<9;c++){
			if(concurrentAccountArray.get(c)>=0){
				this.findings.append(concurrentAccountArray.get(c));
			} else {
				this.findings.append("?");
			}
			
		}
		if(concurrentAccountArray.get(9)<0){
			this.findings.append(" ILL");
			PrintERRandILLToFile.saveToFile(concurrentAccountArray+"\t:\t"+findings.toString(),"ERR_ILL_1.txt");
		} else if(concurrentAccountArray.get(9)==0){
			this.findings.append(" ERR");
			PrintERRandILLToFile.saveToFile(concurrentAccountArray+"\t:\t\t"+findings.toString(),"ERR_ILL_1.txt");
		}
		PrintERRandILLToFile.saveToFile(concurrentAccountArray+"\t:\t\t"+findings.toString(),"ALL.txt");
		return findings.toString();
	}

	public StringBuilder getFindings() {
		return findings;
	}

	public void setFindings(StringBuilder findings) {
		this.findings = findings;
	}

}

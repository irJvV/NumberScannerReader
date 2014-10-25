package nl.gpa.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StartThreadPerFile extends Thread{
	
	private String processFileName;
	private File processFile;
	
	private Scanner fileScanner;
	
	private boolean recording;
	private int lineCounter;
	
	private String[] accountStringArray;
	
	private boolean lastLine;

	public StartThreadPerFile(String processFile) {
		this.setProcessFileName(processFile);
		this.setProcessFile(new File(processFile));
		this.setRecording(false);
		this.setLineCounter(0);
		this.setLastLine(false);
		this.start();
	}

	@Override
	public void run() {

		try {
			
			this.setFileScanner(new Scanner(this.getProcessFile()));
			while (this.fileScanner.hasNextLine()) {
				
				if(!this.isRecording()){
					this.setRecording(true);
					this.accountStringArray = new String[3];
				};
	            String line = fileScanner.nextLine();
	            if(!this.fileScanner.hasNextLine()){this.setLastLine(true);}
	            
	            if(line.contains("|") | line.contains("_")){
	            	this.accountStringArray[this.getLineCounter()] = line;
	            	this.setLineCounter(this.getLineCounter()+1);
	            } 
	            //watch out for empty last line of file
	            if(!(line.contains("|") | line.contains("_"))|this.isLastLine()) {
	            	//empty line with 2 of 3 lines with scanner signs
	            	if(this.getLineCounter()>=2){
	            		
	            		//if 2 lines with signs move and make first line all spaces
	            		if(this.accountStringArray[2]==null){
	            			this.accountStringArray[2] = this.accountStringArray[1];
	            			this.accountStringArray[1] = this.accountStringArray[0];
	            			this.accountStringArray[0] = "                           ";
	            		}
	            		//correct lenght if too short (missed empty space probably
	            		for(int i = 0;i<3;i++){
	            			if(this.accountStringArray[i].length()<27){
	            				for(int c = this.accountStringArray[i].length();c<27;c++){
	            					this.accountStringArray[i] = this.accountStringArray[i] + " ";
	            				}
	            			}
	            		}
	            		
	            		//correct if too long(probably extra white space on end / start
	            		for(int i = 0;i<3;i++){
	            			if(this.accountStringArray[i].length()>27){
	            				for(int c = this.accountStringArray[i].length();c>27;c--){
	            					if(this.accountStringArray[i].charAt(c - 1)== ' '){
	            						this.accountStringArray[i] = this.accountStringArray[i].substring(0, c-1);
	            					} else if(this.accountStringArray[i].charAt(0)== ' '){
	            						this.accountStringArray[i] = this.accountStringArray[i].substring(1, c);
	            					}
	            				}
	            			}
	            		}
	            		//sent Sting[] to Thread for conversion
	            		new StringArrayToAccountNumberMap(this.accountStringArray);
	            		this.setLineCounter(0);
	            		this.setRecording(false);
	            	}
	            }
	        }
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			this.fileScanner.close();
		}
	}

	public String getProcessFileName() {
		return processFileName;
	}

	public void setProcessFileName(String processFileName) {
		this.processFileName = processFileName;
	}

	public File getProcessFile() {
		return processFile;
	}

	public void setProcessFile(File processFile) {
		this.processFile = processFile;
	}

	public Scanner getFileScanner() {
		return fileScanner;
	}

	public void setFileScanner(Scanner fileScanner) {
		this.fileScanner = fileScanner;
	}

	public boolean isRecording() {
		return recording;
	}

	public void setRecording(boolean recording) {
		this.recording = recording;
	}

	public int getLineCounter() {
		return lineCounter;
	}

	public void setLineCounter(int lineCounter) {
		this.lineCounter = lineCounter;
	}

	public String[] getAccountStringArray() {
		return accountStringArray;
	}

	public void setAccountStringArray(String[] accountStringArray) {
		this.accountStringArray = accountStringArray;
	}

	public boolean isLastLine() {
		return lastLine;
	}

	public void setLastLine(boolean lastLine) {
		this.lastLine = lastLine;
	}

}

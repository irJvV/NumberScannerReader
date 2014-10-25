package nl.gpa.java;

import java.io.File;
import java.util.Scanner;

public class CheckIfFileExists {
	
	private static boolean unChecked = true;
	private static boolean existFile = true;
	private static int tries = 0;
	public static Scanner inputReader = new Scanner(System.in);
	
	public static String[] checkFiles(String[] args){
		
		if (args.length == 0) {
			CheckIfFileExists.exitProgram();
		}
		
		for(String fileName : args){
			CheckIfFileExists.testFile(fileName);
		}
		
		if(CheckIfFileExists.isExistFile()){
			CheckIfFileExists.setUnChecked(false);
		}
		
		if(CheckIfFileExists.getTries()==3 && CheckIfFileExists.isUnChecked()){
			CheckIfFileExists.exitProgram();
		} else if(!CheckIfFileExists.isUnChecked()) {CheckIfFileExists.setTries(1);}
		
		CheckIfFileExists.setTries(CheckIfFileExists.getTries()+1);
		
		return args;
	}
	
	private static void testFile(String fileName){
		File file = new File(fileName);
		if(file.exists() && CheckIfFileExists.isExistFile()){
			CheckIfFileExists.setExistFile(true);
		} else {
			CheckIfFileExists.setExistFile(false);
		}
	}
	
	public static void exitProgram(){
		System.out.println("______________________________________________________");
		System.out.println("                                                      ");
		System.out.println("------------Please try again -EXIT PROGRAM------------");
		System.out.println("______________________________________________________");
		System.out.println("                                                      ");
		System.exit(0);
	}
	
	public static void closeScanner(){
		CheckIfFileExists.inputReader.close();
	}

	public static boolean isUnChecked() {
		return unChecked;
	}

	public static void setUnChecked(boolean unChecked) {
		CheckIfFileExists.unChecked = unChecked;
	}

	public static int getTries() {
		return tries;
	}

	public static void setTries(int tries) {
		CheckIfFileExists.tries = tries;
	}

	public static boolean isExistFile() {
		return existFile;
	}

	public static void setExistFile(boolean existFile) {
		CheckIfFileExists.existFile = existFile;
	}

}

package nl.gpa.java;

public class WelcomeAndInput {
	
	public static String[] Welcome(String[] args){
	//info to client
	System.out.println("______________________________________________________");
	System.out.println("                                                      ");
	System.out.println("    Welcome to the AccountNumber Reader Software      ");
	System.out.println("______________________________________________________");
	System.out.println("                                                      ");
	//test if comandline argument else ask
	if (args.length == 0) {
		
		System.out.println("______________________________________________________");
		System.out.println("                                                      ");
		System.out.println("----------Please enter the FILE NAME to scan:---------");
		System.out.println("(to process more file enter filenames on command line)");
		System.out.println("______________________________________________________");
		System.out.println("                                                      ");
		String input = CheckIfFileExists.inputReader.nextLine();
		args = new String[1];
		args[0] = input;
	}
	return args;
	}

}

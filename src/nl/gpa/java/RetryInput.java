package nl.gpa.java;

public class RetryInput {

	public static String[] retry(String[] args) {
		System.out.println("______________________________________________________");
		System.out.println("                                                      ");
		System.out.println("----------FILE(s) do not exist, please retry:---------");
		System.out.println("______________________________________________________");
		System.out.println("                                                      ");

		String input = CheckIfFileExists.inputReader.nextLine();
		args = new String[1];
		args[0] = input;
		return args;
	}

}

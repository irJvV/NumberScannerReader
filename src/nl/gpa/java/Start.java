package nl.gpa.java;

public class Start {
	
	public static void main(String[] args) {
		//set ERROR printer to file
		SetErrorPrinter.set();
		//test if comandline argument else ask
		args = WelcomeAndInput.Welcome(args);
		while(CheckIfFileExists.isUnChecked() && CheckIfFileExists.getTries() < 3){
			//Check if file exists
			args = CheckIfFileExists.checkFiles(args);
			//If not new commanline entry (max 3 times)
			if(CheckIfFileExists.isUnChecked()){
				args = RetryInput.retry(args);
			}
		}
		CheckIfFileExists.closeScanner();

		for(String processFile : args){
			new StartThreadPerFile(processFile);
		}
	}

}

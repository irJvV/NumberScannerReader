package nl.gpa.java;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class SetErrorPrinter {
	
	public static PrintStream out;
	
	public static void set() {

		try {
			SetErrorPrinter.out = new PrintStream(new FileOutputStream("error_text.txt"));
			System.setErr(SetErrorPrinter.out);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}

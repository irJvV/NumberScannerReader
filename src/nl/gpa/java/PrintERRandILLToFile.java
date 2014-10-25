package nl.gpa.java;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintERRandILLToFile {

	public static void saveToFile(String saveText, String saveFileName) {

		try (PrintWriter out = new PrintWriter(new BufferedWriter(
				new FileWriter(saveFileName, true)))) {
			out.println(saveText);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

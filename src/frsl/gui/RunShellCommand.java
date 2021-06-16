package frsl.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RunShellCommand {	
	
	private static RunShellCommand instance = null;
	
	private RunShellCommand() {
		
	}
	
	public static RunShellCommand getInstance() {
		if(instance == null) {
			instance = new RunShellCommand();
		}
		return instance;
	}
	
	private static void printLines(String cmd, InputStream ins) throws IOException {
		String line = null;
		BufferedReader in = new BufferedReader(new InputStreamReader(ins));
		while ((line = in.readLine()) != null) {
			System.out.println(cmd + " " + line);
		}
	}

	public static void runProcess(String command) throws IOException, InterruptedException {
		Process process = Runtime.getRuntime().exec(command);
//		printLines(command + " stdout:", pro.getInputStream());
//		printLines(command + " stderr:", pro.getErrorStream());
		process.waitFor();
		System.out.println(command + " exitValue() " + process.exitValue());
	}
}

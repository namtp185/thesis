package frsl.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class IOUtil {
	public static boolean writeFile(String filePath, String str) {
		try {
			deleteIfExists(filePath);
			BufferedWriter writer;
			writer = new BufferedWriter(new FileWriter(filePath));
			writer.write(str);
			writer.close();
			return true;
		} catch (Exception e) {
//			e.printStackTrace();
			return false;
		}
	}

	public static String readFile(String filePath) {
		try {
			Scanner scanner = new Scanner(new File(filePath), "UTF-8");
			String text = scanner.useDelimiter("\\A").next();
			scanner.close();
			return text.trim();
		} catch (Exception e) {
//			e.printStackTrace();
			return null;
		}
	}

	private static void deleteIfExists(String filePath) throws IOException {
		Path pathOfFile = Paths.get(filePath);
		Files.deleteIfExists(pathOfFile);
	}

}

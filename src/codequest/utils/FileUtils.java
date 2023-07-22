package codequest.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {

	public static BufferedReader readFile(String fileName) {
		String path = Path.of(Paths.get("").toAbsolutePath().toString(), "/src/testcase", fileName).toAbsolutePath().toString();
		File file = new File(path);

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return br;

	}
}

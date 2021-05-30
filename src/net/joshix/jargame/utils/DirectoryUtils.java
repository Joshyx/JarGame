package net.joshix.jargame.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryUtils {
	public static void createFolder(String path) throws IOException {
		Path p = Paths.get(path);
		Files.createDirectories(p);
	}
	public static void deleteFolder(String path) throws IOException {
		Path p = Paths.get(path);
		Files.delete(p);
	}
	public static boolean folderExists(String path) {
		Path p = Paths.get(path);
		if(Files.exists(p)) {
			return true;
		} else {
			return false;
		}
	}

	public static String getUserPath() {
		return System.getProperty("user.home");
	}
	public static String getPicturesPath() {
		return System.getProperty("user.home") + "/Pictures";
	}
	public static String getDocumentsPath() {
		return System.getProperty("user.home") + "/Documents";
	}
	public static String getDesktopPath() {
		return System.getProperty("user.home") + "/Desktop";
	}
	public static String getProjectPath(){
		File file = new File(".");
		try {
			return file.getCanonicalPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
}

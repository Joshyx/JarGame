package net.joshix.jargame.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {
	//Creates a file
	public static void createFile(String filePath) {
		File file = new File(filePath);
		
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//Deletes a file
	public static void deleteFile(String filePath) {
		File file = new File(filePath);
		
		file.delete();
	}

	//Writes a String to a file
	public static void writeAllText(String filePath, String text) {
		try {
			File file = new File(filePath);
			if(!file.exists()) {
				file.createNewFile();
			}
			FileWriter fileWrite = new FileWriter(filePath);
			fileWrite.write(text);
			fileWrite.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Reads a String from a file
	public static String readAllText(String filePath) {
		File file = new File(filePath);
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "";
		}
		Scanner scanner = new Scanner(filePath);
		String result = scanner.next();
		scanner.close();
		
		return result;
	}
	
	//Writes a List to a file. Similiar to writeArray()
	public static void writeList(String filePath, List<String> list) {
		try {
			File file = new File(filePath);
			if(!file.exists()) {
				file.createNewFile();
			}
			FileWriter fileWrite = new FileWriter(filePath);
			for(String text : list) {
				fileWrite.append(text + "\n");
			}
			fileWrite.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Reads a List from a file. Similiar to readArray()
	public static List<String> readList(String filePath) {
		File file = new File(filePath);
		List<String> result = new ArrayList<String>();
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}
		Scanner scanner = new Scanner(filePath);
		while(scanner.hasNextLine()) {
			result.add(scanner.nextLine());
		}
		scanner.close();
		
		return result;
	}
	
	//Writes an array to a file. Similiar to writeList()
	public static void writeArray(String filePath, String... array) {
		try {
			File file = new File(filePath);
			if(!file.exists()) {
				file.createNewFile();
			}
			FileWriter fileWrite = new FileWriter(filePath);
			for(String text : array) {
				fileWrite.append(text + "\n");
			}
			fileWrite.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Reads an array from a file. Similiar to readList()
	public static String[] readArray(String filePath) {
		File file = new File(filePath);
		List<String> result = new ArrayList<String>();
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return (String[]) result.toArray();
		}
		Scanner scanner = new Scanner(filePath);
		while(scanner.hasNextLine()) {
			result.add(scanner.nextLine());
		}
		scanner.close();
	
		return (String[]) result.toArray();
	}

	//Saves a class to a file. The class must implement Serializable
	public static void writeObject(String filePath, Object obj) {
		try {
			FileOutputStream fos = new FileOutputStream(filePath);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(obj);
			fos.close();
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Loads a class from a file. The class must implement Serializable
	public static Object readObject(String filePath) {
		Object result = "";
		try {
			FileInputStream fis = new FileInputStream(filePath);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			result = ois.readObject();
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}

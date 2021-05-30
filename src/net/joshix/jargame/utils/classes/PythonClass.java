package net.joshix.jargame.utils.classes;

import java.util.List;
import java.util.Scanner;

public interface PythonClass {
	public default String str(Object obj) {
		try {
			return obj.toString();
		} catch(Exception e){
			return "" + obj;
		}
	}
	public default int Int(String s) {
		return Integer.parseInt(s);
	}
	public default double Double(String s) {
		return Double.parseDouble(s);
	}
	public default void print(String text) {
		System.out.println(text);
	}
	public default String input() {
		Scanner in = new Scanner(System.in);
		String result = in.nextLine();
		in.close();
		return result;
	}
	public default int len(Object[] array) {
		return array.length;
	}
	public default int len(List<Object> array) {
		return array.size();
	}
}

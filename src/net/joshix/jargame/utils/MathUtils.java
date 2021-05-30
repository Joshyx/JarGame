package net.joshix.jargame.utils;

import java.util.Random;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class MathUtils {
	//Adds numbers but in a different way: 1 + 64 = 164, not 1 + 64 = 65
	public static int addStupid(int i, int... is) {
		String result = "" + i;
		for(int isi : is) {
			result += isi;
		}
		return Integer.parseInt(result);
	}
	
	//Makes a number positive
	public static int Normalize(int number) {
		if(number < 0)
			number *= -1;
		
		return number;
	}
	public static double Normalize(double number) {
		if(number < 0)
			number *= -1;
		
		return number;
	}

	//Returns a random number in the given range
	public static int RandRange(int min, int max) {
		Random rand = new Random();
		return rand.nextInt(max - min) + min;
	}
	public static double RandRange(double min, double max) {
		Random rand = new Random();
		return rand.doubles(min, max).findFirst().getAsDouble();
	}

	//Evaluates a string and returns the result (like 34+234/23 = 24). Pro Tip: You can run a whole JavaScript script in here
	public static double evaluateString(String calculation) {
		ScriptEngineManager mg = new ScriptEngineManager();
		ScriptEngine engine = mg.getEngineByName("JavaScript");
		try {
			return (double) engine.eval(calculation);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
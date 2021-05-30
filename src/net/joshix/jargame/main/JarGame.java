package net.joshix.jargame.main;

import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class JarGame {
	//The current version of JarGame
	public static final String VERSION = "0.1";
	//If JarGame is currently running
	static boolean running = false;
	
	//Initializes JarGame, has to be called a the beginning of the game
	public static void init() {
		running = true;
		System.out.println("Started JarGame Version " + VERSION);
	}
	
	//Closes the Application
	public static void exit() {
		running = false;
		System.out.println("Exiting...");
		System.exit(0);
	}
	
	//Opens a URL in the user's browser
	public static void openURL(String url) {
		Desktop desktop = java.awt.Desktop.getDesktop();
		try {
			URI oURL = new URI(url);
			desktop.browse(oURL);
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}
	}
	
	//Returns true if there's a connection to the internet
	public static boolean isOnline() {
	    try {
	        final URL url = new URL("http://www.google.com");
	        final URLConnection conn = url.openConnection();
	        conn.connect();
	        conn.getInputStream().close();
	        return true;
	    } catch (MalformedURLException e) {
	        throw new RuntimeException(e);
	    } catch (IOException e) {
	        return false;
	    }
	}
	
	//Returns the locale of the PC, for example en_US or de_DE
	public static String getUserLocale() {
		String language = System.getProperty("user.language");
		String country = System.getProperty("user.country");
		return language + "_" + country;
	}
	
	//Returns the operating System, like "Windows 10"
	public static String getOperatingSystem() {
		return System.getProperty("os.name");
	}
	
	//Returns the current date and time formatted as given in the parameter.
	//Possible format values: https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
	public static String getDateTime(String format) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		LocalDateTime now = LocalDateTime.now();
		return formatter.format(now);
	}
}

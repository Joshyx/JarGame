package net.joshix.jargame.main;

import java.awt.Color;
import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;

import net.joshix.jargame.events.InputListener;
import net.joshix.jargame.visuals.Label;

public class Window {
	
	public static JFrame frame;
	static boolean created = false;
	public static Label lbl;
	
	public static void createWindow(String title) {
		showWindow(title, 1920, 1080);
	}
	
	public static void createWindow(String title, int width, int height) {
		showWindow(title, width, height);
	}
	
	private static void showWindow(String title, int width, int height) {
		if(!JarGame.running) {
			System.err.println("You must first initialize JarGame before creating a window");
			System.exit(0);
		}
		if(created) {
			System.err.println("There's already an existing window");
			return;
		}
		created = true;
		frame = new JFrame();
		frame.setSize(width, height);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLayout(null);
		frame.setTitle(title);
		frame.setResizable(false);
		frame.requestFocus();
		
		lbl = new Label();
		lbl.setBounds(0, 0, width, height);
		lbl.setVisible(true);
		frame.add(lbl);
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				lbl.repaint();
			}
		}, 0, 1);
	}
	
	public static void addButton(JButton button) {
		frame.add(button);
	}
	public static void addInputListener(InputListener listener) {
		frame.addKeyListener(listener);
		frame.addMouseListener(listener);
		frame.addMouseWheelListener(listener);
		frame.addMouseMotionListener(listener);
	}

	public static void drawRect(int x, int y, int width, int height, boolean filled) {
		if(filled) {
			lbl.fillRect(x, y, width, height);
		} else {
			lbl.drawRect(x, y, width, height);
		}
	}
	public static void drawCircle(int x, int y, int radius, boolean filled) {
		if(filled) {
			lbl.fillCircle(x, y, radius);
		} else {
			lbl.drawCircle(x, y, radius);
		}
	}
	public static void drawOval(int x, int y, int width, int height, boolean filled) {
		if(filled) {
			lbl.fillOval(x, y, width, height);
		} else {
			lbl.drawOval(x, y, width, height);
		}
	}
	public static void drawLine(int x1, int y1, int x2, int y2) {
		lbl.drawLine(x1, y1, x2, y2);
	}
	public static void drawText(String text, int x, int y, int fontsize) {
		lbl.drawText(text, x, y, fontsize);
	}
	public static void drawImage(Image img, int x, int y) {
		lbl.drawImage(img, x, y);
	}
	public static void drawImage(Image img, int x, int y, int width, int height) {
		lbl.drawImage(img, x, y, width, height);
	}
	public static void setColor(Color color) {
		lbl.setColor(color);
	}
	public static Color getColor() {
		return lbl.getColor();
	}
	public static void moveCamera(int x, int y) {
		int currentX = lbl.getX();
		int currentY = lbl.getY();
		int newX = x - currentX;
		int newY = y - currentY;
		lbl.setBounds(currentX - newX, currentY - newY, lbl.getWidth(), lbl.getHeight());
		lbl.drawRect(currentX - newX, currentY - newY, lbl.getWidth(), lbl.getHeight());
	}
	public static boolean isFocused() {
		return frame.isFocused();
	}
}

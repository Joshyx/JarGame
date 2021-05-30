package net.joshix.jargame.visuals;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.JLabel;

public class Label extends JLabel{

	private static final long serialVersionUID = 3737339829212632833L;
	
	Color color;

	public void drawRect(int x, int y, int width, int height) {
		Graphics2D g2d = (Graphics2D) getGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(color);
		g2d.drawRect(x, y, width, height);
		setColor(Color.BLACK);
	}
	public void fillRect(int x, int y, int width, int height) {
		Graphics2D g2d = (Graphics2D) getGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(color);
		g2d.fillRect(x, y, width, height);
		setColor(Color.BLACK);
	}
	public void drawCircle(int x, int y, int radius) {
		Graphics2D g2d = (Graphics2D) getGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(color);
		g2d.drawOval(x, y, radius, radius);
		setColor(Color.BLACK);
	}
	public void fillCircle(int x, int y, int radius) {
		Graphics2D g2d = (Graphics2D) getGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(color);
		g2d.fillOval(x, y, radius, radius);
		setColor(Color.BLACK);
	}
	public void drawOval(int x, int y, int width, int height) {
		Graphics2D g2d = (Graphics2D) getGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(color);
		g2d.drawOval(x, y, width, height);
		setColor(Color.BLACK);
	}
	public void fillOval(int x, int y, int width, int height) {
		Graphics2D g2d = (Graphics2D) getGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(color);
		g2d.fillOval(x, y, width, height);
		setColor(Color.BLACK);
	}
	public void drawLine(int x1, int y1, int x2, int y2) {
		Graphics2D g2d = (Graphics2D) getGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(color);
		g2d.drawLine(x1, y1, x2, y2);
		setColor(Color.BLACK);
	}
	public void drawText(String text, int x, int y, int fontsize) {
		Graphics2D g2d = (Graphics2D) getGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(color);
		g2d.setFont(new Font("Arial", Font.PLAIN, fontsize));
		g2d.drawString(text, x, y);
		setColor(Color.BLACK);
	}
	public void drawImage(Image img, int x, int y) {
		Graphics2D g2d = (Graphics2D) getGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawImage(img, x, y, null);
	}
	public void drawImage(Image img, int x, int y, int width, int height) {
		Graphics2D g2d = (Graphics2D) getGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawImage(img, x, y, width, height, null);
	}
	public void setColor(Color color) {
		Graphics2D g2d = (Graphics2D) getGraphics();
		this.color = color;
		g2d.setColor(color);
	}
	public Color getColor() {
		return color;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
}

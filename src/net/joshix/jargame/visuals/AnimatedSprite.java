package net.joshix.jargame.visuals;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import net.joshix.jargame.main.Window;

public class AnimatedSprite extends Sprite{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<BufferedImage> images = new ArrayList<>();
	int currentImage = 0;
	
	public AnimatedSprite(String[] filePaths, String tag) {
		super(filePaths[0], tag);
		for(String filePath : filePaths) {
			try {
				BufferedImage image = ImageIO.read(new File(filePath));
				images.add(image);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void next() {
		currentImage++;
		if(currentImage >= images.size()) {
			currentImage = 0;
		}
	}
	
	@Override
	public void draw() {
		if(!isActive) {
			return;
		}
		Window.drawImage(images.get(currentImage), x, y, width, height);
	}
}

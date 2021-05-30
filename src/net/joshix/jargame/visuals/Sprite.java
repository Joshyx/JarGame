package net.joshix.jargame.visuals;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import net.joshix.jargame.main.Window;

public class Sprite implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String tag;
	public BufferedImage img;
	public int x, y;
	public int width, height;
	public ColliderType colliderType = ColliderType.COLLIDABLE;
	boolean isActive;
	static List<Sprite> sprites = new ArrayList<>();
	String path;
	
	public static final int LEFT = -1;
	public static final int RIGHT = 1;
	
	public Sprite(String path, String tag) {
		this.tag = tag;
		this.isActive = true;
		this.path = path;
		try {
			img = ImageIO.read(new File(path));
		} catch(Exception e) {
			System.err.println("Image at " + path + " could not be loaded");
		}
		x = 0;
		y = 0;
		width = img.getWidth();
		height = img.getHeight();
		sprites.add(this);
	}
	
	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void movePos(int x, int y) {
		int newX = this.x + x;
		int newY = this.y + y;
		
		if(colliderType == ColliderType.COLLIDABLE) {
			for(Sprite other : sprites) {
				if (newY < other.y-other.height || newY-height > other.y) {
					newY = this.y;
				}
				if (newX+width < other.x || newX > other.x+other.width) {
					newX = this.x;
				}
			}
		}
		
		this.x = newX;
		this.y = newY;
	}
	public int[] getCenteredPos() {
		int[] result = new int[2];
		result[0] = x + width / 2;
		result[1] = y + height / 2;
		return result;
	}
	
	public void setSize(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public void setColliderType(ColliderType type) {
		colliderType = type;
	}
	
	public void setActive(boolean active) {
		isActive = active;
		if(active) {
			if(!sprites.contains(this)) {
				sprites.add(this);
			}
		} else {
			if(sprites.contains(this)) {
				sprites.remove(this);
			}
		}
	}
	
	public void flip(int lookDir) {
		if(lookDir != -1 && lookDir != 1) {
			System.err.println(lookDir + " is not a valid direction");
		}
		if(width == 0) {
			return;
		}
		if(width < 0 && lookDir == -1) {
			width = -width;
		} else if(width > 0 && lookDir == 1) {
			width = -width;
		}
	}
	
	public void draw() {
		if(!isActive) {
			return;
		}
		Window.drawImage(img, x, y, width, height);
	}
	
	public List<Sprite> getCollidingSprites() {
		List<Sprite> colliders = new ArrayList<>();
		for(Sprite sprite : sprites) {
			if(sprite == this || !sprite.isActive) {
				continue;
			}
			if(sprite.colliderType == ColliderType.DISABLED) {
				continue;
			}
			if(collidesWith(sprite)) {
				colliders.add(sprite);
			}
		}
		return colliders;
	}
	public List<Sprite> getCollidingSpritesWithTag(String tag, boolean ignoreCase) {
		List<Sprite> colliders = new ArrayList<>();
		
		for(Sprite sprite : sprites) {
			if(sprite == this || !sprite.isActive ) {
				continue;
			}
			if(sprite.colliderType == ColliderType.DISABLED) {
				continue;
			}
			if(ignoreCase) {
				if(sprite.tag.toLowerCase() != tag.toLowerCase()) {
					continue;
				}
			} else {
				if(sprite.tag != tag) {
					continue;
				}
			}
			if(collidesWith(sprite)) {
				colliders.add(sprite);
			}
		}
		return colliders;
	}
	
	public boolean collidesWith(Sprite other) {
		if(colliderType == ColliderType.DISABLED || other.colliderType == ColliderType.DISABLED) {
			return false;
		}
		if (y < other.y-other.height || y-height > other.y) {
			return false;
		}
		if (x+width < other.x || x > other.x+other.width) {
			return false;
		}
		return true;
	}

	@Override
	public boolean equals(Object other) {
		if(!(other instanceof Sprite)) {
			return false;
		}
		Sprite sprite = (Sprite) other;
		if(sprite.tag == tag) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return tag + ": " + path;
	}
}

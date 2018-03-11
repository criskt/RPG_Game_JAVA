import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class weapon {

	private String weep;
	private String name;
	private int length;
	private boolean isshow;
	
	public boolean isIsshow() {
		return isshow;
	}

	public void setIsshow(boolean isshow) {
		this.isshow = isshow;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWeep() {
		return weep;
	}

	public void setWeep(String weep) {
		this.weep = weep;
	}

	public weapon(String weep, String name) {
		super();
		this.weep = weep;
		this.name = name;
	}

	public void drew(hunter hun,Graphics g) {
		if(!isshow) return;
		//这里调用的静态数的方法为hunter，如果用hun.HUNTER_WIDTH调用不行
		int startX = hun.getX()+hunter.HUNTER_WIDTH/2;
		int startY = hun.getY()+hunter.HUNTER_HEIGHT/2;
		g.setColor(Color.WHITE);
		if(hun.getDir()==direction.RIGHT) {
			//g.drawLine(startX, startY, startX+this.length, startY);
			System.out.println(length);
			g.drawLine(startX, startY, startX+30, startY);
		} else if(hun.getDir()==direction.LEFT) { 
			g.drawLine(startX-this.length, startY, startX, startY);
		} else if(hun.getDir()==direction.UP) {
			g.drawLine(startX, startY-this.length, startX, startY);
		} else if(hun.getDir()==direction.DOWN) {
			g.drawLine(startX, startY, startX, startY+this.length);
		}
	}
	
	public Rectangle getArea(hunter hun) {
		if(!hun.isLive()|| !isshow) {
			return new Rectangle();
		}
		int startX = hun.getX()+hunter.HUNTER_WIDTH/2;
		int startY = hun.getY()+hunter.HUNTER_HEIGHT/2;
		if(hun.getDir()==direction.RIGHT)
			return new Rectangle(startX, startY, this.length, 2);
		else if(hun.getDir()==direction.DOWN) {
			return new Rectangle(startX, startY, 2, this.length);
		} else if(hun.getDir()==direction.LEFT) {
			return new Rectangle(startX-this.length, startY, this.length, 2);
		} else if(hun.getDir()==direction.UP) {
			return new Rectangle(startX, startY-this.length, 2, this.length);
		}
		return null;
	}
	public weapon() {
		super();
		isshow = false;
	}
	
	public abstract int damage(hunter hunter,enemy enemy);


}

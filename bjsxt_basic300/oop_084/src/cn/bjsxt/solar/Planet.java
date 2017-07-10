package cn.bjsxt.solar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Planet extends Star{

	double longAxis;// 长轴
	double shortAxis;// 短轴
	double speed;// 飞行速度
	Star center;//
	double degree;

	
	public Planet(Image img, double x, double y) {
		super(img, x, y);
	}

	public void draw(Graphics g) {
		g.drawImage(img, (int) x, (int) y, null);
		// 沿着椭圆轨迹飞
		move();
		drawTrace(g);
	}
	
	public void move(){
		x = (center.x+center.width/2) + longAxis*Math.cos(degree);
		y = (center.y+center.height/2)+ shortAxis*Math.sin(degree);
		degree += speed;
	}
	
	public void drawTrace(Graphics g){
		double ovalX,ovalY,ovalWidth,ovalHeight;
		
		ovalWidth = longAxis*2;
		ovalHeight = shortAxis*2;
		ovalX = (center.x+center.width/2)-longAxis;
		ovalY = (center.y+center.height/2)-shortAxis;
		
		Color c =g.getColor();
		g.setColor(Color.blue);
		g.drawOval((int)ovalX, (int)ovalY, (int)ovalWidth, (int)ovalHeight);
		g.setColor(c);
	}

	
	public Planet(Star center, String imgpath, double longAxis, double shortAxis, double speed) {
		this(imgpath, center.x + longAxis , center.y);
		this.longAxis = longAxis;
		this.shortAxis = shortAxis;
		this.speed = speed;
		this.center = center;
	}

	public Planet(String imgpath, double x, double y) {
		super(imgpath, x, y);
	}


}

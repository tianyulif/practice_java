package cn.bjsxt.solar;

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
		x = center.x + longAxis* Math.cos(degree);
		y = center.y + longAxis * Math.sin(degree);
		degree += speed;

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

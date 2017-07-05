package cn.bjsxt.solar;

import java.awt.Graphics;
import java.awt.Image;

import cn.bjsxt.util.GameUtil;

public class Star {
	
	Image img;
	double x, y;

	public void drawImage(Graphics g) {
		g.drawImage(img, (int) x, (int) y, null);
	}
	
	public Star(){
		
	}

	public Star(Image img, double x, double y) {
		this.img = img;
		this.x = x;
		this.y = y;
	}

	public Star(String imgpath,double x,double y){
		this.img = GameUtil.getImage(imgpath);
		this.x = x;
		this.y = y;
	}


}

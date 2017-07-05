package cn.bjsxt.solar;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import cn.bjsxt.util.Constant;
import cn.bjsxt.util.GameUtil;

public class SolarFrame extends JFrame{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Image bg = GameUtil.getImage("images/bg.jpg");
	
	Star sun = new Star("images/sun.jpg", Constant.GAME_WIDTH / 2, Constant.GAME_HEIGTH / 2);
	
	Planet earth = new Planet(sun, "images/Earth.jpg", 150, 100, 0.1);
	/**
	 * 加载窗体
	 */
	
	public void launchFrame(){
		setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGTH);
		setLocation(100, 100);
		setVisible(true);
		
		new PaintThread().start();// 启动重画线程
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	private double x = 100, y = 100;
	
	private double degree = 3.14 / 3;
	private double speed = 10;


	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(bg, 0, 0, null);
		sun.drawImage(g);
		earth.drawImage(g);
	}


	class PaintThread extends Thread {
		public void run() {
			while (true) {
				repaint();
				try {
					Thread.sleep(40);// 1s=1000ms
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}


	public static void main(String[] args) {
		SolarFrame gf = new SolarFrame();
		gf.launchFrame();

	}

}

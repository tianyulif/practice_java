package org.corejava.multithreaded.demo;

/**
 * 实现runnable接口实现多线程
 * @author Administrator
 *
 */
public class RunnableDemo implements Runnable{

	private Thread t;
	private String threadName;
	
	public RunnableDemo(String threadName){
		this.threadName = threadName;
		System.out.println("Creating " +  threadName);
	}
	
	@Override
	public void run() {
		System.out.println("Running " +  threadName );
		try {
			for(int i=4; i>0; i--){
				System.out.println("Thread: " + threadName + ", " + i);
	            // 让线程睡眠一会
				Thread.sleep(50);
			}
		} catch (InterruptedException e) {
			System.out.println("Thread " +  threadName + " interrupted.");
			e.printStackTrace();
		}
		System.out.println("Thread " +  threadName + " exiting.");
	}
	

	public void start(){
		System.out.println("Starting " +  threadName );
		if(t == null){
			t = new Thread(this, threadName);
			t.start();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		  RunnableDemo R1 = new RunnableDemo("Thread-1");
	      R1.start();
	      RunnableDemo R2 = new RunnableDemo("Thread-2");
	      R2.start();
	}
}

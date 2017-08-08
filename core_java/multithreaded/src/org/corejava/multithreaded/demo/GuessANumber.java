package org.corejava.multithreaded.demo;

public class GuessANumber implements Runnable{

	private int number;
	public GuessANumber(int number){
		this.number = number;
	}
	
	@Override
	public void run() {
		int counter = 0;
		int guess = 0;
		do{
			guess = (int)(Math.random()*100+1);
			System.out.println(this.number + " guesses " + guess);
			counter++;
		}while(guess != number);
		System.out.println("** Correct! " + this.number + " in " + counter + " guesses.**");
	}
	
	public static void main(String args[]){
		GuessANumber ga = new GuessANumber(5);
		ga.run();
	}

}

package com.fli.stack;

import java.util.Iterator;
import java.util.LinkedList;

public class StackX <T>{
	private int maxSize;
	private Object[] stackArray;
	private int top;
	
	public StackX(int s){
		this.maxSize = s;
		stackArray = new Object[this.maxSize];
		top = -1;
	}
	
	public int push(T t){
		stackArray[++top] = t;
		return top;
	}
	
	@SuppressWarnings("unchecked")
	public T pop(){
		return (T)stackArray[top--];
	}
	
	@SuppressWarnings("unchecked")
	public T peek(){
		return (T)stackArray[top];
	}
	
	public boolean isEmpty(){
		return top == -1;
	}
	
	public boolean isFull(){
		return top == maxSize-1;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StackX<Long> s = new StackX<Long>(5);
		System.out.println(s.push(20L));
		System.out.println(s.push(30L));
		System.out.println(s.push(40L));
		System.out.println(s.push(50L));
		System.out.println(s.push(60L));
		
		do{
			System.out.println(s.peek()+"---peek");
			System.out.println(s.pop()+"---pop");
		}while(!s.isEmpty());
		
	}

}

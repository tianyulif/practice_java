package com.fli.recursion;

public class Triangle {
	
	
	public static int TriangleNumber(int n){
		if(n==1){
			return 1;
		}else{
			System.out.print("n:"+n+"----");
			int temp = n + TriangleNumber(n-1);
			System.out.println(temp);
			return temp;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Triangle.TriangleNumber(6);
	}

}

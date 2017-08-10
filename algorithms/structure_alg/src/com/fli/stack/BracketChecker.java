package com.fli.stack;

public class BracketChecker {

	private String input;
	
	public BracketChecker(String in){
		this.input = in;
	}
	
	public void check(){
		int size = this.input.length();
		StackX<Character> stackx = new StackX<Character>(size);
		for(int i=0; i<size; i++){
			char c = input.charAt(i);
			switch (c) {
				case '{':
				case '[':
				case '(':
					stackx.push(c);
					break;
				case '}':
				case ']':
				case ')':
					if(!stackx.isEmpty()){
						char theChar = stackx.pop();
						if(c=='}'&&theChar!='{'||
							c==')'&&theChar!='('||
							c==']'&&theChar!='['){
							System.out.println("error1");
						}
					}else{
						System.out.println("error2");
					}
				default:
				break;
			}
		}
	}
	
	public static void main(String args[]){
		String in = "a{b[ddd(dfdd]}";
		BracketChecker bc = new BracketChecker(in);
		bc.check();
	}
}

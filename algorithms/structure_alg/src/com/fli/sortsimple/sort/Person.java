package com.fli.sortsimple.sort;

public class Person implements Comparable<Person>{
	private int age;
	private String name;
	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "name:"+this.name+",age:"+this.age;
	}
	@Override
	public int compareTo(Person o) {
		if(this == o){
			return 0;
		}
		if(this.age!=o.age){
			return this.age-o.age;
		}else{
			return this.name.compareTo(o.name);
		}
	}
	
	
}

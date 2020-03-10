package com.leibulei;

public class Category {
	private int age;
	private String name;
	Category(int age,String name){
		this.age=age;
		this.name=name;
	}
	class but{
		public void name(int c) {
			age=c;
			System.out.println("Êä³ö£º"+c);
		}
	}
public static void main(String[] args) {
	Category x=new Category(6, "123");
	Category.but c=x.new but();
	c.name(7);
	
}
	

}

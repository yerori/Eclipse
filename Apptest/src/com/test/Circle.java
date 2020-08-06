package com.test;

public class Circle {

	int r;
	public Circle(int r) {
		this.r=r;
	}

	public static void main(String[] args) {
		Circle c = new Circle(10);
		c.paint();

	}

	private void paint() {
		System.out.println("¹ÝÁö¸§="+r);
		
	}

}

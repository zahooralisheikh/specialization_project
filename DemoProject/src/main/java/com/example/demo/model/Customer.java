package com.example.demo.model;

public class Customer {
	private String name;
	private int age;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getAge()+" "+getName()+" ";
	}

	public Customer(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	


}

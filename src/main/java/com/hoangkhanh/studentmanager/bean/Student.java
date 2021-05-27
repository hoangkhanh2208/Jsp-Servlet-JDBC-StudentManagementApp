package com.hoangkhanh.studentmanager.bean;

public class Student {
	private int id;
	private String fullName;
	private int age;
	private String address;
	
	public Student() {	
	}
	
	public Student(String fullName, int age, String address) {
		super();
		this.fullName = fullName;
		this.age = age;
		this.address = address;
	}

	public Student(int id, String fullName, int age, String address) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.age = age;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
}

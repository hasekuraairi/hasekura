package com.example.demo;

public class TestHogeForm {

	private String name = "aaaaa";

	private Integer age = 1;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {

	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {

	}

	public String toString() {
		return "Person(Name: " + this.name + ", Age: " + this.age + ")";
	}
}
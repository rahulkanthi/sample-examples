package com.mindtree.universityMaven.entity;

public class University {
	
	private int id;
	private String name;
	
	public University() {
		super();
	}

	public University(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	

}

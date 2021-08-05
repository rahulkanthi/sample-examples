package com.mindtree.universityMaven.entity;

public class College {
	
	private String universityName;
	private int id;
	private int collegeId;
	private String name;
	private double rating;
	

	
	public College(String universityName, int id, int collegeId, String name, double rating) {
		super();
		this.universityName = universityName;
		this.id = id;
		this.collegeId = collegeId;
		this.name = name;
		this.rating = rating;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public int getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}

	public College() {
		super();
	}
	
	public College(int id, String name, double rating) {
		super();
		this.id = id;
		this.name = name;
		this.rating = rating;
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
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	

}

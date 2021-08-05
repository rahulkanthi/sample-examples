package com.mindtree.universityMaven.exception;

public class DuplicateUniversityNameException extends Exception {

	String str="Duplicate University Name";
	
	public String getMessage(){
		return str;
	}
}

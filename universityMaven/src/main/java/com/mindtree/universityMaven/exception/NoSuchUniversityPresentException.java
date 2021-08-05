package com.mindtree.universityMaven.exception;

public class NoSuchUniversityPresentException extends Exception {

	String msg = "No Such University Present Exception";

	public String getMessage() {
		return msg;
	}
}

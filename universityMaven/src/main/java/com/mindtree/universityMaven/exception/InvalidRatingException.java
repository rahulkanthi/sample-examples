package com.mindtree.universityMaven.exception;

public class InvalidRatingException extends Exception {

	String str = "Invalid Rating Exception";

	public String getMessage() {
		return str;
	}
}

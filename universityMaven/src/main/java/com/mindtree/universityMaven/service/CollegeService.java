package com.mindtree.universityMaven.service;

import java.util.ArrayList;

import com.mindtree.universityMaven.entity.College;
import com.mindtree.universityMaven.exception.UniversityServiceException;

public interface CollegeService
{
	public String insertCollege(College c) throws UniversityServiceException;
	public ArrayList<College> getAllCollege() throws UniversityServiceException;
	public ArrayList<College> getAllCollegesByUniverstiy() throws UniversityServiceException;
	public ArrayList<College> getAllCollegesByRating() throws UniversityServiceException;


}

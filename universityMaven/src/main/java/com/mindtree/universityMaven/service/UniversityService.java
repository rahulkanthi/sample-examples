package com.mindtree.universityMaven.service;

import java.util.ArrayList;

import com.mindtree.universityMaven.entity.University;
import com.mindtree.universityMaven.exception.UniversityServiceException;

public interface UniversityService {
	
	public ArrayList<University> insertUniversity(University u) throws UniversityServiceException;
	public ArrayList<University> getAllUniverSity() throws UniversityServiceException;

}

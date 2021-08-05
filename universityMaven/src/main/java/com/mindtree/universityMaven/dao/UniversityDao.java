package com.mindtree.universityMaven.dao;

import java.util.ArrayList;

import com.mindtree.universityMaven.entity.University;
import com.mindtree.universityMaven.exception.UniversityDaoException;

public interface UniversityDao {
	
	public ArrayList<University> insertUniversity(University u) throws UniversityDaoException;
	
	public ArrayList<University> getAllUniverSity() throws UniversityDaoException;
	
	

}

package com.mindtree.universityMaven.dao;

import java.util.ArrayList;

import com.mindtree.universityMaven.entity.College;
import com.mindtree.universityMaven.exception.UniversityDaoException;

public interface CollegeDao {
	
	public String insertCollege(College c) throws UniversityDaoException;
	public ArrayList<College> getAllCollege() throws UniversityDaoException;
	public ArrayList<College> getAllCollegesByUniverstiy() throws UniversityDaoException;
	
	public ArrayList<College> getAllCollegesByRating() throws UniversityDaoException;

}

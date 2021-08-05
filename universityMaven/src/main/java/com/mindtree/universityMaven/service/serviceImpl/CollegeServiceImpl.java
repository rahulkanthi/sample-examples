package com.mindtree.universityMaven.service.serviceImpl;

import java.util.ArrayList;

import com.mindtree.universityMaven.dao.CollegeDao;
import com.mindtree.universityMaven.dao.daoImpl.CollegeDaoImpl;
import com.mindtree.universityMaven.entity.College;
import com.mindtree.universityMaven.exception.UniversityDaoException;
import com.mindtree.universityMaven.exception.UniversityServiceException;
import com.mindtree.universityMaven.service.CollegeService;

public class CollegeServiceImpl implements CollegeService {

	CollegeDao cd = new CollegeDaoImpl();

	public String insertCollege(College c) throws UniversityServiceException {
		try {
			return cd.insertCollege(c);
		} catch (UniversityDaoException e) {
			throw new UniversityServiceException();
		}
	}

	public ArrayList<College> getAllCollege() throws UniversityServiceException {
		try {
			return cd.getAllCollege();
		} catch (UniversityDaoException e) {
			throw new UniversityServiceException();
		}
	}

	public ArrayList<College> getAllCollegesByUniverstiy() throws UniversityServiceException {
		try {
			return cd.getAllCollegesByUniverstiy();
		} catch (UniversityDaoException e) {
			throw new UniversityServiceException();
		}
	}

	public ArrayList<College> getAllCollegesByRating() throws UniversityServiceException {
		try {
			return cd.getAllCollegesByRating();
		} catch (UniversityDaoException e) {
			throw new UniversityServiceException();
		}
	}

	
}

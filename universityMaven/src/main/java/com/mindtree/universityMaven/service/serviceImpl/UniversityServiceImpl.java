package com.mindtree.universityMaven.service.serviceImpl;

import java.util.ArrayList;

import com.mindtree.universityMaven.dao.UniversityDao;
import com.mindtree.universityMaven.dao.daoImpl.UniversityDaoImpl;
import com.mindtree.universityMaven.entity.University;
import com.mindtree.universityMaven.exception.UniversityDaoException;
import com.mindtree.universityMaven.exception.UniversityServiceException;
import com.mindtree.universityMaven.service.UniversityService;

public class UniversityServiceImpl implements UniversityService {

	UniversityDao ud = new UniversityDaoImpl();

	public ArrayList<University> insertUniversity(University u) throws UniversityServiceException {
		try {
			return ud.insertUniversity(u);
		} catch (UniversityDaoException e) {
			throw new UniversityServiceException();
		}
	}

	public ArrayList<University> getAllUniverSity() throws UniversityServiceException {
		try {
			return ud.getAllUniverSity();
		} catch (UniversityDaoException e) {
			throw new UniversityServiceException();
		}
	}

	

}

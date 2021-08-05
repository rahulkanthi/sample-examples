package com.mindtree.universityMaven.client;

import java.util.ArrayList;

import java.util.Scanner;

import com.mindtree.universityMaven.entity.College;
import com.mindtree.universityMaven.entity.University;
import com.mindtree.universityMaven.exception.InvalidRatingException;
import com.mindtree.universityMaven.exception.UniversityApplicationException;
import com.mindtree.universityMaven.exception.UniversityServiceException;
import com.mindtree.universityMaven.service.CollegeService;
import com.mindtree.universityMaven.service.UniversityService;
import com.mindtree.universityMaven.service.serviceImpl.CollegeServiceImpl;
import com.mindtree.universityMaven.service.serviceImpl.UniversityServiceImpl;

public class UniversityApplication {

	static Scanner scan = new Scanner(System.in);
	static UniversityService universityService = new UniversityServiceImpl();
	static CollegeService collegeService = new CollegeServiceImpl();

	public static void main(String[] args) {

		int opt = 0;

		try {
			do {
				opt = displayOpt();
				switch (opt) {
				case 1:
					ArrayList<University> universityList = registerUniversity();
					for (int i = 0; i < universityList.size(); i++) {
						System.out.println("Registration Successful, University Id:" + universityList.get(i).getId()
								+ " ," + " University Name:" + universityList.get(i).getName());
					}
					break;
				case 2:
					ArrayList<University> universities = universityService.getAllUniverSity();
					System.out.println("List of Universities: ");
					System.out.println("---------------------------------");
					for (int i = 0; i < universities.size(); i++) {
						System.out.println("University Id: " + universities.get(i).getId());
						System.out.println("University Name: " + universities.get(i).getName());
						System.out.println("----------------------------------");
					}
					String msg = registerCollege();
					System.out.println(msg);
					ArrayList<College> colleges = getAllCollege();
					displayColleges(colleges);
					break;
				case 3:
					ArrayList<College> CollegeListByUniversity = getAllCollegesByUniverstiy();
					displayColleges(CollegeListByUniversity);
					break;
				case 4:
					ArrayList<College> CollegeListByRating = getAllCollegesByRating();
					displayColleges(CollegeListByRating);
					break;
				case 5:
					System.out.println("Thank You !");
					break;
				default:
					System.out.println("Invalid Choice !");
				}

				System.out.println("================================");

			} while (opt != 5);
		} catch (UniversityApplicationException e) {
			e.printStackTrace();
		}
	}

	private static ArrayList<College> getAllCollegesByRating() throws UniversityApplicationException {
		try {
			return collegeService.getAllCollegesByRating();
		} catch (UniversityServiceException e) {
			throw new UniversityApplicationException(e.getMessage());

		}
	}

	private static ArrayList<College> getAllCollegesByUniverstiy() throws UniversityApplicationException {
		try {
			return collegeService.getAllCollegesByUniverstiy();
		} catch (UniversityServiceException e) {
			throw new UniversityApplicationException(e.getMessage());

		}
	}

	private static ArrayList<College> getAllCollege() throws UniversityApplicationException {
		try {
			return collegeService.getAllCollege();
		} catch (UniversityServiceException e) {
			throw new UniversityApplicationException(e.getMessage());

		}
	}

	public static void displayColleges(ArrayList<College> al) {
		for (int i = 0; i < al.size(); i++) {
			System.out.println("UniverSity Name: " + al.get(i).getUniversityName());
			System.out.println("University ID: " + al.get(i).getId());
			System.out.println("College ID: " + al.get(i).getCollegeId());
			System.out.println("College Name: " + al.get(i).getName());
			System.out.println("College Rating: " + al.get(i).getRating());
			System.out.println("----------------------------------------");
		}
	}

	private static String registerCollege() throws UniversityApplicationException {

		System.out.println("Enter the University ID: ");
		int id = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter the College Name: ");
		String name = scan.nextLine();
		double rating = 0;
		while (true) {
			System.out.println("Enter the College Rating: ");
			rating = scan.nextDouble();
			if (rating > 0 && rating < 10) {
				break;
			} else {
				try {
					throw new InvalidRatingException();
				} catch (InvalidRatingException e) {
					System.out.println(e.getMessage());
				}
			}

		}

		College c = new College(id, name, rating);
		try {
			return collegeService.insertCollege(c);
		} catch (UniversityServiceException e) {
			throw new UniversityApplicationException(e.getMessage());

		}
	}

	private static ArrayList<University> registerUniversity() throws UniversityApplicationException {
		System.out.println("Enter the Id of University: ");
		int id = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter the Name of University: ");
		String name = scan.nextLine();
		University u = new University(id, name);
		try {
			return universityService.insertUniversity(u);
		} catch (UniversityServiceException e) {
			throw new UniversityApplicationException(e.getMessage());

		}
	}

	private static int displayOpt() {
		System.out.println("1)Create University\n" + "2)Register a College\n"
				+ "3)Display Colleges in descending order of rating by university id\n"
				+ "4)Display Colleges by rating\n" + "5)Exit");
		int opt = scan.nextInt();
		return opt;
	}

}

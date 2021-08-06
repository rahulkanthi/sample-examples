package com.mindtree.excel;

import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.mindtree.entity.Manager;

public class ManagerExcel {
	
	private static String[] columns = { "ID", "NAME", "SALARY"};
	
	public String insert(List<Manager> manager) {

		Workbook workbook = new XSSFWorkbook();

	}

}

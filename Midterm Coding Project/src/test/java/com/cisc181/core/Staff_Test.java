package com.cisc181.core;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eTitle;

public class Staff_Test {

	@BeforeClass
	public static void setup() {
	}
	
	@Test
	public void test() {
		assertEquals(1,1);
	}
	
	@Test
	public void StaffTest() throws ParseException {
		DateFormat df = new SimpleDateFormat("mm/dd/yyyy");

		String DOB1string = "01/13/1974";
		String DOB2string = "10/02/1981";
		String DOB3string = "03/24/1979";
		String DOB4string = "07/01/1964";
		String DOB5string = "12/20/1968";
		
		Date DOB1 = df.parse(DOB1string);
		Date DOB2 = df.parse(DOB2string);
		Date DOB3 = df.parse(DOB3string);
		Date DOB4 = df.parse(DOB4string);
		Date DOB5 = df.parse(DOB5string);
		
		String hire1string = "04/30/2002";
		String hire2string = "05/06/2010";
		String hire3string = "02/12/1999";
		String hire4string = "08/23/1988";
		String hire5string = "11/03/1990";
		
		Date hire1 = df.parse(hire1string);
		Date hire2 = df.parse(hire2string);
		Date hire3 = df.parse(hire3string);
		Date hire4 = df.parse(hire4string);
		Date hire5 = df.parse(hire5string);
		
		ArrayList<Staff> StaffList = new ArrayList<Staff>();

		try {
			Staff staff1 = new Staff("Norman", "Thomas", "Wilson", DOB1, "125 Rainard Ave.", "(355)-668-9870", "StorminNorman@gmail.com", "1:00-3:30", 7, 53400, hire1, eTitle.MR);
			Staff staff2 = new Staff("Madeline", "Elizabeth", "Smythe", DOB2, "344 W. Broad St.", "(355)-409-1112", "smythe@gmail.com", "2:00-4:00", 8, 67100, hire2, eTitle.MS);
			Staff staff3 = new Staff("Tilda", "Judith", "Burns", DOB3, "716 Walnut Rd.", "(355)-213-5454", "sephiroth12@gmail.com", "11:00-1:30", 4, 107000, hire3, eTitle.MRS);
			Staff staff4 = new Staff("Caldwell", "Ronald", "Hiceman", DOB4, "32 Gauss Ave.", "(355)-511-3008", "HicemanCometh@gmail.com", "1:00-2:30", 5, 78000, hire4, eTitle.MR);
			Staff staff5 = new Staff("Garett", "James", "Ulam", DOB5, "618 Yeates Rd.", "(355)-900-1334", "GUlam@gmail.com", "12:00-3:00", 6, 96400, hire5, eTitle.MR);
			StaffList.add(staff1);
			StaffList.add(staff2);
			StaffList.add(staff3);
			StaffList.add(staff4);
			StaffList.add(staff5);
		} catch (PersonException e) {
			e.printStackTrace();
		}
		
		double sum = 0;
		for (Staff staff : StaffList) {
			sum += staff.getSalary();
		}
		double avg_salary = sum / 5.0;
		
		assertTrue(avg_salary == 80380);
	}
	
	@Test
	public void PhoneNbrTest() throws ParseException {
		DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
		String DOBstring = "01/13/1974";
		Date DOB = df.parse(DOBstring);
		String hirestring = "04/30/2002";
		Date hire = df.parse(hirestring);

		boolean thrown = false;
		
		try {
			Staff staff = new Staff("Norman", "Thomas", "Wilson", DOB, "125 Rainard Ave.", "(355)6689870", "StorminNorman@gmail.com", "1:00-3:30", 7, 53400, hire, eTitle.MR);
		} catch (PersonException e) {
			thrown = true;
		}
		
		assertTrue(thrown);
	}
	
	@Test
	public void DOBTest() throws ParseException {
		DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
		String DOBstring = "01/13/1904";
		Date DOB = df.parse(DOBstring);
		String hirestring = "04/30/2002";
		Date hire = df.parse(hirestring);
		
		boolean thrown = false;
		
		try {
			Staff staff = new Staff("Norman", "Thomas", "Wilson", DOB, "125 Rainard Ave.", "(355)6689870", "StorminNorman@gmail.com", "1:00-3:30", 7, 53400, hire, eTitle.MR);
		} catch (PersonException e) {
			thrown = true;
		}
		
		assertTrue(thrown);
	}

}

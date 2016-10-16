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

import com.cisc181.eNums.eMajor;

public class Student_Test {
	
	private static ArrayList<Course> CourseRecords = new ArrayList<Course>();
	private static ArrayList<Semester> Semesters = new ArrayList<Semester>();
	private static ArrayList<Section> SectionList = new ArrayList<Section>();
	private static ArrayList<Student> StudentList = new ArrayList<Student>();

	@BeforeClass
	public static void setup() throws ParseException, PersonException {
		Course course1 = new Course("Underwater Basket Weaving", eMajor.BUSINESS);
		Course course2 = new Course("The Chemistry of Deli Meats", eMajor.CHEM);
		Course course3 = new Course("How Not to Kill Your Patients", eMajor.NURSING);
		CourseRecords.add(course1);
		CourseRecords.add(course2);
		CourseRecords.add(course3);
		
		DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
		String fallstart = "08/31/2016";
		String fallend = "12/18/2016";
		Date FallStart = df.parse(fallstart);
		Date FallEnd = df.parse(fallend);
		Semester Fall = new Semester(FallStart, FallEnd);
		String springstart = "02/07/2017";
		String springend = "05/26/2017";
		Date SpringStart = df.parse(springstart);
		Date SpringEnd = df.parse(springend);
		Semester Spring = new Semester(SpringStart, SpringEnd);
		Semesters.add(Fall);
		Semesters.add(Spring);
		
		Section section1 = new Section(course1.getCourseID(), Fall.getSemesterID(), 104);
		Section section2 = new Section(course1.getCourseID(), Spring.getSemesterID(), 104);
		Section section3 = new Section(course2.getCourseID(), Fall.getSemesterID(), 203);
		Section section4 = new Section(course2.getCourseID(), Spring.getSemesterID(), 203);
		Section section5 = new Section(course3.getCourseID(), Fall.getSemesterID(), 112);
		Section section6 = new Section(course3.getCourseID(), Spring.getSemesterID(), 112);
		SectionList.add(section1);
		SectionList.add(section2);
		SectionList.add(section3);
		SectionList.add(section4);
		SectionList.add(section5);
		SectionList.add(section6);
		
		String DOB1string = "01/13/1994";
		String DOB2string = "10/02/1995";
		String DOB3string = "03/24/1996";
		String DOB4string = "07/01/1996";
		String DOB5string = "12/20/1995";
		String DOB6string = "05/13/1994";
		String DOB7string = "12/02/1995";
		String DOB8string = "04/24/1996";
		String DOB9string = "06/01/1996";
		String DOB10string = "02/20/1995";
		Date DOB1 = df.parse(DOB1string);
		Date DOB2 = df.parse(DOB2string);
		Date DOB3 = df.parse(DOB3string);
		Date DOB4 = df.parse(DOB4string);
		Date DOB5 = df.parse(DOB5string);
		Date DOB6 = df.parse(DOB6string);
		Date DOB7 = df.parse(DOB7string);
		Date DOB8 = df.parse(DOB8string);
		Date DOB9 = df.parse(DOB9string);
		Date DOB10 = df.parse(DOB10string);
		Student student1 = new Student("Harvey", "Louis", "Epstein", DOB1, eMajor.CHEM, "123 Fake St.", "(355)-341-8873", "HarveyTheHedgehog@gmail.com");
		Student student2 = new Student("Zechariah", "Avi", "Greenberg", DOB2, eMajor.BUSINESS, "493 Artemis Ln.", "(355)-196-3757", "greenmachine33@gmail.com");
		Student student3 = new Student("Archibald", "James", "Tuttle", DOB3, eMajor.COMPSI, "305 Wensleydale Ave.", "(355)-101-2341", "kermitthehermit@gmail.com");
		Student student4 = new Student("Kerry", "Dennis", "Graham", DOB4, eMajor.NURSING, "615 Pink Lotus Dr.", "(355)-904-5521", "GrahamCracker12@gmail.com");
		Student student5 = new Student("Vernon", "Robert", "Schwartz", DOB5, eMajor.PHYSICS, "545 Tally Ho Dr.", "(355)-287-5010", "schwartz2012@gmail.com");
		Student student6 = new Student("Irina", "Margret", "Caville", DOB6, eMajor.CHEM, "577 Cherry Hill Dr.", "(355)-766-1356", "cavillecade@gmail.com");
		Student student7 = new Student("Patricia", "Anne", "Stevens", DOB7, eMajor.BUSINESS, "120 Westminster Ave.", "(355)-122-4447", "evenStevens@gmail.com");
		Student student8 = new Student("Sophia", "Marie", "Ytterberg", DOB8, eMajor.COMPSI, "702 Gilliam St.", "(355)-314-1592", "ytterbium@gmail.com");
		Student student9 = new Student("Evelyn", "Meryl", "Kroeger", DOB9, eMajor.NURSING, "144 Twelfth Ave.", "(355)-877-6851", "comedicsans@gmail.com");
		Student student10 = new Student("Sarah", "Chase", "Meridian", DOB10, eMajor.PHYSICS, "430 Jet Rd.", "(355)-616-1990", "primemeridian@gmail.com");
		StudentList.add(student1);
		StudentList.add(student2);
		StudentList.add(student3);
		StudentList.add(student4);
		StudentList.add(student5);
		StudentList.add(student6);
		StudentList.add(student7);
		StudentList.add(student8);
		StudentList.add(student9);
		StudentList.add(student10);

	}

	@Test
	public void test() {
		assertEquals(1, 1);
	}
	
	@Test
	public void StudentTest() {
		ArrayList<Enrollment> Enrollments = new ArrayList<Enrollment>();
		ArrayList<Double> StudentGrades = new ArrayList<Double>();
		ArrayList<Double> StudentGPAs = new ArrayList<Double>();
		for (Section section : SectionList) {
			for (Student student : StudentList) {
				Enrollment e = new Enrollment(section.getSectionID(), student.getStudentID());
				Enrollments.add(e);
			}
		}
		for (int i = 0; i < 60; i++) {
			Enrollments.get(i).setGrade(100.0 - 0.75 * (double) i); 
		}
		for (int i = 0; i < 10; i++) {
			double gradesum = 0;
			for (int j = 0; j < 6; j++) {
				gradesum += Enrollments.get(i + 10 * j).getGrade();
			}
			StudentGrades.add((double) gradesum / 6.0);
		}
		for (double grade : StudentGrades) {
			if (grade >= 90) {
				StudentGPAs.add(4.0);
			}
			else if (grade >= 80) {
				StudentGPAs.add(3.0 + (grade - 80) / 10.0);
			}
			else if (grade >= 70) {
				StudentGPAs.add(2.0 + (grade - 70) / 10.0);
			}
			else if (grade >= 60) {
				StudentGPAs.add(1.0 + (grade - 60) / 10.0);
			}
			else {
				StudentGPAs.add(0.0 + grade / 60.0);
			}
		}
		
		assertTrue(StudentGrades.get(0) == 81.25);
		assertTrue(StudentGrades.get(1) == 80.5);
		assertTrue(StudentGrades.get(2) == 79.75);
		assertTrue(StudentGrades.get(3) == 79.0);
		assertTrue(StudentGrades.get(4) == 78.25);
		assertTrue(StudentGrades.get(5) == 77.5);
		assertTrue(StudentGrades.get(6) == 76.75);
		assertTrue(StudentGrades.get(7) == 76.0);
		assertTrue(StudentGrades.get(8) == 75.25);
		assertTrue(StudentGrades.get(9) == 74.5);

		assertTrue(StudentGPAs.get(0) == 3.125);
		assertTrue(StudentGPAs.get(1) == 3.05);
		assertTrue(StudentGPAs.get(2) == 2.975);
		assertTrue(StudentGPAs.get(3) == 2.9);
		assertTrue(StudentGPAs.get(4) == 2.825);
		assertTrue(StudentGPAs.get(5) == 2.75);
		assertTrue(StudentGPAs.get(6) == 2.675);
		assertTrue(StudentGPAs.get(7) == 2.6);
		assertTrue(StudentGPAs.get(8) == 2.525);
		assertTrue(StudentGPAs.get(9) == 2.45);
		
		assertTrue(StudentList.get(7).getMajor() == eMajor.COMPSI);
		StudentList.get(7).setMajor(eMajor.PHYSICS);
		assertTrue(StudentList.get(7).getMajor() == eMajor.PHYSICS);

	}
}
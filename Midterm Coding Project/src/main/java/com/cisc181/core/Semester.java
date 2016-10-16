package com.cisc181.core;

import java.util.Date;
import java.util.UUID;

public class Semester {
	
	private UUID SemesterID;
	private Date StartDate;
	private Date EndDate;

	public Semester(Date StartDate, Date EndDate) {
		this.SemesterID = UUID.randomUUID();
		this.StartDate = StartDate;
		this.EndDate = EndDate;
	}

	public UUID getSemesterID() {
		return SemesterID;
	}

	public Date getStartDate() {
		return StartDate;
	}

	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}

	public Date getEndDate() {
		return EndDate;
	}

	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}
	
	
}

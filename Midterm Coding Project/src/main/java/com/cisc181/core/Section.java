package com.cisc181.core;
import java.util.UUID;

public class Section {
	
	private UUID CourseID;
	private UUID SemesterID;
	private UUID SectionID;
	private int RoomID;
	
	public Section(UUID CourseID, UUID SemesterID, int RoomID) {
		this.SectionID = UUID.randomUUID();
		this.CourseID = CourseID;
		this.SemesterID = SemesterID;
		this.RoomID = RoomID;
	}

	public UUID getCourseID() {
		return CourseID;
	}

	public UUID getSemesterID() {
		return SemesterID;
	}

	public void setSemesterID(UUID semesterID) {
		SemesterID = semesterID;
	}

	public UUID getSectionID() {
		return SectionID;
	}

	public void setSectionID(UUID sectionID) {
		SectionID = sectionID;
	}

	public int getRoomID() {
		return RoomID;
	}

	public void setRoomID(int roomID) {
		RoomID = roomID;
	}
	
}

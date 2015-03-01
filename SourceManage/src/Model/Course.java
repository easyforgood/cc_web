package Model;

import java.util.Date;

public class Course {

	public Course(String course_Name, String course_term) {
		super();
		Course_Name = course_Name;
		Course_term = course_term;
	}

	private String Course_Name;
	private String Course_term;
	private int Course_Tag;

	public int getCourse_ID() {
		return Course_ID;
	}

	public void setCourse_ID(int course_ID) {
		Course_ID = course_ID;
	}

	private int Course_ID;

	public int getCourse_Tag() {
		return Course_Tag;
	}

	public void setCourse_Tag(int course_Tag) {
		Course_Tag = course_Tag;
	}

	public Course() {
		super();
	}

	public String getCourse_Name() {
		return Course_Name;
	}

	public void setCourse_Name(String course_Name) {
		Course_Name = course_Name;
	}

	public String getCourse_term() {
		return Course_term;
	}

	public void setCourse_term(String course_term) {
		Course_term = course_term;
	}

}

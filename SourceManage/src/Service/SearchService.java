package Service;

import java.sql.Connection;
import java.util.ArrayList;

import util.DBConnection;
import DAOImpl.SourceSearchDao;
import DBAccess.DBAccess;
import Model.Course;
import Model.FileOfCourse;
import Model.Source;

//���ڲ���
public class SearchService {

	public SearchService() {

	}

	public Course getCourse(String name, String term) {
		Connection conn =DBAccess.getConnection();
		Course course = new Course();
		SourceSearchDao s = new SourceSearchDao();
		course = s.getCourse(name, term, conn);
		return course;
	}

	public Course getCoursebyId(int id) {
		Connection conn =DBAccess.getConnection();
		Course course = new Course();
		SourceSearchDao s = new SourceSearchDao();
		course = s.getCoursebyId(id, conn);
		return course;
	}

	public ArrayList<Course> searchbynamegetcourselist(String name) {
		Connection conn = DBAccess.getConnection();
		ArrayList<Course> courselist = new ArrayList<Course>();
		SourceSearchDao s = new SourceSearchDao();
		courselist = s.bynamegetcourselist(name, conn);
		return courselist;
	}

	public ArrayList<FileOfCourse> searchbynamegetfilelist(String name) {
		Connection conn = DBAccess.getConnection();
		ArrayList<FileOfCourse> filelist = new ArrayList<FileOfCourse>();
		SourceSearchDao s = new SourceSearchDao();
		filelist = s.bynamegetfilelist(name, conn);
		return filelist;
	}

	public ArrayList<FileOfCourse> getFiles(int course_id) {
		Connection conn = DBAccess.getConnection();
		ArrayList<FileOfCourse> filelist = new ArrayList<FileOfCourse>();
		SourceSearchDao ss = new SourceSearchDao();
		filelist = ss.getFiles(course_id, conn);
		return filelist;
	}

	public FileOfCourse getFile(int file_id) {
		Connection conn = DBAccess.getConnection();
		FileOfCourse file = new FileOfCourse();
		SourceSearchDao ss = new SourceSearchDao();
		file = ss.getFile(file_id, conn);
		return file;
	}
}

package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Course;
import Model.FileOfCourse;
import Model.Source;

public class SourceSearchDao {

	public Course getCourse(String course_name, String course_term,
			Connection conn) {
		Course course = new Course();
		String sql = "SELECT * FROM course	WHERE Course_Name= ? and Course_Term=?";
		ResultSet rs;
		try {
			PreparedStatement pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, course_name);
			pStatement.setString(2, course_term);
			rs = pStatement.executeQuery();
			while (rs.next()) {
				if (rs.getInt(4) != 0) {
					course.setCourse_ID(rs.getInt(1));
					course.setCourse_Name(rs.getString(2));
					course.setCourse_term(rs.getString(3));
				}
			}
			if (pStatement != null)
				pStatement.close();

		} catch (SQLException e) {

		}
		return course;
	}

	public Course getCoursebyId(int id, Connection conn) {
		Course course = new Course();
		String sql = "SELECT * FROM course	WHERE Course_ID= ?";
		ResultSet rs;
		try {
			PreparedStatement pStatement = conn.prepareStatement(sql);
			pStatement.setInt(1, id);
			rs = pStatement.executeQuery();
			while (rs.next()) {
				if (rs.getInt(4) != 0) {
					course.setCourse_ID(rs.getInt(1));
					course.setCourse_Name(rs.getString(2));
					course.setCourse_term(rs.getString(3));
				}
			}
			if (pStatement != null)
				pStatement.close();

		} catch (SQLException e) {

		}
		return course;
	}

	// 得到搜索后的一个course列表
	public ArrayList<Course> bynamegetcourselist(String SearchString,
			Connection conn) {
		ArrayList<Course> list = new ArrayList<Course>();
		String sql = "SELECT * FROM course WHERE Course_Name like '%" + ""
				+ SearchString + "" + "%'";

		System.out.println(sql);
		ResultSet rs;
		try {
			PreparedStatement pStatement = conn.prepareStatement(sql);
			// pStatement.setString(1, SearchString);
			rs = pStatement.executeQuery();
			while (rs.next()) {
				if (rs.getInt(4) != 0) {
					Course course = new Course();
					course.setCourse_ID(rs.getInt(1));
					System.out.println("!!!!!" + course.getCourse_ID());
					course.setCourse_Name(rs.getString(2));
					System.out.println("!!!!!" + course.getCourse_Name());
					course.setCourse_term(rs.getString(3));
					System.out.println("!!!!!" + course.getCourse_term());
					list.add(course);
				}
			}
			if (pStatement != null)
				pStatement.close();
		} catch (SQLException e) {
			System.out.println("search course failed");
		}
		return list;
	}

	// 得到搜索后的一个fileofcourse列表
	public ArrayList<FileOfCourse> bynamegetfilelist(String SearchString,
			Connection conn) {
		ArrayList<FileOfCourse> list = new ArrayList<FileOfCourse>();
		String sql = "SELECT * FROM file ";
		FileOfCourse file = new FileOfCourse();
		ResultSet rs;
		
			PreparedStatement pStatement;
			try {
				pStatement = conn.prepareStatement(sql);
		
			// pStatement.setString(1, SearchString);
			rs = pStatement.executeQuery();
			while (rs.next()) {
				if (rs.getInt("file_tag") != 0) {
					file.setFile_id(rs.getInt("file_id"));
					file.setFile_name(rs.getString("file_name"));
					file.setFile_size(rs.getInt("file_size"));
					file.setFile_path(rs.getString("file_path"));
					file.setFile_DateTime(rs.getString("file_datetime"));
					file.setFile_type(rs.getString("file_type"));
					file.setFile_term_year(rs.getString("file_term_year"));
					file.setFilecomment(rs.getString("filecomment"));
					file.setCourse_id(rs.getInt("course_id"));
					list.add(file);
				}
			}
			if (pStatement != null)
				pStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return list;
	}

	// 得到一个course对应的所有file
	public ArrayList<FileOfCourse> getFiles(int course_id, Connection conn) {
		ArrayList<FileOfCourse> list = new ArrayList<FileOfCourse>();
		String sql = "SELECT * FROM file WHERE Course_ID = " + course_id
				+ " and File_Tag = 1";
		ResultSet rs;
		FileOfCourse file = new FileOfCourse();
		try {
			PreparedStatement pStatement = conn.prepareStatement(sql);
			rs = pStatement.executeQuery();
			while (rs.next()) {

				file.setFile_name(rs.getString(2));
				file.setFile_DateTime(rs.getString(5));
				file.setFile_term_year(rs.getString(7));
				file.setFile_id(rs.getInt(1));
				file.setCourse_id(rs.getInt(10));
				// System.out.println(rs.getString(1));
				// System.out.println(file.getFile_name());
				// System.out.println(file.getFile_DateTime());
				// System.out.println(file.getFile_Term_Year());
				// System.out.println(file.getFile_ID());
				// System.out.println(file.getCourse_ID());
				list.add(file);
			}
			if (pStatement != null)
				pStatement.close();
		} catch (SQLException e) {
			System.out.println("failed");
		}
		return list;
	}

	// 得到一个fileofCourse文件
	public FileOfCourse getFile(int file_ID, Connection conn) {
		FileOfCourse file = new FileOfCourse();
		String sql = "SELECT * FROM file WHERE File_ID= " + file_ID;
		ResultSet rs;
		try {
			PreparedStatement pStatement = conn.prepareStatement(sql);
			rs = pStatement.executeQuery();
			while (rs.next()) {
				file.setFile_id(rs.getInt(1));
				file.setFile_name(rs.getString(2));
				file.setFile_size(rs.getInt(3));
				file.setFile_path(rs.getString(4));
				file.setFile_DateTime(rs.getString(5));
				file.setFile_type(rs.getString(6));
				file.setFile_term_year(rs.getString(7));
				file.setFilecomment(rs.getString(8));
				file.setCourse_id(rs.getInt(10));
			}
			if (pStatement != null)
				pStatement.close();

		} catch (SQLException e) {
			System.out.println("get file failed");
		}
		return file;
	}
}

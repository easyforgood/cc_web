package Model;

public class FileOfCourse {
	private int File_ID;
	private String File_name;
	private int File_Size;
	private String File_Path;
	private String File_DateTime;
	private String File_Type;
	private String File_Term_Year;
	private int FileComment;
	private int tag; // 1´æÔÚ 0É¾³ý
	private int Course_ID;

	public int getFile_ID() {
		return File_ID;
	}

	public void setFile_ID(int file_ID) {
		File_ID = file_ID;
	}

	public int getCourse_ID() {
		return Course_ID;
	}

	public void setCourse_ID(int course_ID) {
		Course_ID = course_ID;
	}

	public FileOfCourse(String file_name, int file_Size, String file_Path,
			String file_DateTime, String file_Type, String file_Term_Year,
			int fileComment, int tag) {
		File_name = file_name;
		File_Size = file_Size;
		File_Path = file_Path;
		File_DateTime = file_DateTime;
		File_Type = file_Type;
		File_Term_Year = file_Term_Year;
		FileComment = fileComment;
		this.tag = tag;
	}

	public FileOfCourse() {

	}

	public String getFile_name() {
		return File_name;
	}

	public void setFile_name(String file_name) {
		File_name = file_name;
	}

	public int getFile_Size() {
		return File_Size;
	}

	public void setFile_Size(int file_Size) {
		File_Size = file_Size;
	}

	public String getFile_Path() {
		return File_Path;
	}

	public void setFile_Path(String file_Path) {
		File_Path = file_Path;
	}

	public String getFile_DateTime() {
		return File_DateTime;
	}

	public void setFile_DateTime(String file_DateTime) {
		File_DateTime = file_DateTime;
	}

	public String getFile_Type() {
		return File_Type;
	}

	public void setFile_Type(String file_Type) {
		File_Type = file_Type;
	}

	public String getFile_Term_Year() {
		return File_Term_Year;
	}

	public void setFile_Term_Year(String file_Term_Year) {
		File_Term_Year = file_Term_Year;
	}

	public int getFileComment() {
		return FileComment;
	}

	public void setFileComment(int fileComment) {
		FileComment = fileComment;
	}

	public int getTag() {
		return tag;
	}

	public void setTag(int tag) {
		this.tag = tag;
	}

}

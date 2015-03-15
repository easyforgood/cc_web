package Model;

public class FileOfCourse {
	private int file_id;
	/** 
	
	 * @return file_id 
	
	 */
	public int getFile_id() {
		return file_id;
	}
	/** 
	
	 * @param file_id 要设置的 file_id 
	
	 */
	public void setFile_id(int file_id) {
		this.file_id = file_id;
	}
	/** 
	
	 * @return file_name 
	
	 */
	public String getFile_name() {
		return file_name;
	}
	/** 
	
	 * @param file_name 要设置的 file_name 
	
	 */
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	/** 
	
	 * @return file_size 
	
	 */
	public int getFile_size() {
		return file_size;
	}
	/** 
	
	 * @param file_size 要设置的 file_size 
	
	 */
	public void setFile_size(int file_size) {
		this.file_size = file_size;
	}
	/** 
	
	 * @return file_path 
	
	 */
	public String getFile_path() {
		return file_path;
	}
	/** 
	
	 * @param file_path 要设置的 file_path 
	
	 */
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	/** 
	
	 * @return file_DateTime 
	
	 */
	public String getFile_DateTime() {
		return file_DateTime;
	}
	/** 
	
	 * @param file_DateTime 要设置的 file_DateTime 
	
	 */
	public void setFile_DateTime(String file_DateTime) {
		this.file_DateTime = file_DateTime;
	}
	/** 
	
	 * @return file_type 
	
	 */
	public String getFile_type() {
		return file_type;
	}
	/** 
	
	 * @param file_type 要设置的 file_type 
	
	 */
	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}
	/** 
	
	 * @return file_term_year 
	
	 */
	public String getFile_term_year() {
		return file_term_year;
	}
	/** 
	
	 * @param file_term_year 要设置的 file_term_year 
	
	 */
	public void setFile_term_year(String file_term_year) {
		this.file_term_year = file_term_year;
	}
	/** 
	
	 * @return filecomment 
	
	 */
	public String getFilecomment() {
		return filecomment;
	}
	/** 
	
	 * @param filecomment 要设置的 filecomment 
	
	 */
	public void setFilecomment(String filecomment) {
		this.filecomment = filecomment;
	}
	/** 
	
	 * @return tag 
	
	 */
	public int getTag() {
		return tag;
	}
	/** 
	
	 * @param tag 要设置的 tag 
	
	 */
	public void setTag(int tag) {
		this.tag = tag;
	}
	/** 
	
	 * @return course_id 
	
	 */
	public int getCourse_id() {
		return course_id;
	}
	/** 
	
	 * @param course_id 要设置的 course_id 
	
	 */
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	private String file_name;
	private int file_size;
	private String file_path;
	private String file_DateTime;
	private String file_type;
	private String file_term_year;
	private String filecomment;
	private int tag; // 1存在 0删除
	private int course_id;


}

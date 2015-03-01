/**    
* @Title: Px_Course.java  
* @Package Model  
* @Description: TODO(用一句话描述该文件做什么)  
* @author Siplexy easyforgood@hotmail.com   
* @date 2015年1月6日 下午10:15:52  
* @version V1.0    
*/
package Model;

/**  
 * @ClassName: Px_Course  
 * @Description: TODO(课程)  
 * @author Siplexy easyforgood@hotmail.com
 * @date 2015年1月6日 下午10:15:52  
 *    
 */
public class Px_Course {
	
	/**  
	* @Fields Course_Id : TODO(课程id)  ?自动生成 
	*/  
	private long course_id;
	/**  
	* @Fields course_Name : TODO(课程名称)  
	*/  
	private String course_name;
	/**  
	* @Fields course_term : TODO(课程学期)  
	*/  
	private String Course_term;
	/**  
	* @Fields Course_Info : TODO(课程信息)  
	*/  
	private String course_info;
	/**  
	* @Fields Course_Jeishu : TODO(课程结束时间)  
	*/  
	private String course_jieshu;
	/** 
	
	 * @return course_jieshu 
	
	 */
	public String getCourse_jieshu() {
		return course_jieshu;
	}
	/** 
	
	 * @param course_jieshu 要设置的 course_jieshu 
	
	 */
	public void setCourse_jieshu(String course_jieshu) {
		this.course_jieshu = course_jieshu;
	}
	/**  
	* @Fields Course_Week : TODO(课程周数)  
	*/  
	private String course_week;
	/** 
	
	 * @return course_id 
	
	 */
	public long getCourse_id() {
		return course_id;
	}
	/** 
	
	 * @param course_id 要设置的 course_id 
	
	 */
	public void setCourse_id(long course_id) {
		this.course_id = course_id;
	}
	/** 
	
	 * @return course_name 
	
	 */
	public String getCourse_name() {
		return course_name;
	}
	/** 
	
	 * @param course_name 要设置的 course_name 
	
	 */
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	/** 
	
	 * @return course_term 
	
	 */
	public String getCourse_term() {
		return Course_term;
	}
	/** 
	
	 * @param course_term 要设置的 course_term 
	
	 */
	public void setCourse_term(String course_term) {
		Course_term = course_term;
	}
	/** 
	
	 * @return course_info 
	
	 */
	public String getCourse_info() {
		return course_info;
	}
	/** 
	
	 * @param course_info 要设置的 course_info 
	
	 */
	public void setCourse_info(String course_info) {
		this.course_info = course_info;
	}
	/** 
	
	 * @return course_week 
	
	 */
	public String getCourse_week() {
		return course_week;
	}
	/** 
	
	 * @param course_week 要设置的 course_week 
	
	 */
	public void setCourse_week(String course_week) {
		this.course_week = course_week;
	}
	
}

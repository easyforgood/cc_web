/**    
* @Title: Px_User.java  
* @Package Model  
* @Description: TODO(用一句话描述该文件做什么)  
* @author Siplexy easyforgood@hotmail.com   
* @date 2015年3月1日 下午10:49:11  
* @version V1.0    
*/
package Model;

/**  
 * @ClassName: Px_User  
 * @Description: TODO(todowhat)  
 * @author Siplexy easyforgood@hotmail.com
 * @date 2015年3月1日 下午10:49:11  
 *    
 */
public class Px_UserCourse {
	private String user_email;
	private Long course_id;
	/** 
	
	 * @return user_email 
	
	 */
	public String getUser_email() {
		return user_email;
	}
	/** 
	
	 * @param user_email 要设置的 user_email 
	
	 */
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	/** 
	
	 * @return course_id 
	
	 */
	public Long getCourse_id() {
		return course_id;
	}
	/** 
	
	 * @param course_id 要设置的 course_id 
	
	 */
	public void setCourse_id(Long course_id) {
		this.course_id = course_id;
	}
}

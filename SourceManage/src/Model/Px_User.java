/**    
* @Title: Px_User.java  
* @Package Model  
* @Description: TODO(��һ�仰�������ļ���ʲô)  
* @author Siplexy easyforgood@hotmail.com   
* @date 2015��3��2�� ����10:10:09  
* @version V1.0    
*/
package Model;

/**  
 * @ClassName: Px_User  
 * @Description: TODO(todowhat)  
 * @author Siplexy easyforgood@hotmail.com
 * @date 2015��3��2�� ����10:10:09  
 *    
 */
public class Px_User {
	String user_name;
	String user_password;
	String user_email;
	Px_UserNickName nickname;
	Px_UserRank rank;
	/** 
	
	 * @return user_name 
	
	 */
	public String getUser_name() {
		return user_name;
	}
	/** 
	
	 * @param user_name Ҫ���õ� user_name 
	
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	/** 
	
	 * @return user_password 
	
	 */
	public String getUser_password() {
		return user_password;
	}
	/** 
	
	 * @param user_password Ҫ���õ� user_password 
	
	 */
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	/** 
	
	 * @return user_email 
	
	 */
	public String getUser_email() {
		return user_email;
	}
	/** 
	
	 * @param user_email Ҫ���õ� user_email 
	
	 */
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	/** 
	
	 * @return nickname 
	
	 */
	public Px_UserNickName getNickname() {
		return nickname;
	}
	/** 
	
	 * @param nickname Ҫ���õ� nickname 
	
	 */
	public void setNickname(Px_UserNickName nickname) {
		this.nickname = nickname;
	}
	/** 
	
	 * @return rank 
	
	 */
	public Px_UserRank getRank() {
		return rank;
	}
	/** 
	
	 * @param rank Ҫ���õ� rank 
	
	 */
	public void setRank(Px_UserRank rank) {
		this.rank = rank;
	}
}

/**    
* @Title: CourseDAO.java  
* @Package Dao  
* @Description: TODO(用一句话描述该文件做什么)  
* @author Siplexy easyforgood@hotmail.com   
* @date 2015年1月6日 下午10:21:45  
* @version V1.0    
*/
package Dao;

import java.util.List;

import Model.Px_Course;

/**  
 * @ClassName: CourseDAO  
 * @Description: TODO(这里用一句话描述这个类的作用)  
 * @author Siplexy easyforgood@hotmail.com
 * @date 2015年1月6日 下午10:21:45  
 *    
 */
public interface Px_CourseDAO {
	public boolean saveCourse(Px_Course course);
	public Px_Course queryCourse(Long course_id);
	public boolean removeCourse(Long course_id);
	public boolean updateCourse(Px_Course course);
	public List<Px_Course> queryAll() ;
}

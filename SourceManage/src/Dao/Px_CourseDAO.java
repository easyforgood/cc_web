/**    
* @Title: CourseDAO.java  
* @Package Dao  
* @Description: TODO(��һ�仰�������ļ���ʲô)  
* @author Siplexy easyforgood@hotmail.com   
* @date 2015��1��6�� ����10:21:45  
* @version V1.0    
*/
package Dao;

import java.util.List;

import Model.Px_Course;

/**  
 * @ClassName: CourseDAO  
 * @Description: TODO(������һ�仰��������������)  
 * @author Siplexy easyforgood@hotmail.com
 * @date 2015��1��6�� ����10:21:45  
 *    
 */
public interface Px_CourseDAO {
	public boolean saveCourse(Px_Course course);
	public Px_Course queryCourse(Long course_id);
	public boolean removeCourse(Long course_id);
	public boolean updateCourse(Px_Course course);
	public List<Px_Course> queryAll() ;
}

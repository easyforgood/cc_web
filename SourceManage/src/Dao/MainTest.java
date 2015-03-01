/**    
* @Title: MainTest.java  
* @Package Dao  
* @Description: TODO(用一句话描述该文件做什么)  
* @author Siplexy easyforgood@hotmail.com   
* @date 2015年1月5日 下午9:00:45  
* @version V1.0    
*/
package Dao;

import DAOImpl.Px_CourseDAOImpl;
import Model.Px_Course;

/**  
 * @ClassName: MainTest  
 * @Description: TODO(用来测试DAO的数据库连接是否正常)  
 * @author Siplexy easyforgood@hotmail.com
 * @date 2015年1月5日 下午9:00:45  
 *    
 */
public class MainTest {
	public static void main(String args[]){
		Px_Course course=new Px_Course();
		/*course.setCourse_Id(4);
		course.setCourse_Info("嵌入式操作系统技术是目前电子产品设计领域最为热门的技术之一。本课程的特点是针对目前流行的基于ARM架构的嵌入式微处理器与linux操作系统进行详细分析，并结合具体嵌入式操作系统开发实验，使学生能够掌握嵌入式操作系统的开发方法，并了解操作系统的原理，为进一步学习或者工作打下良好的基础。");
		course.setCourse_Jeishu("20周");
		course.setCourse_Name("嵌入式操作系统");
		course.setCourse_Term("2014-2015上学期");
		course.setCourse_Week("10周");*/
		Px_CourseDAO dao=new Px_CourseDAOImpl();
		dao.saveCourse(course);
	}
}

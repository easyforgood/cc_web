/**    
* @Title: MainTest.java  
* @Package Dao  
* @Description: TODO(��һ�仰�������ļ���ʲô)  
* @author Siplexy easyforgood@hotmail.com   
* @date 2015��1��5�� ����9:00:45  
* @version V1.0    
*/
package Dao;

import DAOImpl.Px_CourseDAOImpl;
import Model.Px_Course;

/**  
 * @ClassName: MainTest  
 * @Description: TODO(��������DAO�����ݿ������Ƿ�����)  
 * @author Siplexy easyforgood@hotmail.com
 * @date 2015��1��5�� ����9:00:45  
 *    
 */
public class MainTest {
	public static void main(String args[]){
		Px_Course course=new Px_Course();
		/*course.setCourse_Id(4);
		course.setCourse_Info("Ƕ��ʽ����ϵͳ������Ŀǰ���Ӳ�Ʒ���������Ϊ���ŵļ���֮һ�����γ̵��ص������Ŀǰ���еĻ���ARM�ܹ���Ƕ��ʽ΢��������linux����ϵͳ������ϸ����������Ͼ���Ƕ��ʽ����ϵͳ����ʵ�飬ʹѧ���ܹ�����Ƕ��ʽ����ϵͳ�Ŀ������������˽����ϵͳ��ԭ��Ϊ��һ��ѧϰ���߹����������õĻ�����");
		course.setCourse_Jeishu("20��");
		course.setCourse_Name("Ƕ��ʽ����ϵͳ");
		course.setCourse_Term("2014-2015��ѧ��");
		course.setCourse_Week("10��");*/
		Px_CourseDAO dao=new Px_CourseDAOImpl();
		dao.saveCourse(course);
	}
}

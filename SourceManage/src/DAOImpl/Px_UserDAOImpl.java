/**    
* @Title: Px_UserDAOImpl.java  
* @Package DAOImpl  
* @Description: TODO(��һ�仰�������ļ���ʲô)  
* @author Siplexy easyforgood@hotmail.com   
* @date 2015��3��2�� ����10:09:48  
* @version V1.0    
*/
package DAOImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import DBAccess.DBAccess;
import Dao.Px_UserDAO;
import Model.Px_User;
import Model.Px_UserNickName;
import Model.Px_UserRank;

import com.mysql.jdbc.Statement;

/**  
 * @ClassName: Px_UserDAOImpl  
 * @Description: TODO(todowhat)  
 * @author Siplexy easyforgood@hotmail.com
 * @date 2015��3��2�� ����10:09:48  
 *    
 */
public class Px_UserDAOImpl implements Px_UserDAO{
	
	/** 
	
	* @Title: queryAll 
	
	* @Description: TODO(todowhat) 
	
	* @param @return    ���� 
	
	* @return ResultSet    �������� 
	
	* @throws 
	
	*/ 
	public List<Px_User> queryAll(){
		Connection conn=DBAccess.getConnection();
		List<Px_User> list=null;
		ResultSet rs =null;
		String sql="select user_name,user_password,user_email,"
				+ "usernickname.nick_id,usernickname.nickname,userrank.rank_id,userrank.rank_name"
				+ " from user left join usernickname on user.nick_id = usernickname.nick_id  "
				+ "left join userrank on user.rank_id =userrank.rank_id";
		System.out.println(sql);
		try {
			Statement stmt = (Statement) conn.createStatement();
			rs=stmt.executeQuery(sql);
			list=new LinkedList<Px_User>();
			while(rs.next()){
				String user_name=rs.getString("user_name");
				String user_password=rs.getString("user_password");
				String user_email=rs.getString("user_email");
				Long nick_id=rs.getLong("nick_id");
				String nickname=rs.getString("nickname");
				Long rank_id=rs.getLong("rank_id");
				String rank_name=rs.getString("rank_name");
				Px_UserRank userrank=new Px_UserRank();
				Px_UserNickName usernick=new Px_UserNickName();
				userrank.setRank_id(rank_id);
				userrank.setRank_name(rank_name);
				usernick.setNick_id(nick_id);
				usernick.setNick_name(nickname);
				Px_User user=new Px_User();
				user.setUser_email(user_email);
				user.setNickname(usernick);
				user.setRank(userrank);
				user.setUser_name(user_name);
				user.setUser_password(user_password);
				list.add(user);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/* 
	
	* <p>Title: update</p> 
	
	* <p>Description: </p> 
	
	* @param usesr
	* @return 
	
	* @see Dao.Px_UserDAO#update(Model.Px_User) 
	
	*/ 
	@Override
	public boolean update(Px_User user) {
		// TODO Auto-generated method stub
		Connection conn=DBAccess.getConnection();
		boolean result=false;
		String sql="update user,usernickname,userrank set "
				+ "user.user_email= '"+user.getUser_email()+"',user.user_password='"+user.getUser_password()+"'"
				+ ",user.user_name='"+user.getUser_name()+"' , usernickname.nickname='"+user.getNickname().getNick_name()+
				"' , userrank.rank_name= '"+user.getRank().getRank_name()
		+ "' where user.user_email= '"+user.getUser_email()
		+ "' and user.nick_id = usernickname.nick_id and user.rank_id =userrank.rank_id";
		System.out.println(sql);
		try {
			Statement stmt=(Statement) conn.createStatement();
			result=stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return result;
	}

	/* 
	
	* <p>Title: insert</p> 
	
	* <p>Description: </p> 
	
	* @param user
	* @return 
	
	* @see Dao.Px_UserDAO#insert(Model.Px_User) 
	
	*/ 
	@Override
	public boolean insert(Px_User user) {
		boolean result=false;
		String nick_insert="insert into usernickname(nickname) values('"+user.getNickname().getNick_name()+"') ";
		String rank_insert="insert into userrank(rank_name) values('"+user.getRank().getRank_name()+"')";
		String user_insert="insert into user(user_name,user_email,user_password) "
				+ "values('"+user.getUser_name()+"','"+user.getUser_email()+"','"+user.getUser_password()+"')";
		Connection conn=DBAccess.getConnection();
		try {
			Statement stmt=(Statement) conn.createStatement();
			stmt.execute(nick_insert);
			stmt.execute(rank_insert);
			stmt.execute(user_insert);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/* 
	
	* <p>Title: delete</p> 
	
	* <p>Description: </p> 
	
	* @param user
	* @return 
	
	* @see Dao.Px_UserDAO#delete(Model.Px_User) 
	
	*/ 
	@Override
	public boolean delete(Px_User user) {
		// TODO Auto-generated method stub
		String sql="delete from user where user_email ='"+user.getUser_email()+"'";
		boolean result=false;
		Connection conn=DBAccess.getConnection();
		try {
			Statement stmt=(Statement) conn.createStatement();
			result=stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}

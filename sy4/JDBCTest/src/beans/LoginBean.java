package beans;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoginBean {
	private String username;
	private String pwd;
	public void setUsername(String s){
		username=s;
	}	
	public void setPwd(String p){
		pwd=p;
	}

	public String getUsername(){
		return(username);
	}	
	public String getPwd(){
		return(pwd);
	}
	
	//到logintable表中查找是否存在给定username和pwd的用户
    //如果存在，就返回真
	//否则返回假
	static public boolean isExistsInLogintable(String un,String p){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
		  conn=DBConnection.getConnection();
		  String sql = "select * from logintable where username='"+un+"' and password='"+p+"'";
	      ps = conn.prepareStatement(sql);
	      rs = ps.executeQuery();
	      if(rs.next())
	      {
			  return true;
	      }
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				conn.close();
				ps.close();
				rs.close();
				//释放数据库连接资源
			}catch(Exception e){
				e.printStackTrace();
			}
		}		
		return false;		
	}
	public static boolean insertBeantoDB(String username, String pwd)
	{
		Connection conn=null;
		Statement ps=null;
		try {
			conn=DBConnection.getConnection();
			ps=conn.createStatement();
			String sql1=" insert into logintable (username,password) values("+
					"\'"+username+"\'"+","+
					"\'"+pwd+"\'"+")";
			ps.executeUpdate(sql1);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try{
				conn.close();
				ps.close();
				//释放数据库连接资源
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return false;
	}
	//是否为管理员登录
	static public boolean isManager(String un,String pas){
		if ("abc".equals(un)&& "abc".equals(pas))
		{
			return true;
		}
		return false;
	}
	//删除
	static public boolean deletedelogin(String name) {
		Connection conn=null;
		PreparedStatement preparedStatement = null;
		String sql2="delete from logintable where username=?";
		try {
			conn=DBConnection.getConnection();
			preparedStatement=conn.prepareStatement(sql2);
			preparedStatement.setString(1,name);
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	//获得bean
	static public List<LoginBean> getALLusers()
	{
		List<LoginBean> list=new ArrayList<>();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			Connection connection=DBConnection.getConnection();
			String sql="select * from logintable";
			preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			while (resultSet.next())
			{
				if (!resultSet.getString("username").equals("abc"))
				{
					LoginBean loginBean=new LoginBean();
					loginBean.setUsername(resultSet.getString("username"));
					loginBean.setPwd(resultSet.getString("password"));
					list.add(loginBean);
				}
			}
			connection.close();
			preparedStatement.close();
			resultSet.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}

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
	
	//��logintable���в����Ƿ���ڸ���username��pwd���û�
    //������ڣ��ͷ�����
	//���򷵻ؼ�
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
				//�ͷ����ݿ�������Դ
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
				//�ͷ����ݿ�������Դ
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return false;
	}
	//�Ƿ�Ϊ����Ա��¼
	static public boolean isManager(String un,String pas){
		if ("abc".equals(un)&& "abc".equals(pas))
		{
			return true;
		}
		return false;
	}
	//ɾ��
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
	//���bean
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

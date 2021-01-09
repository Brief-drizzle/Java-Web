package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBConnection {

	   public static Connection getConnection() throws Exception{
	    	Connection conn=null;
//	    	
//	    	//加载Sqlserver数据库驱动程序，sqljdbc4.jar可以省略本句，sqljdbc.jar不可以
//	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
//	   
//	    	//创建连接
//	    	String dburl="jdbc:sqlserver://localhost:1433;databaseName=txdatabase";
//	    	String sqlUser="sa";
//	    	String sqlPwd="123";    	
//	    	conn=DriverManager.getConnection(dburl,sqlUser,sqlPwd);
	 /*
	    	//或者使用下面的dburl创建连接
	    	String dburl="jdbc:sqlserver://localhost:1433;databaseName=txdatabase;user=sa;password=123";
	    	conn=DriverManager.getConnection(dburl);
	 */   	
	    	/*
	    	 * 以上为SQL Server数据库的连接方式
	    	 */
	    	
	    	Class.forName("com.mysql.jdbc.Driver");
	    	String url="jdbc:mysql://localhost:3307/loginuser";
	    	conn=DriverManager.getConnection(url,"root","root");
	    	
	    	return conn;
	    }
		
	    //释放资源
	    public static void dbClose(Connection conn,PreparedStatement ps,ResultSet rs)
	    throws SQLException
	    {
	          rs.close();
	          ps.close();
	          conn.close();
	      }

	
}

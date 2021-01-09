package beans;

import java.sql.*;

public class DetailedInfoBean {
	//������Ԫ�ض�Ӧ��bean����
	private String username;
	private int    age;
	private String sexy;
	private String pictureLocation;
	
	//��Ԫ�ص�setter����	
	public void setUsername(String u){
		username=u;
	}
	
	public void setAge(int a){
		age=a;
	}
	
	public void setSexy(String s){
		sexy=s;
	}
	
	public void setPictureLocation(String pl){
		pictureLocation=pl;
	}
	
//��Ԫ�ص�getter����	
	public String getUsername(){
		return(username);
	}
	
	public int getAge(){
		return(age);
	}
	
	public String getSexy(){
		return(sexy);
	}
	
	public String getPictureLocation(){
		return(pictureLocation);
	}
	
	//��bean���Ե�ֵ����detailedinfo����
	//�ɹ�����ture,ʧ�ܷ���false
	public static boolean insertBeantoDB(String username, int age, String sexy, String pictureLocation){
		Connection conn=null;
		Statement st=null;				
		try{
			conn=DBConnection.getConnection();
			st=conn.createStatement();
			//��bean����ƴ�ӳ�Insert���
			String sql1 = "insert into detailedinfo(username,age,sexy,picturelocation) values("+
							"\'"+username+"\'"+","+
							age+","+
							"\'"+sexy+"\'"+","+
							"\'"+pictureLocation+"\'"+")";
			st.executeUpdate(sql1);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				conn.close();
				st.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return false;
	}
	
	//�����ݿ��в����Ƿ���ڸ���username�Ŀͻ�
    //������ڣ��ʹ���һ���й���ϸ��ϢDetailedInfoBean��ʵ��
	//���򷵻�Null
	static public DetailedInfoBean getDetailedInfoBean(String un){
		DetailedInfoBean bb=null;
		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=DBConnection.getConnection();
			//���logintable���д��ڸ���username�ļ�¼
			//���ȡ��Ӧ��¼��ÿ���ֶε�ֵ��д��bean
			  String sql = "select * from detailedinfo where username='"+un+"'";
		      ps = conn.prepareStatement(sql);
		      rs = ps.executeQuery();        
		      if(rs.next()) {
		    	  bb=new DetailedInfoBean();
		    	  bb.setUsername(rs.getString("username"));
		    	  bb.setAge(rs.getInt("age"));
		    	  bb.setSexy(rs.getString("sexy"));
		    	  bb.setPictureLocation(rs.getString("picturelocation"));
	         }	       
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				DBConnection.dbClose(conn,ps,rs);
				//�ͷ����ݿ�������Դ
			}catch(Exception e){
				e.printStackTrace();
			}
		}		
		return bb;		
	}
	//ɾ��
	static public boolean deletedetailed(String name)  {
		Connection conn=null;
		PreparedStatement preparedStatement = null;
		String sql1="delete from detailedinfo where username=?";
		try {
			conn=DBConnection.getConnection();
			preparedStatement=conn.prepareStatement(sql1);
			preparedStatement.setString(1,name);
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}

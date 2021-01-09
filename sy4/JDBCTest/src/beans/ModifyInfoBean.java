package beans;
import java.sql.*;

public class ModifyInfoBean {
    private String username;
    private int    age;
    private String sexy;
    private String pictureLocation;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSexy() {
        return sexy;
    }

    public void setSexy(String sexy) {
        this.sexy = sexy;
    }

    public String getPictureLocation() {
        return pictureLocation;
    }

    public void setPictureLocation(String pictureLocation) {
        this.pictureLocation = pictureLocation;
    }

    public static boolean updateBeanToDB(String username, int age, String sexy, String pictureLocation) throws SQLException {
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            conn=DBConnection.getConnection();
            String sql="update detailedinfo set age=?,sexy=?,picturelocation=? where username=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, String.valueOf(age));
            ps.setString(2,sexy);
            ps.setString(3,pictureLocation);
            ps.setString(4,username);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    static public ModifyInfoBean getDetailedInfoBean(String un){
        ModifyInfoBean bb=null;

        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            conn=DBConnection.getConnection();
            //如果logintable表中存在给定username的记录
            //则获取对应记录的每个字段的值，写入bean
            String sql = "select * from detailedinfo where username='"+un+"'";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()) {
                bb=new ModifyInfoBean();
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
                //释放数据库连接资源
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return bb;
    }
}

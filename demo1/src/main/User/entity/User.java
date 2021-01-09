package entity;


/**
 * @author ad
 */
public class User {
    /** 用户ID */
    private String userId;
    /** 用户密码 */
    private String password;
    /** 用户类型，1代表管理员，2代表教师，3代表学生 */
    private Integer role;

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getRole() {
        return this.role;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) {return false;}
        User that = (User) o;
        return userId.equals(that.userId);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(userId);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ",password='" + password + "'" +
                ",role='" + role + "'" +
                '}';
    }

}
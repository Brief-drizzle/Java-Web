package user.entity;


public class Teacher {
	/** 教师ID */
	private String teacherId;
	/** 姓名 */
	private String name;
	/** 性别 */
	private String sex;
	/** 教师职称 */
	private String protitle;
	/** 手机号 */
	private String phone;
	/** 用户ID */
	private String userId;

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	
	public String getTeacherId() {
		return this.teacherId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getSex() {
		return this.sex;
	}
	
	public void setProtitle(String protitle) {
		this.protitle = protitle;
	}
	
	public String getProtitle() {
		return this.protitle;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserId() {
		return this.userId;
	}
	

	@Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) {return false;}
        Teacher that = (Teacher) o;
        return teacherId.equals(that.teacherId);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(teacherId);
    }
    
    @Override
    public String toString() {
        return "Teacher{" +
				"teacherId=" + teacherId +
						",name='" + name + "'" + 
						",sex='" + sex + "'" + 
						",protitle='" + protitle + "'" + 
						",phone='" + phone + "'" + 
						",userId='" + userId + "'" + 
		                '}';
    }
	
}
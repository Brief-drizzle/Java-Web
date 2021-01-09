package user.entity;


public class Student {
	/** 学号 */
	private String studentId;
	/** 姓名 */
	private String name;
	/** 性别 */
	private String sex;
	/** 专业 */
	private String major;
	/** 班级 */
	private String classes;
	/** 用户ID */
	private String userId;

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	public String getStudentId() {
		return this.studentId;
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
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	public String getMajor() {
		return this.major;
	}
	
	public void setClasses(String classes) {
		this.classes = classes;
	}
	
	public String getClasses() {
		return this.classes;
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
        Student that = (Student) o;
        return studentId.equals(that.studentId);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(studentId);
    }
    
    @Override
    public String toString() {
        return "Student{" +
				"studentId=" + studentId +
						",name='" + name + "'" + 
						",sex='" + sex + "'" + 
						",major='" + major + "'" + 
						",class='" + classes + "'" +
						",userId='" + userId + "'" + 
		                '}';
    }
	
}
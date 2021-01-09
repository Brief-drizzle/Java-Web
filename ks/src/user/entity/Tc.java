package user.entity;


public class Tc {
	/** TCID */
	private String tcId;
	/** 课程ID */
	private String courseId;
	/** 教师ID */
	private String teacherId;
	/** 身份（主讲教师或者团队教师） 1主讲，2团队*/
	private String teaIdentity;
	/** 授课学时 */
	private Integer teachHour;

	public void setTcId(String tcId) {
		this.tcId = tcId;
	}
	
	public String getTcId() {
		return this.tcId;
	}
	
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	
	public String getCourseId() {
		return this.courseId;
	}
	
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	
	public String getTeacherId() {
		return this.teacherId;
	}
	
	public void setTeaIdentity(String teaIdentity) {
		this.teaIdentity = teaIdentity;
	}
	
	public String getTeaIdentity() {
		return this.teaIdentity;
	}
	
	public void setTeachHour(Integer teachHour) {
		this.teachHour = teachHour;
	}
	
	public Integer getTeachHour() {
		return this.teachHour;
	}
	

	@Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) {return false;}
        Tc that = (Tc) o;
        return tcId.equals(that.tcId);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(tcId);
    }
    
    @Override
    public String toString() {
        return "Tc{" +
				"tcId=" + tcId +
						",courseId='" + courseId + "'" + 
						",teacherId='" + teacherId + "'" + 
						",teaIdentity='" + teaIdentity + "'" + 
						",teachHour='" + teachHour + "'" + 
		                '}';
    }
	
}